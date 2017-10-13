package com.oa.wrj.test;

import com.oa.pub.bean.Manager;
import com.oa.wrj.dao.ManagerDao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * by wangrongjun on 2017/10/12.
 */
public class Test {

    public List<Manager> a() throws SQLException {
        String name = "";
        String id = "";

        if (empty(id)) {
            if (empty(name)) {
                // 提示错误
                throw new RuntimeException("null");
            } else {
                return new ManagerDao().queryByName(name);
            }
        } else {
            Manager manager = new ManagerDao().queryById(Integer.parseInt(id));
            return Arrays.asList(manager);
        }
    }

    private boolean empty(String s) {
        return s == null || s.length() == 0;
    }

}
