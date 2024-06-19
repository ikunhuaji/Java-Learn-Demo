package com.starrysky.androidhomeworkservlet.Dao;

import com.starrysky.androidhomeworkservlet.entity.User;

import java.sql.*;

public class UserInfoDao {

    public static final String defaultAvatar = "https://t11.baidu.com/it/u=4241520012,198480940&fm=30&app=106&f=JPEG?w=640&h=615&s=36381A8AC8D707E3560DBD6C03005040";

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root",
                    "xjl13615875481"
            );

            return con;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int getSize(){
        PreparedStatement ps = null;
        ResultSet rs = null;

        int cnt=0;
        Connection con = getCon();

        String sql = "select count(*) from tbl_userinfo";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                cnt = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(rs,ps,con);
        return  cnt;
    }

    public static void saveUser(User user){
        String userName = user.getUserName();
        String pwd = user.getPwd();
        String email = user.getEmail();
        String nickName = user.getNickName();
        int id = user.getId();

        PreparedStatement ps = null;
        Connection con = getCon();
        String sql = "insert into tbl_userinfo values(?,?,?,?,?,?)";

        try {
            ps=con.prepareStatement(sql);

            ps.setString(1,userName);
            ps.setString(2,pwd);
            ps.setString(3,email);
            ps.setString(4,nickName);
            ps.setInt(5,id);
            ps.setString(6,defaultAvatar);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static int findByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        int id=0;

        String sql="select id from tbl_userinfo where userName = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();

            if(rs.next()){
                 id= rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(rs,ps,con);
        return id;
    }

    public static User findInfo(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String userName = null;
        String pwd = null;
        String email = null;
        String nickName = null;
        String avatar = null;
        int id = 0;

        String sql="select * from tbl_userinfo where userName = ?";

        try {
            ps =con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();

            if(rs.next()){
                userName = rs.getString(1);
                pwd = rs.getString(2);
                email = rs.getString(3);
                nickName = rs.getString(4);
                id = rs.getInt(5);
                avatar = rs.getString(6);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);
        User user = new User(userName,pwd,email,nickName,id,avatar);
        return user;
    }

    public static void updateUserInfo(int id,User user){
        String userName = user.getUserName();
        String pwd = user.getPwd();
        String email = user.getEmail();
        String nickName = user.getNickName();
        String avatar = user.getAvatar();

        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "update tbl_userinfo set userName = ?, pwd = ?, email = ?, nickName = ?, avatar = ? where id = ?";

        try {
            ps=con.prepareStatement(sql);

            ps.setString(1,userName);
            ps.setString(2,pwd);
            ps.setString(3,email);
            ps.setString(4,nickName);
            ps.setString(5,avatar);
            ps.setInt(6,id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps,Connection con){
        try {
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
