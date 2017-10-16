package com.oa.wrj.test;

import com.oa.pub.bean.*;
import com.oa.wrj.dao.*;
import com.wangrg.java_lib.db2.Where;
import com.wangrg.java_lib.db3.DbUtil;
import com.wangrg.java_lib.java_util.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * by wangrongjun on 2017/10/10.
 */
public class DaoTest {

    private MaTableDao maTableDao = new MaTableDao();
    private DeptDao deptDao = new DeptDao();
    private JobDao jobDao = new JobDao();
    private EmpDao empDao = new EmpDao();
    private OccupationCareerDao careerDao = new OccupationCareerDao();
    private TemporaryDao temporaryDao = new TemporaryDao();
    private SkStaffDao staffDao = new SkStaffDao();
    private LeaveDao leaveDao = new LeaveDao();

    @Test
    public void testQuery() {
    }

    @Test
    public void testInsert() throws Exception {
        dropAndCreate();

        MaTable 岗位类型_管理 = new MaTable(1, "岗位类型", "管理", 1);
        MaTable 岗位类型_技术 = new MaTable(1, "岗位类型", "技术", 2);
        MaTable 岗位类型_营销 = new MaTable(1, "岗位类型", "营销", 3);
        MaTable 岗位类型_市场 = new MaTable(1, "岗位类型", "市场", 4);
        MaTable 考核结果_转正 = new MaTable(2, "考核结果", "转正", 1);
        MaTable 考核结果_延期 = new MaTable(2, "考核结果", "延期", 2);
        MaTable 考核结果_不予录用 = new MaTable(2, "考核结果", "不予录用", 3);
        MaTable 人才来源_校园招聘 = new MaTable(3, "人才来源", "校园招聘", 1);
        MaTable 人才来源_社会招聘 = new MaTable(3, "人才来源", "社会招聘", 2);
        MaTable 人才来源_其他 = new MaTable(3, "人才来源", "其他", 3);
        maTableDao.insert(岗位类型_管理);
        maTableDao.insert(岗位类型_技术);
        maTableDao.insert(岗位类型_营销);
        maTableDao.insert(岗位类型_市场);
        maTableDao.insert(考核结果_转正);
        maTableDao.insert(考核结果_延期);
        maTableDao.insert(考核结果_不予录用);

        SkDept 研发部 = new SkDept("研发部", "部门", "103", "113", "研发产品", null, d("2016-01-02"), "", "", "");
        SkDept 销售部 = new SkDept("销售部", "部门", "102", "112", "采购商品", null, d("2016-01-01"), "", "", "");
        SkDept 人力资源部 = new SkDept("人力资源部", "部门", "101", "111", "管理人员", null, d("2016-01-01"), "", "", "");
        SkDept 风投子公司 = new SkDept("风投子公司", "公司", "105", "115", "风投", null, d("2016-01-03"), "", "", "");
        deptDao.insert(研发部);
        deptDao.insert(销售部);
        deptDao.insert(人力资源部);
        deptDao.insert(风投子公司);

        SkJob 程序员 = new SkJob("程序员", 岗位类型_技术, 20, 研发部, null, null, null);
        SkJob 技术总监 = new SkJob("技术总监", 岗位类型_管理, 2, 研发部, null, null, null);
        SkJob 销售员 = new SkJob("销售员", 岗位类型_营销, 20, 销售部, null, null, null);
        SkJob 销售总监 = new SkJob("销售总监", 岗位类型_管理, 2, 销售部, null, null, null);
        jobDao.insert(程序员);
        jobDao.insert(技术总监);
        jobDao.insert(销售员);
        jobDao.insert(销售总监);

        SkEmp 赵总 = new SkEmp("赵总", 1, "440181199401023530", "15521332230");// 公司董事长，正在工作
        SkEmp 张三 = new SkEmp("张三", 1, "440181199401023531", "15521332231");// 技术总监，正在工作
        SkEmp 李四 = new SkEmp("李四", 1, "440181199401023532", "15521332232");// 程序员实习生，试用期
        SkEmp 王五 = new SkEmp("王五", 1, "440181199401023533", "15521332233");// 考核未通过，试用期结束，已离开公司
        SkEmp 小丽 = new SkEmp("小丽", 0, "440181199401023534", "15521332234");// 销售总监，正在工作
        SkEmp 小芳 = new SkEmp("小芳", 0, "440181199401023535", "15521332235");// 销售员，已转正，正在工作
        SkEmp 小萍 = new SkEmp("小萍", 0, "440181199401023536", "15521332236");// 销售员，已转正，已辞职
        empDao.insert(赵总);
        empDao.insert(张三);
        empDao.insert(李四);
        empDao.insert(王五);
        empDao.insert(小丽);
        empDao.insert(小芳);
        empDao.insert(小萍);

        // 张三已转正，从理发师到程序员实习生，再到程序员。现在是技术总监。目前正在公司工作。
        careerDao.insert(new OccupationCareer(张三, d("2016-02-25"), d("2016-05-15"), "理发师", 4000));
        careerDao.insert(new OccupationCareer(张三, d("2016-05-16"), d("2016-09-06"), "程序员实习生", 2000));
        temporaryDao.insert(new Temporary(张三, 程序员, d("2016-05-16"), d("2016-09-06"), 考核结果_转正, d("2016-09-01"), 赵总));
        careerDao.insert(new OccupationCareer(张三, d("2016-09-01"), d("2016-12-20"), "程序员", 7000));
        careerDao.insert(new OccupationCareer(张三, d("2016-09-01"), null, "技术总监", 15000));
        staffDao.insert(new SkStaff(张三, 技术总监, d("2016-09-01"), 人才来源_社会招聘));

        // 李四未转正，处于试用期。
        careerDao.insert(new OccupationCareer(李四, d("2016-04-21"), d("2016-12-31"), "程序员实习生", 3000));
        temporaryDao.insert(new Temporary(李四, 程序员, d("2017-01-01")));

        // 王五考核未通过，试用期结束，已离开公司。
        careerDao.insert(new OccupationCareer(王五, d("2016-05-16"), d("2016-09-06"), "程序员实习生", 1800));
        temporaryDao.insert(new Temporary(王五, 程序员, d("2016-04-16"), d("2016-06-06"), 考核结果_不予录用, d("2016-06-01"), 张三));

        // 小丽是销售总监，目前正在公司工作。
        careerDao.insert(new OccupationCareer(小丽, d("2017-01-03"), null, "销售员实习生", 2000));
        temporaryDao.insert(new Temporary(小丽, 程序员, d("2016-01-14"), d("2016-03-13"), 考核结果_转正, d("2016-03-10"), 赵总));
        careerDao.insert(new OccupationCareer(小丽, d("2016-03-14"), null, "销售员", 5000));
        careerDao.insert(new OccupationCareer(小丽, d("2016-03-14"), null, "销售总监", 12000));
        staffDao.insert(new SkStaff(小丽, 销售总监, d("2016-09-01"), 人才来源_校园招聘));

        // 小芳是销售员，已转正，正在工作
        careerDao.insert(new OccupationCareer(小芳, d("2016-04-16"), d("2016-07-06"), "销售员实习生", 1500));
        temporaryDao.insert(new Temporary(小芳, 销售员, d("2016-04-16"), d("2016-06-06"), 考核结果_延期, d("2016-06-01"), 小丽));
        temporaryDao.insert(new Temporary(小芳, 销售员, d("2016-06-06"), d("2016-07-06"), 考核结果_转正, d("2016-07-01"), 小丽));
        careerDao.insert(new OccupationCareer(小芳, d("2016-07-06"), null, "销售员", 6000));
        staffDao.insert(new SkStaff(小芳, 销售员, d("2016-07-06"), 人才来源_其他));

        // 小萍是销售员，已转正，已辞职
        careerDao.insert(new OccupationCareer(小萍, d("2016-04-16"), d("2016-07-06"), "销售员实习生", 1500));
        temporaryDao.insert(new Temporary(小萍, 销售员, d("2016-04-16"), d("2016-06-06"), 考核结果_延期, d("2016-06-01"), 小丽));
        temporaryDao.insert(new Temporary(小萍, 销售员, d("2016-06-06"), d("2016-07-06"), 考核结果_转正, d("2016-07-01"), 小丽));
        careerDao.insert(new OccupationCareer(小萍, d("2016-07-06"), d("2016-11-14"), "销售员", 6000));
        leaveDao.insert(new Leave(小萍, 销售员, "谷歌", d("2016-11-14"), "世界那么大，我想去看看"));

        // Dept
        for (int i = 1; i <= 20; i++) {
            SkDept superDept = i % 2 == 0 ? 研发部 : 销售部;
            Date date = d("2017-04-" + (i < 10 ? "0" + i : i));
            SkDept dept = new SkDept("Dept_" + i, "部门", "tele_" + i, "fax_" + i, "discrip_" + i,
                    superDept, date, "explanation1_" + i, "explanation2_" + i, "explanation3_" + i);
            deptDao.insert(dept);
        }

        // Job
        for (int i = 1; i <= 20; i++) {
            SkJob job = new SkJob("Job_" + i, i % 2 == 0 ? 岗位类型_技术 : 岗位类型_管理,
                    i, i % 2 == 0 ? 研发部 : 销售部, null, null, null);
            jobDao.insert(job);
        }

        // Emp
        for (int i = 1; i <= 20; i++) {
            SkEmp emp = new SkEmp("Emp_" + i, i % 2, "idcard_" + i, "tele_" + i);
            empDao.insert(emp);
        }

        // Temporary,OccupationCareer（员工1-5是实习生，即试用中）
        for (int i = 1; i <= 5; i++) {
            SkJob job = i % 2 == 0 ? 程序员 : 销售员;
            SkEmp emp = empDao.query(Where.eq("name", "Emp_" + i)).get(0);
            careerDao.insert(new OccupationCareer(emp, d("2017-01-01"), null, job.getName() + "实习生", 1000 + i * 100));
            MaTable result = i % 5 == 0 ? 考核结果_转正 : 考核结果_不予录用;
            temporaryDao.insert(new Temporary(emp, job, d("2017-01-01"), null, result, d("2017-03-01"), 赵总));
        }

        // SkStaff,OccupationCareer（员工6-15是转正员工）
        for (int i = 6; i <= 15; i++) {
            SkJob job = i % 2 == 0 ? 程序员 : 销售员;
            SkEmp emp = empDao.query(Where.eq("name", "Emp_" + i)).get(0);
            careerDao.insert(new OccupationCareer(emp, d("2017-01-01"), d("2017-03-05"), job.getName() + "实习生", 1000 + i * 100));
            careerDao.insert(new OccupationCareer(emp, d("2017-03-06"), null, job.getName(), 8000 + i * 100));
            MaTable source = i % 2 == 0 ? 人才来源_校园招聘 : 人才来源_社会招聘;
            staffDao.insert(new SkStaff(emp, job, d("2017-03-06"), source));
        }

        // Leave（16-20是离职员工）
        for (int i = 16; i <= 20; i++) {
            SkJob job = i % 2 == 0 ? 程序员 : 销售员;
            SkEmp emp = empDao.query(Where.eq("name", "Emp_" + i)).get(0);
            careerDao.insert(new OccupationCareer(emp, d("2017-01-01"), d("2017-03-05"), job.getName() + "实习生", 1000 + i * 100));
            careerDao.insert(new OccupationCareer(emp, d("2017-03-06"), d("2017-07-13"), job.getName(), 8000 + i * 100));
            leaveDao.insert(new Leave(emp, job, "富士康", d("2017-07-14"), "世界那么大，我想去看看"));
        }
    }

    @Test
    public void dropAndCreate() throws Exception {
        DbUtil.dropAndCreateTables(this);
    }

    private Date d(String date) {
        return DateUtil.toDate(date);
    }

}
