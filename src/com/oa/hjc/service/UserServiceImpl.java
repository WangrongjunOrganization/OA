package com.oa.hjc.service;

import java.sql.SQLException;

import com.oa.hjc.bean.Skdept;
import com.oa.pub.bean.manager;
import com.oa.hjc.dao.UserDao;
import com.oa.hjc.dao.UserDaoImpl;


public class UserServiceImpl implements UserService {
	UserDao ud=new UserDaoImpl();
	
	static UserService us=new UserServiceImpl();
	
	
	private UserServiceImpl()
	{
		
	}
	
	static public UserService getInstance()
	{
		return us;
	}
	
	@Override
	public int insert(manager u) throws SQLException {
		// TODO Auto-generated method stub
		return ud.insert(u);
	}

	@Override
	public manager getUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return ud.getUserByName(name);
	}

	@Override
	public manager login(String name, String pass) throws SQLException {
		// TODO Auto-generated method stub
		return ud.login(name, pass);
	}

	public int insert(Skdept u) throws SQLException {
		// TODO Auto-generated method stub
		return ud.insert(u);
	}
	@Override
	public Skdept getUserByName1(String name) throws SQLException {
		// TODO Auto-generated method stub
		return ud.getUserByName1(name);
	}


	
}
