package com.oa.wrj.dao;

import com.oa.pub.bean.SkJob;
import com.wangrg.java_lib.db2.Query;
import com.wangrg.java_lib.db2.Where;
import com.wangrg.java_lib.db3.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/10/10.
 */
public class JobDao extends OADao<SkJob> implements Dao<SkJob> {

    public List<SkJob> queryByDeptId(int deptId) {
        return query(Where.eq("dept", deptId));
    }

    public List<SkJob> queryAllWithoutForeignKeyObject() {
        return query(Query.where(null).orderBy("id").maxQueryForeignKeyLevel(0));
    }

    /**
     * @param deptId 如果为null，则是从部门中移除岗位
     */
    public boolean setDeptJobR(Integer deptId, int jobId) {
        String sql = "update SkJob set dept=" + deptId + " where id=" + jobId;
        return executeUpdate(sql);
    }

}
