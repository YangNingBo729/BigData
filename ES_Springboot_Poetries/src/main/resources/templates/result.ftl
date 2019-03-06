<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarkerTest</title>
</head>
<body>


<table align="center" border="1">
    <tr>
        <td>诗人</td>
        <td>标题</td>
        <td>内容</td>
        <td>时间</td>
    </tr>
    <#list result as p>
        <tr>
        <td>${p.name}</td>
        <td>${p.title}</td>
        <td>${p.content}</td>
        <td>${p.created?datetime}</td>
        </tr>
    </#list>
</table>
</body>
</html>