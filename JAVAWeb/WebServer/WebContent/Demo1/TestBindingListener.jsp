<%@page import="top.weiyigeek.main.BeanListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestBindingListener.jsp</title>
</head>
<body>
<h1>TestBindingListener.jsp</h1>

<%
	//1.Bean 实现类进行相关操作首先实例化
	BeanListener bl = new BeanListener();
	//2.Bean 操作存储值
	bl.setName("WeiyiGeek");
	//3.session 作用域属性设置将对象存储进去
	session.setAttribute("bean", bl);
	//4.session 作用域移除属性
	session.removeAttribute("bean");
	
	
%>

</body>
</html>