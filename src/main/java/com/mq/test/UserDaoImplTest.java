package com.mq.test;

import com.mq.dao.UserDao;
import com.mq.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void TestQueryAll() {

        UserDao dao = new UserDaoImpl();
        dao.queryAll("select * from member where mobile = 15601797971","mobile","reg_no");
    }
}
