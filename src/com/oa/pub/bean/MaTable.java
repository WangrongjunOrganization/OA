package com.oa.pub.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * by wangrongjun on 2017/10/9.
 * 码表
 */
public class MaTable {

    @Id
    @GeneratedValue
    private int id;
    private String name;// 类型名，如颜色
    private String attrName;// 属性名，如白色，黑色
    private int attrValue;// 属性值，如1，2，3

    public MaTable() {
    }

    public MaTable(String name, String attrName, int attrValue) {
        this.name = name;
        this.attrName = attrName;
        this.attrValue = attrValue;
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

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public int getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(int attrValue) {
        this.attrValue = attrValue;
    }
}
