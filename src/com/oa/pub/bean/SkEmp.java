package com.oa.pub.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * by wangrongjun on 2017/10/11.
 */
public class SkEmp {

    @Id
    @GeneratedValue
    private int id;// 编号
    private String name;// 姓名
    private int sex;// 性别（0为女，1为男）
    private Date bir;// 出生日期
    private String idcard;// 身份证号
    private Date toworktime;// 参加工作的时间
    private String zzmm;// 政治面貌
    private String national;// 民族
    private String nativePlace;// 籍贯
    private String tele;// 联系电话
    private String mail;// 电子邮件
    private String height;// 身高
    private String bloodtype;// 血型
    private String birthplace;// 出生地
    private String hkplace;// 户口所在地
    private String xl;// 最高学历
    private String degree;// 最高学位
    private String graduateschool;// 毕业院校
    private String professional;// 所学专业
    private Date graduatetime;//毕业日期
    private String explanation1;// 备注1
    private String explanation2;// 备注2
    private String explanation3;// 备注3

    public SkEmp() {
    }

    public SkEmp(String name, int sex, String idcard, String tele) {
        this.name = name;
        this.sex = sex;
        this.idcard = idcard;
        this.tele = tele;
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

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getToworktime() {
        return toworktime;
    }

    public void setToworktime(Date toworktime) {
        this.toworktime = toworktime;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getHkplace() {
        return hkplace;
    }

    public void setHkplace(String hkplace) {
        this.hkplace = hkplace;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getGraduatetime() {
        return graduatetime;
    }

    public void setGraduatetime(Date graduatetime) {
        this.graduatetime = graduatetime;
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
