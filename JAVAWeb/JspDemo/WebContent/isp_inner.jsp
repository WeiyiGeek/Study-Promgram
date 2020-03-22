<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>内部对象</title>
</head>
<body>

<h1>九大内置对象</h1>
<%=page.toString() %>
<br>
<%--=exception.toString() --%>
<%=config.toString() %>
<br>
<% out.write("\n 其次输出jspWriter 对象输出  <br>"); %>
<br>
<% response.getWriter().write("\n 首先输出 Response 对象输出 <br>"); %>

<h2>内置作用域对象设置</h2>
<% pageContext.setAttribute("name", "pageContext"); %>
<% request.setAttribute("name", "request"); %>
<% session.setAttribute("name", "session"); %>
<% application.setAttribute("name", "application"); %>

<hr>
<p>四大内置作用域对象输出</p>
<%=pageContext.getAttribute("name") %>
<%=request.getAttribute("name") %>
<%=session.getAttribute("name") %>
<%=application.getAttribute("name") %>

</body>
</html>