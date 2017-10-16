<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/12
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="del()">删除</button>
<table>
    <tr>
        <th>选择</th>
        <th>编号</th>
        <th>姓名</th>
    </tr>
    <tr>
        <td><input type="checkbox"></td>
        <td>1</td>
        <td>wrj</td>
    </tr>
    <tr>
        <td><input type="checkbox"></td>
        <td>2</td>
        <td>hjc</td>
    </tr>
</table>

<script src="../js/jquery-1.9.0.min.js"></script>
<script>

    function del() {
        console.log($(":checked"));
        console.log($(":checked").parent());
        console.log($(":checked").parent().parent());
        $(":checked").parent().parent().remove();
    }

</script>

</body>
</html>
