<%@ page import="com.oa.pub.bean.SkJob" %>
<%@ page import="com.oa.wrj.dao.JobDao" %>
<%@ page import="com.wangrg.java_lib.db2.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wangrg.web_lib.bean.Pager" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/10
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>组织管理</title>
    <script src="../js/jquery/jquery-1.9.0.min.js"></script>
    <SCRIPT language=JavaScript>
        function selectAll() {
            var obj = document.fom.elements;
            for (var i = 0; i < obj.length; i++) {
                if (obj[i].name == "delid") {
                    obj[i].checked = true;
                }
            }
        }

        function unselectAll() {
            var obj = document.fom.elements;
            for (var i = 0; i < obj.length; i++) {
                if (obj[i].name == "delid") {
                    if (obj[i].checked == true) obj[i].checked = false;
                    else obj[i].checked = true;
                }
            }
        }

        function link() {
            document.getElementById("fom").action = "addrenwu.htm";
            document.getElementById("fom").submit();
        }
        function link1() {
            location.href = "../adddept.html";
        }
        function link2() {
            if (document.fom.delid.onchick == true) {
                alert("您的选择没有可执行的操作！");
            } else {
                location.href = "multimod.html";
            }
        }

        function goPage() {
            var value = $("input[name=textfield3]").val();
            var pageIndex = parseInt(value) - 1;
            if (isNaN(pageIndex)) {
                alert("请输入整数");
            } else {
                location.href = "jobselec.jsp?pageIndex=" + pageIndex;
            }
        }

    </SCRIPT>

    <style type="text/css">
        <!--
        .STYLE2 {
            color: #0000FF
        }

        -->
    </style>
</head>

<%
    /*
    // 初始化参数
    int PAGE_SIZE = 3;
    int pageIndex = 0;
    try {
        pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
    } catch (NumberFormatException e) {
    }
    String refreshCount = request.getParameter("refreshCount");

    // 根据pager的状态决定是否更新pager
    JobDao jobDao = new JobDao();
    Pager<Job> pager = (Pager<Job>) session.getAttribute("pager");
    // 如果pager为空或pager不属于该页面，就新建一个属于该页面的pager
    if (pager == null || !request.getServletPath().equals(pager.getPageName())) {
        int count = jobDao.queryCount(null);
        pager = new Pager<>(request.getServletPath(), null, PAGE_SIZE, pageIndex, count);
    } else if ("true".equals(refreshCount)) {// 如果属于该页，且需要更新记录总数（如删除后）
        pager.setTotalCount(jobDao.queryCount(null));
    }

    // 纠正需要跳转的页编号，使其在合理范围
    if (pageIndex < 0) {
        pageIndex = 0;
    } else if (pageIndex >= pager.getPageCount()) {
        pageIndex = pager.getPageCount() - 1;
    }
    pager.setPageIndex(pageIndex);

    // 根据pager获取数据
    int pageSize = pager.getPageSize();
    List<Job> jobList = jobDao.query(Query.build(null).limit(pageIndex * pageSize, pageSize));
    pager.setList(jobList);

    // 把pager设置进session
    session.setAttribute("pager", pager);
    */

    Pager.setPager(request, session, new Pager.OnQueryListener<SkJob>() {
        @Override
        public List<SkJob> queryList(int offset, int rowCount) {
            return new JobDao().query(Query.build(null).limit(offset, rowCount));
        }

        @Override
        public int queryTotalCount() {
            return new JobDao().queryCount(null);
        }
    });
%>

<body>
<div id="man_zone">
    <form name="fom" id="fom" method="post" action="">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td height="30">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td height="62" background="../images/nav04.gif">
                                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="21"><img src="../images/ico07.gif"/></td>
                                        <td width="538">查看岗位信息</td>
                                        <td width="144" align="left"></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td height="20"><span class="newfont07">批处理：<a href="#"
                                                                                       class="right-font08 STYLE2"
                                                                                       onclick="selectAll();">全选</a>-<a
                                                href="#" class="right-font08 STYLE2" onclick="unselectAll();">反选 </a><a
                                                href="../multidel.html" class="right-font08 STYLE2"> 删除</a></span></td>
                                        <td align="right"></td>
                                    </tr>
                                    <tr>
                                        <td height="40" colspan="2" class="font42">
                                            <table width="100%" border="0" cellpadding="4" cellspacing="1"
                                                   class="newfont03">
                                                <tr class="CTitle">
                                                    <td height="22" colspan="10" align="center" style="font-size:16px">岗
                                                        位 详 细 列 表
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#EEEEEE">
                                                    <td width="4%" align="center">
                                                        <div align="center">选择</div>
                                                    </td>
                                                    <td width="5%" align="center" height="30">
                                                        <div align="center">序号</div>
                                                    </td>
                                                    <td width="11%">
                                                        <div align="center">岗位编号</div>
                                                    </td>
                                                    <td width="11%">
                                                        <div align="center">岗位名称</div>
                                                    </td>
                                                    <td width="7%">
                                                        <div align="center">类型</div>
                                                    </td>
                                                    <td width="11%">
                                                        <div align="center">所属部门</div>
                                                    </td>
                                                    <td width="14%">
                                                        <div align="center">部门编号</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">岗位编制</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">编制限定</div>
                                                    </td>
                                                    <td width="25%">
                                                        <div align="center">操作</div>
                                                    </td>
                                                </tr>
                                                <%--TODO--%>
                                                <%--列表数据开始--%>
                                                <c:if test="${fn:length(pager.list)==0}">
                                                    <div align="center">没有数据</div>
                                                </c:if>
                                                <c:if test="${fn:length(pager.list)>0}">
                                                    <c:forEach var="job" items="${pager.list}" varStatus="status">
                                                        <tr bgcolor="#FFFFFF">
                                                            <td>
                                                                <div align="center">
                                                                    <input type="checkbox" name="delid"/>
                                                                </div>
                                                            </td>
                                                            <td height="20">
                                                                <div align="center">${status.index}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center">${job.id}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center"><a href="listmokuaimingxi.htm"
                                                                                       onclick="">${job.name}</a>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div align="center">${job.jobType.attrName}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center">${job.dept.name}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center">${job.dept.id}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center">${job.jobLimit}</div>
                                                            </td>
                                                            <td>
                                                                <div align="center">是</div>
                                                            </td>
                                                            <td>
                                                                <div align="center"><a href="jobmod.jsp">编辑 </a>| <a
                                                                        href="../deljob.html">删除</a> | <a
                                                                        href="jobemplist.jsp?jobId=${job.id}">查询岗位下员工</a>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <%--列表数据结束--%>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td height="6"><img src="../images/spacer.gif" width="1" height="1"/></td>
                                    </tr>
                                    <tr>
                                        <td height="33">
                                            <table width="100%" border="0" align="center" cellpadding="0"
                                                   cellspacing="0" class="right-font08">
                                                <tr>
                                                    <td width="50%">共 <span
                                                            class="right-text09">${pager.pageCount}</span> 页 | 第 <span
                                                            class="right-text09">${pager.pageIndex+1}</span> 页
                                                    </td>
                                                    <td width="49%" align="right">[<a href="jobselec.jsp?pageIndex=0"
                                                                                      class="right-font08">首页</a> | <a
                                                            href="jobselec.jsp?pageIndex=${pager.pageIndex-1}"
                                                            class="right-font08">上一页</a> | <a
                                                            href="jobselec.jsp?pageIndex=${pager.pageIndex+1}"
                                                            class="right-font08">下一页</a>
                                                        | <a href="jobselec.jsp?pageIndex=${pager.pageCount-1}"
                                                             class="right-font08">末页</a>] 转至：
                                                    </td>
                                                    <td width="1%">
                                                        <table width="20" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td width="1%"><input name="textfield3" type="text"
                                                                                      class="right-textfield03"
                                                                                      size="3"/></td>
                                                                <td width="87%"><input name="Submit23222" type="button"
                                                                                       class="right-button06"
                                                                                       onclick="goPage()"
                                                                                       value="GO"/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
