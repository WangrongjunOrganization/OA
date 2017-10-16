package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/15.
 */
public class Temporary {// 员工-岗位关联表（试用期）

    @Id
    @GeneratedValue
    private int id;// 主键
    @ManyToOne
    private SkEmp emp;// 入职员工
    @ManyToOne
    private SkJob job;// 岗位
    private Date beginTime;// 试用期开始日期
    private Date endTime;// 试用期结束日期
    @ManyToOne
    private MaTable result;// 考核结果（转正、延期、不予录用）
    private Date dealTime;// 处理日期（由考核结果决定含义。转正-转正日期，延期-延期日期，不予录用-离职日期。）
    @ManyToOne
    private SkEmp ope;// 操作人员（审核人员）
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public Temporary() {
    }

    public Temporary(SkEmp emp, SkJob job, Date beginTime) {
        this.emp = emp;
        this.job = job;
        this.beginTime = beginTime;
    }

    public Temporary(SkEmp emp, SkJob job, Date beginTime, Date endTime, MaTable result, Date dealTime, SkEmp ope) {
        this.emp = emp;
        this.job = job;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.result = result;
        this.dealTime = dealTime;
        this.ope = ope;
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public MaTable getResult() {
        return result;
    }

    public void setResult(MaTable result) {
        this.result = result;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public SkEmp getOpe() {
        return ope;
    }

    public void setOpe(SkEmp ope) {
        this.ope = ope;
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
