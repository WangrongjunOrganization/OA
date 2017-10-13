package com.oa.wrj.dao;

import com.wangrg.java_lib.db3.BaseDao;
import com.wangrg.java_lib.db3.Config;
import com.wangrg.java_lib.db3.db.MysqlDatabase;
import com.wangrg.java_lib.db3.db.OracleDatabase;
import com.wangrg.java_lib.db3.db.SqliteDatabase;

/**
 * by wangrongjun on 2017/10/10.
 */
public class OADao<T> extends BaseDao<T> {
    public OADao() {
//        super(new Config().setDb(new MysqlDatabase("oa")).setUsername("root").setPassword("21436587"));
        super(new Config().setDb(new OracleDatabase("orcl")).setUsername("wang").setPassword("123"));
//        super(new Config().setDb(new SqliteDatabase("E:/oa.db")));
    }
}
