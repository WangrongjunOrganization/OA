package com.oa.hjc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.Manager;
import com.oa.hjc.db.DataBase;


public class UserDaoImpl implements UserDao {
    DataBase db = new DataBase();

    public int insert(Manager u) throws SQLException {
        String sql = "insert into manager(id,name,pass,explanation1,explanation2,explanation3) values(xulie.nextval,?,?,?,?,?)";
        return db.update(sql, u.getName(), u.getPass(), u.getExplanation1(), u.getExplanation2(), u.getExplanation3());
    }

    public int insert(SkDept u) throws SQLException {
        String sql = "insert into skdept(id,name,type,tele,fax,discrip,sksuper,createtime) values(xulie.nextval,?,?,?,?,?,?,?)";

        Timestamp timestamp = new Timestamp(u.getCreateTime().getTime());
        int superDeptId = u.getSuperDept().getId();
        return db.update(sql, u.getName(), u.getType(), u.getTele(), u.getFax(), u.getDiscrip(), superDeptId, timestamp);
    }

    @Override
    public Manager getUserByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        String sql = "select * from manager where name=?";
        ResultSet rs = db.select(sql, name);
        Manager user = null;
        if (rs.next()) {
            int id = rs.getInt("id");
            user = new Manager(id, rs.getString("name"), rs.getString("pass"), rs.getString("explanation1"), rs.getString("explanation2"), rs.getString("explanation3"));
        }
        db.close(rs);
        return user;
    }

    @Override
    public Manager login(String name, String pass) throws SQLException {
        // TODO Auto-generated method stub
        String sql = "select * from manager where name=? and pass=?";
        ResultSet rs = db.select(sql, name, pass);
        Manager user = null;
        if (rs.next()) {
            user = new Manager(rs.getInt("id"), rs.getString("name"), rs.getString("pass"), rs.getString("explanation1"), rs.getString("explanation2"), rs.getString("explanation3"));
        }
        return user;
    }

    @Override
    public SkDept getUserByName1(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }


}
