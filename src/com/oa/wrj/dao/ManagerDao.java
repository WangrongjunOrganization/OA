//package com.oa.hjc.dao;
package com.oa.wrj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oa.hjc.db.DataBase;
import com.oa.pub.bean.Manager;

public class ManagerDao {

    DataBase db = new DataBase();
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    //连接描述字符串
    String url = "jdbc:oracle:thin:@localhost:1521:XE";//2、定义连接数据库的统一资源定义符
    String userName = "cccong";
    String password = "ccc";

    //连接对象
    Connection con;
    PreparedStatement ps;

    static {
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
     */
    public Connection getConnection() throws SQLException {
        return con = DriverManager.getConnection(url, userName, password);
    }

    public Manager queryById(int managerId) throws SQLException {
        String sql = "select * from Manager where id=" + managerId;
        List<Manager> list = executeQuery(sql);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * @param name 根据名字进行模糊查询
     */
    public List<Manager> queryByName(String name) throws SQLException {
        String sql = "select * from Manager where name like '%" + name + "%'";
        return executeQuery(sql);
    }

    private List<Manager> executeQuery(String sql) throws SQLException {
        List<Manager> managerList = new ArrayList<>();

        getConnection();// 打开数据库连接
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);// 执行sql语句
        while (rs.next()) {
            Manager manager = new Manager(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("pas"),
                    rs.getString("explanation1"),
                    rs.getString("explanation2"),
                    rs.getString("explanation3"));
            managerList.add(manager);
        }
        return managerList;
    }

}
