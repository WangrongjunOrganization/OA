package com.oa.pub.bean;

import com.oa.hjc.service.UserService;
import com.oa.hjc.service.UserServiceImpl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * by wangrongjun on 2017/10/9.
 */
public class SkDept {

    @Id
    @GeneratedValue
    private int id;// 部门编号
    private String name;// 名称 notnull
    private String type;// 类型（公司、部门） notnull
    private String tele;// 电话 notnull
    private String fax;// 传真 notnull
    private String discrip;// 描述
    @ManyToOne
    private SkDept superDept;// 上级部门
    private Date createTime;// 成立日期
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3
    @OneToMany
    private List<SkJob> jobList;

    public SkDept() {
    }

    public SkDept(int id) {
        this.id = id;
    }

    public SkDept(String name, String type, String tele, String fax, String discrip, SkDept superDept, Date createTime) {
        this.name = name;
        this.type = type;
        this.tele = tele;
        this.fax = fax;
        this.discrip = discrip;
        this.superDept = superDept;
        this.createTime = createTime;
    }

    public SkDept(String name, String type, String tele, String fax, String discrip, SkDept superDept,
                  Date createTime, String explanation1, String explanation2, String explanation3) {
        this.name = name;
        this.type = type;
        this.tele = tele;
        this.fax = fax;
        this.discrip = discrip;
        this.superDept = superDept;
        this.createTime = createTime;
        this.explanation1 = explanation1;
        this.explanation2 = explanation2;
        this.explanation3 = explanation3;
    }

    @Override
    public String toString() {
        return "SkDept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tele='" + tele + '\'' +
                ", fax='" + fax + '\'' +
                ", discrip='" + discrip + '\'' +
                ", superDept=" + superDept +
                ", createTime=" + createTime +
                ", explanation1='" + explanation1 + '\'' +
                ", explanation2='" + explanation2 + '\'' +
                ", explanation3='" + explanation3 + '\'' +
                ", validateErrorMsg='" + validateErrorMsg + '\'' +
                '}';
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

        if (getFax() == null || getFax().equals("")) {
            validateErrorMsg = "添加失败，部门为空";
            System.out.println("添加失败，部门为空");
            return false;
        }
        try {
            if (us.getUserByName1(name) != null) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDiscrip() {
        return discrip;
    }

    public void setDiscrip(String discrip) {
        this.discrip = discrip;
    }

    public SkDept getSuperDept() {
        return superDept;
    }

    public void setSuperDept(SkDept superDept) {
        this.superDept = superDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public List<SkJob> getJobList() {
        return jobList;
    }

    public void setJobList(List<SkJob> jobList) {
        this.jobList = jobList;
    }
}
