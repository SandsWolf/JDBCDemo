package com.mq.dao;

public interface UserDao {
    void queryAll();
    void queryAll(String sql,String valueA,String valueB);
}
