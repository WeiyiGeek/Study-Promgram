<%@page import="top.weiyigeek.main.BeanListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestActivation1.jsp</title>
</head>
<body>
<H1>TestActivation1.jsp | 该页面获取session作用域的值(活化) </H1>
<%
	session.getAttribute("bean");
%>

session 作用域活化后的值:   ${bean.name}

</body>
</html>