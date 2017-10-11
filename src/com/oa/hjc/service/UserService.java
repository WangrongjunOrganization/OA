package com.oa.hjc.service;

import java.sql.SQLException;

import com.oa.hjc.bean.Skdept;
import com.oa.pub.bean.manager;


public interface UserService {

	public int insert(manager u) throws SQLException;
	
	public int insert(Skdept u) throws SQLException;
		
	
	public Skdept getUserByName1(String name) throws SQLException;
	public manager getUserByName(String name) throws SQLException;
	
	public manager login(String name,String pass) throws SQLException;
}
