package com.oa.wrj.dao;

import com.oa.pub.bean.MaTable;
import com.wangrg.java_lib.db2.Where;
import com.wangrg.java_lib.db3.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/10/10.
 */
public class MaTableDao extends OADao<MaTable> implements Dao<MaTable> {

    public List<MaTable> queryJobType() {
        return query(Where.eq("name", "jobType"));
    }

}
