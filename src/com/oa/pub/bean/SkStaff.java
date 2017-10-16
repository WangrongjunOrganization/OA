package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/15.
 */
public class SkStaff {// 员工-岗位关联表<正式员工>

    @Id
    @GeneratedValue
    private int id;// 主键
    @OneToOne
    private SkEmp emp;// 正式员工
    @ManyToOne
    private SkJob job;// 岗位
    private Date time;// 转正日期
    @ManyToOne
    private MaTable source;// 人才来源（校园招聘，社会招聘，其他）
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public SkStaff() {
    }

    public SkStaff(SkEmp emp, SkJob job, Date time, MaTable source) {
        this.emp = emp;
        this.job = job;
        this.time = time;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SkEmp getEmp() {
        return emp;
    }

    public void setEmp(SkEmp emp) {
        this.emp = emp;
    }

    public SkJob getJob() {
        return job;
    }

    public void setJob(SkJob job) {
        this.job = job;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MaTable getSource() {
        return source;
    }

    public void setSource(MaTable source) {
        this.source = source;
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
