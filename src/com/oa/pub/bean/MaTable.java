package com.oa.pub.bean;

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
    private int typeId;// 类型id
    private String typeName;// 类型名，如颜色
    private String valueName;// 属性名，如白色，黑色
    private int value;// 属性值，如1，2，3

    public MaTable() {
    }

    public MaTable(int id) {
        this.id = id;
    }

    public MaTable(int typeId, String typeName, String valueName, int value) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.valueName = valueName;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
