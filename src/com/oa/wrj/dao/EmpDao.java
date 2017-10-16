package com.oa.wrj.dao;

import com.oa.pub.bean.SkEmp;
import com.oa.pub.bean.view.EmpDetail;
import com.wangrg.java_lib.db3.Dao;
import com.wangrg.java_lib.db3.DbUtil;
import com.wangrg.java_lib.db3.db.sql_creator.OracleCreator;
import com.wangrg.java_lib.java_util.TextUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * by wangrongjun on 2017/10/11.
 */
public class EmpDao extends OADao<SkEmp> implements Dao<SkEmp> {

    /**
     * @param beginTime 格式必须是yyyy-MM-dd
     */
    public List<EmpDetail> queryTemporaryEmp(Integer empId, String empName, Integer deptId, String beginTime,
                                             int offset, int rowCount) {
        String sql = createQueryTemporaryEmpSql(false, empId, empName, deptId, beginTime);
        sql = new OracleCreator().wrapLimit(sql, offset, rowCount);
        return executeQueryEmpDetail(sql);
    }

    /**
     * @param beginTime 格式必须是yyyy-MM-dd
     */
    public int queryTemporaryEmpCount(Integer empId, String empName, Integer deptId, String beginTime) {
        return executeQueryCount(createQueryTemporaryEmpSql(true, empId, empName, deptId, beginTime));
    }

    private String createQueryTemporaryEmpSql(boolean queryCount, Integer empId, String empName, Integer deptId, String beginTime) {
        String sql = "";
        if (queryCount) {
            sql += "select count(1)\n";
        } else {
            sql += "select e.id        empId,\n" +
                    "       e.name      empName,\n" +
                    "       d.name      deptName,\n" +
                    "       j.name      jobName,\n" +
                    "       t.beginTime beginTime,\n" +
                    "       t.endTime   endTime\n";
        }
        sql += "  from SkEmp e\n" +
                "  join Temporary t\n" +
                "    on e.id = t.emp\n" +
                "  join SkJob j\n" +
                "    on t.job = j.id\n" +
                "  join SkDept d\n" +
                "    on j.dept = d.id\n" +
                " where t.endTime is null";

        if (empId != null) {
            sql += " and e.id=" + empId;
        }
        if (!TextUtil.isEmpty(empName)) {
            sql += " and e.name like '%" + empName + "%'";
        }
        if (deptId != null) {
            sql += " and d.id=" + deptId;
        }
        if (!TextUtil.isEmpty(beginTime)) {
            sql += " and t.beginTime " +
                    "between " +
                    "(to_date('" + beginTime + "','yyyy-MM-dd'))" +
                    " and " +
                    "(to_date('" + beginTime + "','yyyy-MM-dd') + interval '1' day)";
        }
        return sql;
    }

    private List<EmpDetail> executeQueryEmpDetail(String sql) {
        List<EmpDetail> empDetailList = new ArrayList<>();
        printSql(sql);
        try (Connection conn = getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            empDetailList = DbUtil.getResult(EmpDetail.class, rs);
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printResult(empDetailList);
        return empDetailList;
    }

}
