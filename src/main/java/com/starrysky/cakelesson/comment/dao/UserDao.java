package com.starrysky.cakelesson.comment.dao;

import com.starrysky.cakelesson.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {
    public void addScore(String email,int sc){
        Connection con=null;
        PreparedStatement ps = null;

        try {
            con= DbUtil.getCon();
            ps=con.prepareStatement("update tbl_user set score = score + ? where email = ?");
            ps.setInt(1,sc);
            ps.setString(2,email);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        DbUtil.close(ps,con);
    }
}
