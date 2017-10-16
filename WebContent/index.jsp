<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>人事管理系统</title>
</head>
<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="topframe.html" name="topFrame" frameborder="no" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset name="myFrame" cols="199,7,*" frameborder="no" border="0" framespacing="0">
    <frame src="leftframe.jsp" name="leftFrame" frameborder="no" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="switchframe.html" name="midFrame" frameborder="no" scrolling="no" noresize="noresize" id="midFrame" title="midFrame" />
    <frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
         <frame src="mainframe.html" name="mainFrame" frameborder="no" scrolling="no"  noresize="noresize" id="mainFrame" title="mainFrame" />
         <frame src="test.html" name="manFrame" frameborder="no" id="manFrame" title="manFrame" />
     </frameset>
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes>
</html>