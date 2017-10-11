package com.oa.hjc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	//oralce数据库驱动类名
	static String driverName="oracle.jdbc.driver.OracleDriver";
	//连接描述字符串
	String url="jdbc:oracle:thin:@localhost:1521:XE";//2、定义连接数据库的统一资源定义符
	String userName="cccong";
	String password="ccc";
	
	//连接对象
	Connection con;
	
	static{
		try {
			//加载并注册驱动
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获得连接对象方法
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException
	{
		return con=DriverManager.getConnection(url,userName,password);
	}
	/**
	 * 执行sql查询方法
	 * @param sql 动态查询语句,形如 select * from emp where empno=?
	 * @param objects 动态参数对象，自动把sql后面的所有参数，组装成一个objects数组
	 * @return 返回结果集
	 * @throws SQLException
	 */
	public ResultSet select(String sql,Object...objects ) throws SQLException
	{
		getConnection();
		PreparedStatement ps= con.prepareStatement(sql);//获取可设置参数的sql语句对象
		//循环为每个参数设定值 
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i+1,objects[i] );//设值 
		}
		return ps.executeQuery();//执行前面准备好sql
	}
	/**
	 * 包含插入、修改、删除
	 * @param sql 动态查询语句,形如 update emp set ename=? where empno=?
	 * @param objects 动态参数对象，自动把sql后面的所有参数，组装成一个objects数组
	 * @return  返回 受影响的行数
	 * @throws SQLException
	 */
	public int update(String sql,Object...objects ) throws SQLException
	{
		getConnection();
		PreparedStatement ps= con.prepareStatement(sql);
		//循环为每个参数设定值 
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i+1,objects[i] );
		}
		int k= ps.executeUpdate();//受影响的行数
		close(null, ps);
		return k;
	}
	
	/**
	 * 批量更新
	 * @return 
	 * @throws SQLException 
	 */
	public PreparedStatement batchUpdate(String sql) throws SQLException
	{
		getConnection();
		con.setAutoCommit(false);//去除自动提交功能
		PreparedStatement ps= con.prepareStatement(sql);
		return ps;
	}
	/**
	 * 批量更新提交
	 * @param ps
	 * @return
	 * @throws SQLException
	 */
	public int[] batchCommit(PreparedStatement ps) throws SQLException{
		
		int[] ks=ps.executeBatch();
		con.commit();
		con.setAutoCommit(true);
		return ks;
	}
	
	
	/**
	 * 关闭数据连接中产生的各种对象
	 * @param rs
	 * @param ps
	 */
	public void close(ResultSet rs,PreparedStatement ps)
	{
		try {
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(null);
	}
	public void close(ResultSet rs)
	{
		try {
			if(rs!=null)
				rs.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
