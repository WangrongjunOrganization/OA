package com.oa.pub.bean;

import java.sql.SQLException;

import com.oa.hjc.service.UserService;
import com.oa.hjc.service.UserServiceImpl;

public class Manager {
    int id;
    String name;
    String pass;
    String explanation1;
    String explanation2;
    String explanation3;

    public Manager(String name, String pass, String explanation1, String explanation2, String explanation3) {
        this(0, name, pass, explanation1, explanation2, explanation3);
    }

    public Manager(int id, String name, String pass, String explanation1,
                   String explanation2, String explanation3) {
        super();
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.explanation1 = explanation1;
        this.explanation2 = explanation2;
        this.explanation3 = explanation3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getExplanation1() {
        return explanation1;
    }

    public void setExplanation1(String explanation1) {
        this.explanation1 = explanation1;
    }

    public String getExplanation2() {
        return explanation2;
    }

    public void setExplanation2(String explanation2) {
        this.explanation2 = explanation2;
    }

    public String getExplanation3() {
        return explanation3;
    }

    public void setExplanation3(String explanation3) {
        this.explanation3 = explanation3;
    }

    @Override

    public String toString() {
        return "manager [id=" + id + ", name=" + name + ", pass=" + pass
                + ", explanation1=" + explanation1 + ", explanation2="
                + explanation2 + ", explanation3=" + explanation3 + "]";
    }


    String validateErrorMsg;

    public String getValidateErrorMsg() {
        return validateErrorMsg;
    }

    public boolean validate() {
        UserService us = UserServiceImpl.getInstance();
        if (getName() == null || getName().equals("")) {
            validateErrorMsg = "添加失败，用户名为空";
            System.out.println("添加失败，用户名为空");
            return false;
        }

        if (getPass() == null || getPass().equals("")) {
            validateErrorMsg = "添加失败，密码为空";
            System.out.println("添加失败，密码为空");
            return false;
        }
        try {
            if (us.getUserByName(name) != null) {
                validateErrorMsg = "添加失败，用户名已经存在";
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            validateErrorMsg = "添加失败，用户名已经存在";
            return false;
        }
        return true;
    }
}
