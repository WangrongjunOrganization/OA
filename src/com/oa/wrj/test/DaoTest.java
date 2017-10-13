package com.oa.wrj.test;

import com.oa.pub.bean.*;
import com.oa.wrj.dao.*;
import com.wangrg.java_lib.db2.Where;
import com.wangrg.java_lib.java_util.DateUtil;
import com.wangrg.java_lib.java_util.LogUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * by wangrongjun on 2017/10/10.
 */
public class DaoTest {

    private MaTableDao maTableDao = new MaTableDao();
    private DeptDao deptDao = new DeptDao();
    private JobDao jobDao = new JobDao();
    private EmpDao empDao = new EmpDao();
    private OccupationCareerDao careerDao = new OccupationCareerDao();

    @Test
    public void testQuery() {
        List<SkDept> deptList = deptDao.queryAllWithJobList();
        LogUtil.printEntity(deptList);
//        jobDao.queryAllWithoutForeignKeyObject();
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

        SkDept 研发部 = new SkDept("研发部", "部门", "103", "113", "研发产品", null, date("2016-01-02"), "", "", "");
        SkDept 采购部 = new SkDept("采购部", "部门", "102", "112", "采购商品", null, date("2016-01-01"), "", "", "");
        SkDept 人力资源部 = new SkDept("人力资源部", "部门", "101", "111", "管理人员", null, date("2016-01-01"), "", "", "");
        SkDept 风投子公司 = new SkDept("风投子公司", "公司", "105", "115", "风投", null, date("2016-01-03"), "", "", "");
        deptDao.insert(研发部);
        deptDao.insert(采购部);
        deptDao.insert(人力资源部);
        deptDao.insert(风投子公司);

        SkJob 程序员 = new SkJob("程序员", 技术, 10, 研发部, null, null, null);
        SkJob 项目经理 = new SkJob("项目经理", 管理, 1, 研发部, null, null, null);
        SkJob 销售员 = new SkJob("销售员", 营销, 2, 研发部, null, null, null);
        jobDao.insert(程序员);
        jobDao.insert(项目经理);
        jobDao.insert(销售员);

        SkEmp 张三 = new SkEmp("张三", 1, "440181199401023531", "15521332231");
        SkEmp 李四 = new SkEmp("李四", 1, "440181199401023532", "15521332232");
        SkEmp 王五 = new SkEmp("王五", 1, "440181199401023533", "15521332233");
        SkEmp 小丽 = new SkEmp("小丽", 0, "440181199401023534", "15521332234");
        empDao.insert(张三);
        empDao.insert(李四);
        empDao.insert(王五);
        empDao.insert(小丽);

        careerDao.insert(new OccupationCareer(张三, date("2017-01-01"), date("2017-04-01"), 程序员, 5000));
        careerDao.insert(new OccupationCareer(张三, date("2017-04-02"), null, 项目经理, 8000));// 由普通职工升到经理
        careerDao.insert(new OccupationCareer(王五, date("2017-01-06"), null, 程序员, 4000));
        careerDao.insert(new OccupationCareer(小丽, date("2017-01-03"), null, 销售员, 3000));

        for (int i = 1; i <= 20; i++) {
            SkDept superDept = i % 2 == 0 ? 研发部 : 采购部;
            Date date = date("2017-04-" + (i < 10 ? "0" + i : i));
            SkDept dept = new SkDept("Dept_" + i, "部门", "tele_" + i, "fax_" + i, "discrip_" + i,
                    superDept, date, "explanation1_" + i, "explanation2_" + i, "explanation3_" + i);
            deptDao.insert(dept);
        }

        for (int i = 1; i <= 20; i++) {
            SkJob job = new SkJob("Job_" + i, i % 2 == 0 ? 技术 : 管理, i, i % 2 == 0 ? 研发部 : 采购部, null, null, null);
            jobDao.insert(job);
        }

        for (int i = 1; i <= 20; i++) {
            SkEmp emp = new SkEmp("Emp_" + i, i % 2, "idcard_" + i, "tele_" + i);
            empDao.insert(emp);
        }

        for (int i = 1; i <= 20; i++) {
            SkJob job = i > 10 ? 程序员 : jobDao.query(Where.eq("name", "Job_" + i)).get(0);
            SkEmp emp = empDao.query(Where.eq("name", "Emp_" + i)).get(0);
            careerDao.insert(new OccupationCareer(emp, date("2017-01-01"), null, job, 4000 + i * 100));
        }

    }

    @Test
    public void dropAndCreate() {
        careerDao.dropTable();
        empDao.dropTable();
        jobDao.dropTable();
        deptDao.dropTable();
        maTableDao.dropTable();

        maTableDao.createTable();
        deptDao.createTable();
        jobDao.createTable();
        empDao.createTable();
        careerDao.createTable();
    }

    public Date date(String date) {
        return DateUtil.toDate(date);
    }

}
