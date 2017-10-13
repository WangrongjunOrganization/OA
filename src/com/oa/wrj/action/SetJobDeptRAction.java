package com.oa.wrj.action;

import com.oa.wrj.dao.JobDao;
import com.wangrg.web_lib.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/10/13.
 */
public class SetJobDeptRAction extends ActionSupport {

    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, UnLoginException {
        String action = checkStringParameter("action");
        int jobId = checkIntegerParameter("jobId");
        JobDao jobDao = new JobDao();

        switch (action) {
            case "add":
                int deptId = checkIntegerParameter("deptId");
                boolean succeed = jobDao.setDeptJobR(deptId, jobId);
                response.getWriter().write(String.valueOf(succeed));
                break;
            case "remove":
                succeed = jobDao.setDeptJobR(null, jobId);
                response.getWriter().write(String.valueOf(succeed));
                break;
            default:
                throw new ParamErrorException("action should be and or remove, but actually is " + action);
        }

        return null;
    }

}
