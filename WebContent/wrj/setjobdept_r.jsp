<%@ page import="com.oa.wrj.dao.DeptDao" %>
<%@ page import="com.oa.pub.bean.SkDept" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oa.wrj.dao.JobDao" %>
<%@ page import="com.oa.pub.bean.SkJob" %><%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%
    List<SkDept> deptList = new DeptDao().queryAllWithJobList();
    List<SkJob> jobList = new JobDao().queryAllWithoutForeignKeyObject();
    request.setAttribute("deptList", deptList);
    request.setAttribute("jobList", jobList);
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>管理区域</title>
    <style type="text/css">
        <!--
        .STYLE1 {
            color: #FF0000
        }

        -->
    </style>
</head>

<body>
<div id="man_zone">
    <form action="sec1.html" method="post" name="fom" id="fom" target="manFrame">
        <div class="MainDiv">
            <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
                <tr>
                    <th class="tablestyle_title">
                        <div align="left">设置岗位与部门关系的页面</div>
                        <button align="left" onclick="location.href='wrj/seljobdept_r.jsp'">刷新</button>
                    </th>
                </tr>
                <tr>
                    <td class="CPanel">
                        <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
                               class="newfont03">
                            <tr class="CTitle">
                                <td height="22" colspan="10" align="center" style="font-size:16px">设置岗位与部门关系</td>
                            </tr>
                            <tr bgcolor="#EEEEEE">
                                <td colspan="2" align="center">
                                    <div align="center">序号</div>
                                    <div align="center"></div>
                                </td>
                                <td>
                                    <div align="center">部门名称<span class="STYLE1">*</span></div>
                                </td>
                                <td>
                                    <div align="center">选择岗位<span class="STYLE1">*</span></div>
                                </td>
                                <td>
                                    <div align="center">操作</div>
                                </td>
                            </tr>
                            <tr bgcolor="#FFFFFF">
                                <td colspan="2" align="center">
                                    <div align="center">1</div>
                                </td>
                                <td>
                                    <div align="center">
                                        <label>
                                            <select id="dept" name="super" size="15" style="width:120px;"
                                                    onchange="changeDept(this.options[this.options.selectedIndex].value)">
                                                <c:forEach var="dept" items="${deptList}">
                                                    <option value="${dept.id}">${dept.name}</option>
                                                </c:forEach>
                                            </select>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <div align="center">
                                        <label>
                                            <select id="job" name="select2" size="15" style="width:120px;">
                                                <c:forEach var="job" items="${jobList}">
                                                    <option value="${job.id}">${job.name}</option>
                                                </c:forEach>
                                            </select>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <div align="center">
                                        <label>
                                            <input name="Submit" type="button" onclick="addR()" value="添加岗位">
                                        </label>
                                        <label>
                                            <input name="Submit" type="button" onclick="removeR()" value="移除岗位">
                                        </label>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>

<script src="../js/jquery-1.9.0.min.js"></script>
<script src="../js/util/TextUtil.js"></script>
<script>
    var map = new Map();
    var array;

    <c:forEach var="dept" items="${deptList}">
    array = [];
    <c:forEach var="job" items="${dept.jobList}" varStatus="status">
    array[${status.index}] = ${job.id};
    </c:forEach>
    map.set("${dept.id}", array);
    </c:forEach>

    // 打开页面时就自动选中第一项
    $("#dept option:first").attr("selected", "true");
    $("#job option:first").attr("selected", "true");
    changeDept("1");

    function changeDept(deptId) {
        $("#job option").each(function () {
            var jobId = $(this).val();
            var jobIdArray = map.get(deptId);
            if (isContainElement(jobIdArray, jobId)) {// 需要加上“（已存在）”
                var jobName = $(this).text();
                if (!jobName.endsWith("（已存在）")) {
                    $(this).text(jobName + "（已存在）");
                }
            } else {// 需要删除“（已存在）”
                jobName = $(this).text();
                if (jobName.endsWith("（已存在）")) {
                    $(this).text(jobName.replace("（已存在）", ""));
                }
            }
        })
    }

    function isContainElement(list, element) {
        for (var i = 0; i < list.length; i++) {
            if (list[i] == element) {
                return true;
            }
        }
        return false;
    }
</script>
<script>
    function addR() {
        var jobName = $("#job option:selected").text();
        if (jobName.endsWith("（已存在）")) {
            alert("岗位已存在，无法执行添加操作！");
            return;
        }
        var deptId = $("#dept option:selected").val();
        var jobId = $("#job option:selected").val();
        location.href = "setJobDeptR.action?action=add&jobId=" + jobId + "&deptId=" + deptId;
    }
    function removeR() {
        var jobName = $("#job option:selected").text();
        if (!jobName.endsWith("（已存在）")) {
            alert("岗位不存在，无法执行移除操作！");
            return;
        }
        var jobId = $("#job option:selected").val();
        location.href = "setJobDeptR.action?action=remove&jobId=" + jobId;
    }
</script>

</body>
</html>
