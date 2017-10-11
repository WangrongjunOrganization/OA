package com.oa.hjc.service;

import com.oa.hjc.dao.UserDao;
import com.oa.hjc.dao.UserDaoImpl;
import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.Manager;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    static UserService us = new UserServiceImpl();

    private UserServiceImpl() {
    }

    static public UserService getInstance() {
        return us;
    }

    @Override
    public int insert(Manager u) throws SQLException {
        // TODO Auto-generated method stub
        return ud.insert(u);
    }

    @Override
    public Manager getUserByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return ud.getUserByName(name);
    }

    @Override
    public Manager login(String name, String pass) throws SQLException {
        // TODO Auto-generated method stub
        return ud.login(name, pass);
    }

    public int insert(SkDept u) throws SQLException {
        // TODO Auto-generated method stub
        return ud.insert(u);
    }

    @Override
    public SkDept getUserByName1(String name) throws SQLException {
        // TODO Auto-generated method stub
        return ud.getUserByName1(name);
    }

}
