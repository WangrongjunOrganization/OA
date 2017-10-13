package com.oa.pub.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/10/9.
 */
public class SkJob {

    @Id
    @GeneratedValue
    private int id;// 岗位编号
    @Column(unique = true)
    private String name;// 岗位名称
    @ManyToOne
    private MaTable jobType;// 岗位类型（分为管理，技术，营销,市场等）
    private int jobLimit;// 岗位编制：岗位上最多可配置多少员工
    @ManyToOne
    private SkDept dept;// 隶属部门
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public SkJob() {
    }

    public SkJob(String name, MaTable jobType, int jobLimit, SkDept dept, String explanation1, String explanation2, String explanation3) {
        this.name = name;
        this.jobType = jobType;
        this.jobLimit = jobLimit;
        this.dept = dept;
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

    public MaTable getJobType() {
        return jobType;
    }

    public void setJobType(MaTable jobType) {
        this.jobType = jobType;
    }

    public int getJobLimit() {
        return jobLimit;
    }

    public void setJobLimit(int jobLimit) {
        this.jobLimit = jobLimit;
    }

    public SkDept getDept() {
        return dept;
    }

    public void setDept(SkDept dept) {
        this.dept = dept;
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
