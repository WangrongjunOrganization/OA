package com.oa.wrj.dao;

import com.oa.pub.bean.OccupationCareer;
import com.wangrg.java_lib.db2.Query;
import com.wangrg.java_lib.db2.Where;
import com.wangrg.java_lib.db3.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/10/12.
 */
public class OccupationCareerDao extends OADao<OccupationCareer> implements Dao<OccupationCareer> {

    public List<OccupationCareer> queryByJobId(int jobId, int offset, int rowCount) {
        Where where = Where.eq("job", jobId).and().isNull("endTime");
        return query(Query.where(where).ignore("job").limit(offset, rowCount));
    }

    public int queryCountByJobId(int jobId) {
        Where where = Where.eq("job", jobId).and().isNull("endTime");
        return queryCount(where);
    }

}
