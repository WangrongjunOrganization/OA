<%@ page import="com.oa.pub.bean.MaTable" %>
<%@ page import="com.oa.wrj.dao.MaTableDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/12
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>管理区域</title>
    <style type="text/css">
        <!--
        .STYLE1 {
            color: #FF0000
        }

        -->
    </style>
    <script type="text/javascript" language="javascript">
        function link1() {
            if (document.fom.name.value == "") {
                alert("您没有输入岗位名称");
                return false;
            }
            if (document.fom.jobLimit.value == "") {
                alert("岗位编制不能为空！");
                return false;
            }
        }
    </script>
</head>

<%
    List<MaTable> maTableList = new MaTableDao().queryJobType();
    request.setAttribute("maTableList", maTableList);
%>

<body>
<div id="man_zone">
    <form action="addJob.action" method="post" name="fom" id="fom" target="manFrame" onsubmit="return link1();">
        <div class="MainDiv">
            <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
                <tr>
                    <th class="tablestyle_title">
                        <div align="left">岗位添加页面</div>
                    </th>
                </tr>
                <tr>
                    <td class="CPanel">
                        <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
                               class="newfont03">
                            <tr class="CTitle">
                                <td height="22" colspan="10" align="center" style="font-size:16px">添 加 岗 位</td>
                            </tr>
                            <tr bgcolor="#EEEEEE">
                                <td colspan="2" align="center">
                                    <div align="center">序号</div>
                                    <div align="center"></div>
                                </td>
                                <td>
                                    <div align="center">岗位名称<span class="STYLE1">*</span></div>
                                </td>
                                <td>
                                    <div align="center">类型</div>
                                </td>
                                <td>
                                    <div align="center">岗位编制<span class="STYLE1">*</span></div>
                                </td>
                                <td>
                                    <div align="center">编制限定<span class="STYLE1">*</span></div>
                                </td>
                                <td>
                                    <div align="center">操作</div>
                                </td>
                            </tr>
                            <tr bgcolor="#FFFFFF">
                                <td>
                                    <%--序号--%>
                                    <div align="center">1</div>
                                </td>
                                <td colspan="2" align="center">
                                    <%--岗位名称--%>
                                    <div align="center">
                                        <label>
                                            <input name="name" type="text" size="16"/>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <%--类型--%>
                                    <div align="center">
                                        <select name="jobTypeMaTableId">
                                            <c:forEach var="maTable" items="${maTableList}">
                                                <option value="${maTable.id}">${maTable.valueName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <%--岗位编制--%>
                                    <div align="center">
                                        <label>
                                            <input name="jobLimit" type="text" size="10"/>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <%--编制限定--%>
                                    <div align="center">
                                        <label>
                                            <select name="select2">
                                                <option value="是">是</option>
                                                <option value="否">否</option>
                                            </select>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <%--操作--%>
                                    <div align="center">
                                        <label>
                                            <input name="Submit" type="submit" value="保存">
                                        </label>
                                        <label>
                                            <input name="reset" type="reset" value="取消"/>
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
</body>
</html>
