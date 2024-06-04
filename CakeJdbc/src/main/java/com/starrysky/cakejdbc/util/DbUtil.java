package com.starrysky.cakejdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    private static Properties properties;

    static {
        //加载驱动
        try{
            properties = new Properties();
            InputStream inputStream = DbUtil.class.getResourceAsStream("/jdbc.properties");
            properties.load(inputStream);

            Class.forName("com.mysql.cj.jdbc.Driver");
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

}
