package com.starrysky.cakelesson.comment.dao;

import com.starrysky.cakelesson.entity.Cake;
import com.starrysky.cakelesson.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDao {
    public void saveComment(String id,String content,String email){
        Connection con=null;
        PreparedStatement ps = null;

        try {
            con= DbUtil.getCon();
            ps=con.prepareStatement("insert into tbl_comment values (?,?,?,?)");
            ps.setString(1,content);
            ps.setString(2,new Date().toLocaleString());
            ps.setString(3,email);
            ps.setInt(4,Integer.parseInt(id));

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        DbUtil.close(ps,con);
    }
}
