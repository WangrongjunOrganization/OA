<%@ page import="com.wangrg.web_lib.bean.Pager" %>
<%@ page import="com.oa.wrj.dao.JobDao" %>
<%@ page import="com.oa.pub.bean.SkJob" %><%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>部门管理</title>
    <SCRIPT language=JavaScript>
        function sousuo() {
            window.open("gaojisousuo.htm", "", "depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
        }
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

    </SCRIPT>

</head>

<%
    int jobId = Integer.parseInt(request.getParameter("jobId"));
    JobDao jobDao = new JobDao();
    SkJob job = jobDao.queryById(jobId);

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
                                        <td width="21"><img src="../images/ico07.gif" width="20" height="18"/></td>
                                        <td width="538">岗位员工信息列表</td>
                                        <td width="144" align="left"><a href="#" onclick="sousuo()"></a></td>
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
                                        <td height="40" class="font42">
                                            <table width="100%" border="0" cellpadding="4" cellspacing="1"
                                                   bgcolor="#464646" class="newfont03">
                                                <tr class="CTitle">
                                                    <td height="22" colspan="12" align="center" style="font-size:16px">岗
                                                        位 员 工 信 息 列 表
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#EEEEEE">
                                                    <td width="3%" align="center" height="30">
                                                        <div align="center">序号</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">岗位编号</div>
                                                    </td>
                                                    <td width="11%">
                                                        <div align="center">岗位名称</div>
                                                    </td>
                                                    <td width="7%">
                                                        <div align="center">部门编号</div>
                                                    </td>
                                                    <td width="9%">
                                                        <div align="center">部门名称</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">员工姓名</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">员工编号</div>
                                                    </td>
                                                    <td width="8%">
                                                        <div align="center">职务</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">联系电话</div>
                                                    </td>
                                                    <td width="19%">
                                                        <div align="center">入职日期</div>
                                                    </td>
                                                    <td width="9%">
                                                        <div align="center">人数总计</div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td height="20">
                                                        <div align="center"> 1</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政主管</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政部</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 张三</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275088</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275080</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 13032173891</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1997-08-06</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">5</div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td height="20">
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政主管</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 3</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">生产部</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">张三力</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275088</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275080</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 13032173891</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1997-08-06</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">5</div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td height="20">
                                                        <div align="center">3</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政主管</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 3</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">生产部</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">张三</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275088</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275080</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 13032173891</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1997-08-06</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">5</div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td height="20">
                                                        <div align="center">4</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政主管</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 4</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">销售部</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">张三</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275088</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275080</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 13032173891</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1997-08-06</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">5</div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td height="20">
                                                        <div align="center">5</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">2</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">行政主管</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 5</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">技术部</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">张三</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275088</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 64275080</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 13032173891</div>
                                                    </td>
                                                    <td>
                                                        <div align="center"> 1997-08-06</div>
                                                    </td>
                                                    <td>
                                                        <div align="center">5</div>
                                                    </td>
                                                </tr>
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
                                                    <td width="49%">共 1 页 | 第 <span class="right-text09">1</span> 页</td>
                                                    <td width="48%" align="right">&nbsp;</td>
                                                    <td width="5%">&nbsp;</td>
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