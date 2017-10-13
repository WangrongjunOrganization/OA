package com.oa.wrj.action;

import com.oa.pub.bean.MaTable;
import com.oa.pub.bean.SkJob;
import com.oa.wrj.dao.JobDao;
import com.wangrg.web_lib.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/10/12.
 */
public class AddJobAction extends ActionSupport {

    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, UnLoginException {
        int jobTypeMaTableId = checkIntegerParameter("jobTypeMaTableId");
        SkJob job = getEntity(SkJob.class);
        job.setJobType(new MaTable(jobTypeMaTableId));
        boolean succeed = new JobDao().insert(job);
        request.setAttribute("msg", "岗位“" + job.getName() + "”添加" +
                (succeed ? "成功" : "失败，岗位已存在"));
        return "showMsg.jsp";
    }

}
