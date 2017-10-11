package com.oa.wrj.test;

import com.oa.pub.bean.MaTable;
import com.oa.pub.bean.SkDept;
import com.oa.pub.bean.SkJob;
import com.oa.wrj.dao.DeptDao;
import com.oa.wrj.dao.EmpDao;
import com.oa.wrj.dao.JobDao;
import com.oa.wrj.dao.MaTableDao;
import com.wangrg.java_lib.java_util.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * by wangrongjun on 2017/10/10.
 */
public class TestDao {

    private MaTableDao maTableDao = new MaTableDao();
    private DeptDao deptDao = new DeptDao();
    private JobDao jobDao = new JobDao();
    private EmpDao empDao = new EmpDao();

    @Test
    public void testQuery() {
        maTableDao.queryAll();
        deptDao.queryAll();
        jobDao.queryAll();
    }

    @Test
    public void testInsert() {
        dropAndCreate();

        MaTable 管理 = new MaTable("jobType", "管理", 1);
        MaTable 技术 = new MaTable("jobType", "技术", 2);
        MaTable 营销 = new MaTable("jobType", "营销", 3);
        MaTable 市场 = new MaTable("jobType", "市场", 4);
        maTableDao.insert(管理);
        maTableDao.insert(技术);
        maTableDao.insert(营销);
        maTableDao.insert(市场);

        SkDept 研发部 = new SkDept("研发部", "部门", "103", "113", "研发产品", null, DateUtil.toDate("2016-01-02"), "", "", "");
        SkDept 采购部 = new SkDept("采购部", "部门", "102", "112", "采购商品", null, DateUtil.toDate("2016-01-01"), "", "", "");
        SkDept 人力资源部 = new SkDept("人力资源部", "部门", "101", "111", "管理人员", null, DateUtil.toDate("2016-01-01"), "", "", "");
        SkDept 风投子公司 = new SkDept("风投子公司", "公司", "105", "115", "风投", null, DateUtil.toDate("2016-01-03"), "", "", "");
        deptDao.insert(研发部);
        deptDao.insert(采购部);
        deptDao.insert(人力资源部);
        deptDao.insert(风投子公司);

        SkJob 普通职工 = new SkJob("普通职工", 技术, 10, 研发部, null, null, null);
        SkJob 经理 = new SkJob("项目经理", 管理, 1, 研发部, null, null, null);
        SkJob 销售员 = new SkJob("销售员", 营销, 2, 研发部, null, null, null);
        jobDao.insert(普通职工);
        jobDao.insert(经理);
        jobDao.insert(销售员);

        for (int i = 1; i <= 30; i++) {
            SkDept superDept = i % 2 == 0 ? 研发部 : 采购部;
            Date date = DateUtil.toDate("2017-04-" + (i < 10 ? "0" + i : i));
            SkDept dept = new SkDept("Dept_" + i, "部门", "tele_" + i, "fax_" + i, "discrip_" + i,
                    superDept, date, "explanation1_" + i, "explanation2_" + i, "explanation3_" + i);
            deptDao.insert(dept);
        }

        for (int i = 1; i <= 30; i++) {
            SkJob job = new SkJob("Job_" + i, i % 2 == 0 ? 技术 : 管理, i, 研发部, null, null, null);
            jobDao.insert(job);
        }

    }

    @Test
    public void dropAndCreate() {
        empDao.dropTable();
        jobDao.dropTable();
        deptDao.dropTable();
        maTableDao.dropTable();

        maTableDao.createTable();
        deptDao.createTable();
        jobDao.createTable();
        empDao.createTable();
    }

}
