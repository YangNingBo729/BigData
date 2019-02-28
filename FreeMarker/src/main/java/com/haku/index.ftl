<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
<h1>您好：${name}</h1>
<hr>
${b?c}
    <hr>
<#if b>
    this is true
<#else>
    this is false
</#if>

    <hr>
${isNull!"this is default value"}

    <hr>
<#if isNull??>
    值存在
<#else >
    值不存在
</#if>


</body>
</html>