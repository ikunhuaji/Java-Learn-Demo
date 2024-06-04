package com.starrysky.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {

    private static Properties properties;

    static {
        //加载驱动
        try{

            InputStream inputStream = DbUtil.class.getResourceAsStream("/jdbc.properties");
            properties = new Properties();

            properties.load(inputStream);

            Class.forName(properties.getProperty("jdbc.driverClassName"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try {
            //获取数据库连接
            Connection con = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );

            return con;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstm,Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(PreparedStatement pstm){
        try{
            ResultSet rs = pstm.executeQuery();

            return rs;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int excuteUpdate(PreparedStatement pstm){
        try{
            int count = pstm.executeUpdate();
            return count;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return 0;
    }
}
