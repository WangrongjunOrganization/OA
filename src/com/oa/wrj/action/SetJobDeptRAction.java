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
        String jobName = getStringParameter("jobName", "");
        String deptName = getStringParameter("deptName", "");
        JobDao jobDao = new JobDao();

        switch (action) {
            case "add":
                int deptId = checkIntegerParameter("deptId");
                boolean succeed = jobDao.setDeptJobR(deptId, jobId);
                request.setAttribute("msg", "岗位" + jobName + "添加到部门" + deptName +
                        (succeed ? "成功" : "失败"));
                break;
            case "remove":
                succeed = jobDao.setDeptJobR(null, jobId);
                request.setAttribute("msg", "从部门" + deptName + "移除岗位" + jobName +
                        (succeed ? "成功" : "失败"));
                break;
            default:
                throw new ParamErrorException("action should be and or remove, but actually is " + action);
        }

        return "showMsg.jsp";
    }

}
