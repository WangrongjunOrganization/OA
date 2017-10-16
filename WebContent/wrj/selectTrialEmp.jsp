<%@ page import="com.oa.wrj.dao.DeptDao" %>
<%@ page import="com.oa.pub.bean.SkDept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/15
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>无标题文档</title>
    <script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
    <style type="text/css">
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-image: url(../images/bg.gif);
        }

        .STYLE4 {
            color: #666
        }

        .STYLE5 {
            font-size: 16px
        }
    </style>

    <script src="../js/jquery-1.9.0.min.js"></script>
    <script>
        $(function () {
            $("input[name=empId]").on("focusout", function () {
                if (!yanzheng()) {
                    $("#hint_empId").css("color", "red").text("请输入整数");
                } else {
                    $("#hint_empId").text("");
                }
            });
        });

        function yanzheng() {
            var regex = /^[0-9]+$/;
            var empId = $("input[name=empId]").val();
            return empId == "" || regex.test(empId);
        }
    </script>
</head>

<%
    List<SkDept> deptList = new DeptDao().queryAllOnlyWithName();
    request.setAttribute("deptList", deptList);
%>

<body>
<div id="man_zone">
    <form id="form1" name="form1" method="post" onsubmit="return yanzheng();" action="showTrialEmp.jsp">
        入职员工查询
        </label>
        <label></label>
        <label></label>
        <label></label>
        <label></label>
        <label><br/>
        </label>
        <table width="100%" border="0">
            <tr>
                <td height="22" align="center" style="font-size:16px">
                    <div align="center">入职员工查询
                        </label>
                    </div>
                </td>
                </td>
            </tr>
        </table>
        <label><br/>
        </label>
        <table width="50%" border="0" align="center">
            <tr>
                <td colspan="2"><span class="STYLE4">请输入查询条件：（至少填写一项）</span></td>
            </tr>
            <tr>
                <td width="43%"><label><span class="STYLE4">员工编号：      </span></label></td>
                <td width="57%">
                    <input type="text" name="empId"/>
                    <span id="hint_empId"></span>
                </td>
            </tr>
            <tr>
                <td><span class="STYLE4">员工姓名（支持模糊查询） ：</span></td>
                <td><input type="text" name="empName"/></td>
            </tr>
            <tr>
                <td>员工部门：</td>
                <td>
                    <select name="deptId">
                        <option value="">-- 未选择 --</option>
                        <c:forEach var="dept" items="${deptList}">
                            <option value="${dept.id}">${dept.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><span class="STYLE4">入职时间：</span></td>
                <td><input type="text" name="beginTime" onClick="WdatePicker()" readonly="readonly"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="buttion" value="查询"/></td>
                <td>&nbsp;</td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
