<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 表达式 11 个内置对象</title>
</head>
<body>

<p>1) 获取URL请求参数 </p>
方式1: <%=request.getParameter("name") %>
<br>
方式2: ${param.name}


<p>2) 获取请求的Cookies </p>
<% response.addCookie(new Cookie("name","weiyigek")); %>
${cookie.name.name} 值: ${cookie.name.value}

</body>
</html>