package com.oa.hjc.dao;

import java.sql.SQLException;

import com.oa.hjc.bean.Skdept;
import com.oa.hjc.bean.manager;


public interface UserDao {
	public int insert(manager u) throws SQLException;
	public int insert(Skdept u) throws SQLException;
	public manager getUserByName(String name) throws SQLException;
	public Skdept getUserByName1(String name) throws SQLException;
	public manager login(String name,String pass) throws SQLException;

	
}
