package com.oa.hjc.dao;

import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.Manager;

import java.sql.SQLException;


public interface UserDao {
	public int insert(Manager u) throws SQLException;
	public int insert(SkDept u) throws SQLException;
	public Manager getUserByName(String name) throws SQLException;
	public SkDept getUserByName1(String name) throws SQLException;
	public Manager login(String name, String pass) throws SQLException;
}
