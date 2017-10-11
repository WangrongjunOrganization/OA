<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

       
<link rel="stylesheet" href="../css/common.css" type="text/css" />
<title>部门管理</title>
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT language=JavaScript>


function link1(){
   if(document.fom.deptname.value==""){
   	alert("您没有输入部门名称");
	return false;
   }
   return true;
  }

</SCRIPT>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
</head>

<body>
<div id="man_zone">
<form name="fom" id="fom" method="post" action="../adddept.do" onsubmit="return link1();">
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" >
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"></td>
			  <td width="538"><strong>添加部门</strong></td>
			  <td width="144" align="left"><a href="#" onclick="sousuo()"></a></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="10" align="center" style="font-size:16px"> 添 加 部 门 </td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
					<td colspan="2" align="center"><div align="center">序号</div>
                    <td><div align="center">部门名称<span class="STYLE1">*</span></div></td>
					<td><div align="center">类型</div></td>
                    <td><div align="center">电话</div></td>
					<td><div align="center">传真</div></td>
					<td><div align="center">描述</div></td>
					<td><div align="center">上级部门</div></td>
					<td><div align="center">成立日期</div></td>
					<td><div align="center">操作</div></td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
					<td colspan="2" align="center"><div align="center">1</div></td>
                    <td ><div align="center">
                      <label>
                      <input name="name" type="text" size="10" />
                      </label>
                    </div></td>
					<td>
					  <div align="center">
					    <label>
					    <select name="type">
					      <option value="公司">公司</option>
					      <option value="部门">部门</option>
					      </select>
					    </label>
</div>			</td>
                    <td><div align="center">
                      <label>
                      <input name="tele" type="text" size="10" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="fax" type="text" size="10" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="discrip" type="text" size="12" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <select name="sksuper">
							<option value="1">行政部</option>
							<option value="2">生产部</option>
							<option value="3">技术部</option>
							<option value="4">销售部</option>
							<option value="5">财务部</option>
					  </select>
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="createtime" type="text" size="16" onClick="WdatePicker()" readonly="readonly" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="Submit" type="submit" value="保存"  /> 
                      </label>
                      <label>
                      <input name="reset" type="reset" value="重置" />
                      </label>
                    </div>
		   </td>
                  </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="49%">共 1 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="48%" align="right">&nbsp;</td>
                <td width="5%">&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</td>
</tr>
</table>
</form>

 
</div>
</body>
</html>