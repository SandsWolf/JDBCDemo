package com.mq.test;

import com.mq.util.JDBCUtil;

import java.sql.*;

public class MainTest {
    public static void main(String args[]) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try {

            conn = JDBCUtil.getConn();

            //3.创建statement， （操作数据库的对象）
            st = conn.createStatement();

            //4.执行查询
            String sql = "select * from member where mobile = '15601797971'";
            rs = st.executeQuery(sql);

            //5.遍历查询结果
            while(rs.next()) {
                int id = rs.getInt("id");
                String mobile = rs.getString("mobile");
                String regNo = rs.getString("reg_no");

                System.out.println("id = "+id+"   mobile = "+mobile+"   regNo = "+regNo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源

            JDBCUtil.release(conn,st,rs);

        }

    }
}
