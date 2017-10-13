package com.oa.wrj.action;

import com.oa.wrj.dao.JobDao;
import com.wangrg.web_lib.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/10/12.
 */
public class DeleteJobAction extends ActionSupport {

    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, UnLoginException {
        int jobId = checkIntegerParameter("jobId");
        if (new JobDao().deleteById(jobId)) {
            request.setAttribute("msg", "删除成功");
        } else {
            request.setAttribute("msg", "删除失败，岗位下还有员工");
        }
        return "showMsg.jsp";
    }

}
