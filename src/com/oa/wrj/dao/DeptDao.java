package com.oa.wrj.dao;

import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.SkJob;
import com.wangrg.java_lib.db2.Query;
import com.wangrg.java_lib.db3.Dao;

import java.sql.*;
import java.util.ArrayList;
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

    public List<SkDept> queryAllOnlyWithName() {
        String sql = "select id,name from " + getTableName();
        return executeQuery(sql, 0, null, null);
    }

//    public List<SkDept> query(int pageIndex, int pageSize) {
//        String sql = "select * from (select rownum rn,e.* from SkEmp e where rownum<=?) where rn>=?";
//        List<SkDept> deptList = new ArrayList<>();
//        try (Connection connection = getConnection()) {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, pageIndex * pageSize);
//            ps.setInt(2, (pageIndex + 1) * pageSize);
//            ResultSet rs = ps.executeQuery();
//            // 获取数据
//            rs.close();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return deptList;
//    }

}
