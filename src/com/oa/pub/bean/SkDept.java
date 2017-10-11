package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/9.
 */
public class SkDept {

    @Id
    @GeneratedValue
    private int id;// 部门编号
    private String name;// 名称 notnull
    @ManyToOne
    private MaTable type;// 类型（公司、部门） notnull
    private String tele;// 电话 notnull
    private String fax;// 传真 notnull
    private String discrip;// 描述
    @ManyToOne
    private SkDept superDept;// 上级部门
    private Date createTime;// 成立日期
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public SkDept() {
    }

    public SkDept(String name, MaTable type, String tele, String fax, String discrip, SkDept superDept,
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

    public MaTable getType() {
        return type;
    }

    public void setType(MaTable type) {
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
}
