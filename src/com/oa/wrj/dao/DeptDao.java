package com.oa.wrj.dao;

import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.SkJob;
import com.wangrg.java_lib.db2.Query;
import com.wangrg.java_lib.db3.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/10/10.
 */
public class DeptDao extends OADao<SkDept> implements Dao<SkDept> {

    public List<SkDept> queryAllWithJobList() {
        List<SkDept> deptList = query(Query.where(null).maxQueryForeignKeyLevel(0));
        JobDao jobDao = new JobDao();
        for (SkDept dept : deptList) {
            List<SkJob> jobList = jobDao.queryByDeptId(dept.getId());
            dept.setJobList(jobList);
        }
        return deptList;
    }

}
