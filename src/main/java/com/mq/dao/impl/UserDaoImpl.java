package com.mq.dao.impl;

import com.mq.dao.UserDao;
import com.mq.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    @Override
    public void queryAll() {

    }

    @Override
    public void queryAll(String sql,String valueA,String valueB) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Connection cnn = JDBCUtil.getConn();
            st = cnn.createStatement();
            sql = "select * from member where mobile = '15601797971'";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                valueA = rs.getString(valueA);
                valueB = rs.getString(valueB);

                System.out.println(valueA.toString() + " = "+valueA + "      " + valueB.toString() + "=" +valueB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
