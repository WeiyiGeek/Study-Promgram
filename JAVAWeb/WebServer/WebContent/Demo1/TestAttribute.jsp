<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>属性监听器进行更改</title>
</head>
<body>
<h1> TestAttribute.jsp 测试 监听器属性</h1>
<%
	//（1）session 作用域属性设置
	session.setAttribute("name", "WeiyiGeek");
	
	//（2）属性替换
	session.setAttribute("name", "TestWeiyi");
	
	//（3）移除属性
	session.removeAttribute("name");
%>
</body>
</html>