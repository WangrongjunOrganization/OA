package com.oa.wrj.action;

import com.oa.pub.bean.MaTable;
import com.oa.wrj.dao.MaTableDao;
import com.wangrg.java_lib.java_util.GsonUtil;
import com.wangrg.web_lib.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/10/12.
 */
public class TestAction extends ActionSupport {

    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, UnLoginException {
        response.setCharacterEncoding("utf-8");

        int maTableId = checkIntegerParameter("maTableId");
        MaTable maTable = new MaTableDao().queryById(maTableId);
        response.getWriter().write(GsonUtil.toJson(maTable));
        return null;
    }

}
