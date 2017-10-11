package com.oa.hjc.dao;

import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.manager;

import java.sql.SQLException;


public interface UserDao {
	public int insert(manager u) throws SQLException;
	public int insert(SkDept u) throws SQLException;
	public manager getUserByName(String name) throws SQLException;
	public SkDept getUserByName1(String name) throws SQLException;
	public manager login(String name,String pass) throws SQLException;
}
