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

<script>

    // 定义
    var map = new Map();

    // 添加数据
    map.set(1, 10);
    map.set("2", 20);
    map.set(3, "30");

    // 根据键获取值
    console.log(map.get(1));// 10
    console.log(map.get("1"));// undefined
    console.log(map.get(2));// undefined
    console.log(map.get("2"));// 20
    console.log(map.get(3));// "30"

    // 获取长度
    console.log(map.size);// 3

    // 遍历
    map.forEach(function (value, key) {
        console.log(key + " - " + value);
        // "1 - 10"
        // "2 - 20"
        // "3 - 30"
    });

</script>

</body>
</html>
