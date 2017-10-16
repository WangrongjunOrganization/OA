<%@ page import="com.oa.wrj.dao.JobDao" %>
<%@ page import="com.oa.pub.bean.SkJob" %><%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/12
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../css/common.css" type="text/css"/>
    <title>岗位管理</title>
    <style type="text/css">
        <!--
        .STYLE1 {
            color: #FF0000
        }

        .STYLE3 {
            font-size: 12px;
            font-weight: bold;
        }

        -->
    </style>
    <script type="text/javascript" language="javascript">
        function link1() {
            if (document.fom.jobid.value == "") {
                alert("您没有输入岗位编号");
                return false;

            }
            if (document.fom.jobname.value == "") {
                alert("您没有输入岗位名称");
                return false;
            }
            return true;
        }
    </script>
</head>

<%
    int jobId = Integer.parseInt(request.getParameter("jobId"));
    SkJob job = new JobDao().queryById(jobId);
    request.setAttribute("job", job);
%>

<body>
<div id="man_zone">
    <form action="../delsec1.html" target="manFrame" name="fom" id="fom">
        <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            <tr class="CTitle">
                岗位信息修改
                <button onclick="history.back()">返回</button>
                <td height="22" colspan="9" align="center" style="font-size:16px">
                    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="21">&nbsp;</td>
                            <td width="538"><span class="STYLE3">修改岗位信息</span></td>
                            <td width="144" align="left"><a href="#" onclick="sousuo()"></a></td>
                        </tr>
                    </table>
                    岗 位 修 改
                </td>
            </tr>
            <tr bgcolor="#EEEEEE">
                <td width="5%" align="center" height="30">
                    <div align="center">序号</div>
                </td>
                <td width="11%">
                    <div align="center">岗位编号<span class="STYLE1">*</span></div>
                </td>
                <td width="11%">
                    <div align="center">岗位名称<span class="STYLE1">*</span></div>
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
                    <div align="center">岗位编制<span class="STYLE1">*</span></div>
                </td>
                <td width="8%">
                    <div align="center">编制限定<span class="STYLE1">*</span></div>
                </td>
                <td width="25%">
                    <div align="center">确认删除</div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF">
                <td height="20">
                    <div align="center">1</div>
                </td>
                <td>
                    <div align="center">
                        <label>${job.id}</label>
                    </div>
                </td>
                <td>
                    <div align="center"><a href="listmokuaimingxi.htm" onclick=""></a>
                        <label>${job.name}</label>
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label></label>
                        ${job.jobType.valueName}
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label>
                            ${job.dept.name}</label>
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label> </label>
                        ${job.dept.id}
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label>
                            ${job.jobLimit}</label>
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label>是</label>
                    </div>
                </td>
                <td>
                    <div align="center">
                        <label>
                            <input name="Submit" type="button" value="删除"
                                   onclick="location.href = 'deleteJob.action?jobId=${job.id}'"/>
                        </label>
                        <label>
                            <input name="reset" type="reset" value="取消" onclick="history.back()"/>
                        </label>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
