package com.oa.hjc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.oa.hjc.bean.Skdept;
import com.oa.hjc.bean.manager;
import com.oa.hjc.db.DataBase;


public class UserDaoImpl implements UserDao {
	DataBase db=new DataBase();
	
	public int insert(manager u) throws SQLException
	{
		String sql="insert into manager(id,name,pass,explanation1,explanation2,explanation3) values(xulie.nextval,?,?,?,?,?)";
		return db.update(sql, u.getName(),u.getPass(),u.getExplanation1(),u.getExplanation2(),u.getExplanation3());
	}
	public int insert(Skdept u) throws SQLException
	{
		String sql="insert into skdept(id,name,type,tele,fax,discrip,sksuper,createtime) values(xulie.nextval,?,?,?,?,?,?,?)";
		
		Timestamp timestamp = new Timestamp(u.getDate().getTime());
		return db.update(sql, u.getName(),u.getType(),u.getTele(),u.getFax(),u.getDiscrip(),u.getSksuper(),timestamp);
	}
	@Override
	public manager getUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from manager where name=?";
		ResultSet rs= db.select(sql, name);
		manager user=null;
		if(rs.next())
		{
			int id=rs.getInt("id");
			user= new manager(id,rs.getString("name"),rs.getString("pass"),rs.getString("explanation1"),rs.getString("explanation2"),rs.getString("explanation3"));
		}
		db.close(rs);
		return user;
	}

	@Override
	public manager login(String name, String pass) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from manager where name=? and pass=?";
		ResultSet rs= db.select(sql, name,pass);
		manager user=null;
		if(rs.next())
		{
			user= new manager(rs.getInt("id"),rs.getString("name"),rs.getString("pass"),rs.getString("explanation1"),rs.getString("explanation2"),rs.getString("explanation3"));
		}
		return user;
	}
	@Override
	public Skdept getUserByName1(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
