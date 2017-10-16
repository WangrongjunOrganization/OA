package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/16.
 */
public class Leave {

    @Id
    @GeneratedValue
    private int id;// 主键
    @OneToOne
    private SkEmp emp;// 员工
    @ManyToOne
    private SkJob job;// 岗位
    private String place;// 离职去向
    private Date time;// 离职日期
    private String reason;// 离职原因
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public Leave() {
    }

    public Leave(SkEmp emp, SkJob job, String place, Date time, String reason) {
        this.emp = emp;
        this.job = job;
        this.place = place;
        this.time = time;
        this.reason = reason;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
