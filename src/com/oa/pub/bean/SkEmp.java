package com.oa.pub.bean;

import java.util.Date;

/**
 * by wangrongjun on 2017/10/11.
 */
public class SkEmp {

    private int id;// 编号
    private String name;// 姓名
    private String sex;// 性别
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

    public SkEmp(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
