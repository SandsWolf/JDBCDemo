package com.mq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtil {

    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String password = null;

    /**
     * 读取jdbc配置文件
     */
    static {

        try {
            //1.创建一个属性配置对象
            Properties properties = new Properties();

            //2.导入输入流
//            InputStream is = new FileInputStream("D:\\IdeaProjects\\JDBC\\src\\main\\java\\com\\mq\\jdbc.propreties");
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.propreties");

            properties.load(is);

            //3.读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取JDBC连接对象
     * @return
     */
    public static Connection getConn() {

        Connection conn = null;

        try {
            //1.注册驱动
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //Class.forName(xxx.xx.xx)返回的是一个类。
            //Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
            Class.forName(driverClass);
            //2.建立连接
            //DriverManager.getConnection("jdbc:mysql://10.0.3.200:3306/atzuchedb?user=autoDev&password=auto2015");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */

    public static void release(Connection conn,Statement st,ResultSet rs) {
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    private static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }


    private static void closeSt(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            st = null;
        }
    }

    private static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}
