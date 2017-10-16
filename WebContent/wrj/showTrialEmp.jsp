<%@ page import="com.oa.pub.bean.view.EmpDetail" %>
<%@ page import="com.oa.wrj.dao.EmpDao" %>
<%@ page import="com.wangrg.web_lib.bean.Pager" %>
<%@ page import="com.wangrg.web_lib.util.RequestUtil" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/15
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>

    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-image: url(../images/bg.gif);
        }

        .STYLE2 {
            font-size: 24px;
            color: #666;
        }

        .STYLE3 {
            color: #666
        }

        -->
    </style>

</head>

<%
    Pager.setPager(5, request, new Pager.OnQueryListener<EmpDetail>() {
        Integer empId = RequestUtil.getIntParameter(request, "empId");
        String empName = request.getParameter("empName");
        Integer deptId = RequestUtil.getIntParameter(request, "deptId");
        String beginTime = request.getParameter("beginTime");

        @Override
        public int queryTotalCount() {
            return new EmpDao().queryTemporaryEmpCount(empId, empName, deptId, beginTime);
        }

        @Override
        public List<EmpDetail> queryList(int offset, int rowCount) {
            return new EmpDao().queryTemporaryEmp(empId, empName, deptId, beginTime, offset, rowCount);
        }
    });
%>

<body>
<div id="man_zone">
    <table width="1015" height="50%" border="0" align="left">

        <tr>
            <td colspan="7" align="center" valign="top"><span class="STYLE2">转正员工信息列表</span></td>
        </tr>
        <tr>
            <td width="122" align="left" valign="top"><span class="STYLE3">员工编号</span></td>
            <td width="122"><span class="STYLE3">姓名</span></td>
            <td width="122"><span class="STYLE3">部门名称</span></td>
            <td width="123"><span class="STYLE3">岗位名称</span></td>
            <td width="122"><span class="STYLE3">试用期开始日期</span></td>
            <td width="122"><span class="STYLE3">试用期结束日期</span></td>
        </tr>
        <c:if test="${fn:length(pager.list)==0}">
            <div align="center">没有数据</div>
        </c:if>
        <c:forEach var="empDetail" items="${pager.list}">
            <tr>
                <td><span class="STYLE3">${empDetail.empId}</span></td>
                <td><span class="STYLE3">${empDetail.empName}</span></td>
                <td><span class="STYLE3">${empDetail.deptName}</span></td>
                <td><span class="STYLE3">${empDetail.jobName}</span></td>
                <td><span class="STYLE3">
                    <fmt:formatDate value="${empDetail.beginTime}" pattern="yyyy-MM-dd"/>
                </span></td>
                <td><span class="STYLE3">
                    <fmt:formatDate value="${empDetail.endTime}" pattern="yyyy-MM-dd"/>
                </span></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" align="center" valign="middle">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
                    <tr>
                        <td width="50%" height="34" align="left"><span
                                class="STYLE3">共 ${pager.pageCount} 页 | 第 ${pager.pageIndex+1} 页</span></td>
                        <td width="47%" align="right">[<a href="showTrialEmp.jsp?pageIndex=0"
                                                          class="right-font08">首页</a> | <a
                                href="showTrialEmp.jsp?pageIndex=${pager.pageIndex-1}"
                                class="right-font08">上一页</a>
                            | <a href="showTrialEmp.jsp?pageIndex=${pager.pageIndex+1}" class="right-font08">下一页</a> |
                            <a href="showTrialEmp.jsp?pageIndex=${pager.pageCount-1}" class="right-font08">末页</a>]
                        </td>
                        <td width="3%">&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
