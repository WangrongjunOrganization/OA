package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/11.
 */
public class OccupationCareer {// 职业生涯信息

    @Id
    @GeneratedValue
    private int id;// 主键id
    @ManyToOne
    private SkEmp emp;// 员工
    private Date beginTime;// 起始年月
    private Date endTime;// 截至年月（如果为空，则代表正在工作）
    private String jobName;// 所在岗位
    private String jobDiscrip;// 从事工作内容
    private String position;// 担任职务
    private double salary;// 年薪/月薪
    private String reference;// 证明人
    private String referencePosition;// 证明人职务
    private String referenceTel;// 证明人电话
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public OccupationCareer() {
    }

    public OccupationCareer(SkEmp emp, Date beginTime, Date endTime, String jobName, double salary) {
        this.emp = emp;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.jobName = jobName;
        this.salary = salary;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDiscrip() {
        return jobDiscrip;
    }

    public void setJobDiscrip(String jobDiscrip) {
        this.jobDiscrip = jobDiscrip;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferencePosition() {
        return referencePosition;
    }

    public void setReferencePosition(String referencePosition) {
        this.referencePosition = referencePosition;
    }

    public String getReferenceTel() {
        return referenceTel;
    }

    public void setReferenceTel(String referenceTel) {
        this.referenceTel = referenceTel;
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
