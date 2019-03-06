<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="${pageContext.request.contextPath }/jquery.min.js"></script>
</head>
<body>
<h2 align="center">唐诗检索系统</h2>

<div align="center"><input type="text" name="key" id="key">&nbsp;&nbsp;&nbsp;<button onclick="sub()"> 搜索</button>
</div>
<div align="center">
    <input type="radio" name="type" value="name">诗人
    <input type="radio" name="type" value="title">标题
    <input type="radio" name="type" value="content">内容
</div>

<script>
    function sub() {
        var key = $("#key").val();
        var type = $("input:radio:checked").val();
        console.log(key + type);
        location.href = "${pageContext.request.contextPath}/search/" + type + "/" + key
    }
</script>
</body>
</html>
