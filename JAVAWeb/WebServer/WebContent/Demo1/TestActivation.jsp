<%@page import="top.weiyigeek.main.BeanActivation"%>
<%@page import="top.weiyigeek.main.BeanListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestActivation.jsp</title>
</head>
<body>
<H1>TestActivation.jsp | 该页面设置session作用域的值 （钝化）</H1>

<%
	//Session 钝化与活化
	BeanActivation bl = new BeanActivation();
	bl.setName("WeiyiGeek");
	
	//session.值获取
	session.setAttribute("bean", bl);
	
%>
</body>
</html>