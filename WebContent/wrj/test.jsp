<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/10/12
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<button id="btn">获取码表</button>
<div id="msg1">1</div>
<div id="msg2">2</div>
<div id="msg3">3</div>
<div id="msg4">4</div>
<div id="msg5">5</div>

<script src="../js/jquery-1.9.0.min.js"></script>
<script>
    $("#btn").click(function () {
        $btn = $(this);
        $btn.text("正在获取...");
        $btn.attr("disabled", "disabled");

        $.get("test.action?maTableId=2", function (result) {
            $btn.removeAttr("disabled");
            $btn.text("获取码表");
            $("#msg1").text(result);
            var json=JSON.parse(result);
            $("#msg2").text(json.id);
            $("#msg3").text(json.name);
            $("#msg4").text(json.attrName);
            $("#msg5").text(json.attrValue);
        });

    })
</script>

</body>
</html>
