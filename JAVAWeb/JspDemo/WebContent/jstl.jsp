<%@page import="top.weiyigeek.person.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>1) 变量和作用域声明: scope默认是存储在page中  </p>
<c:set var="name" value="WeiyiGeek" scope="page"></c:set>

${pageScope.name} , ${name}

<br>
<p>2) 条件判断 获取表达式的值存记录在flag变量存储在Session里</p>
<c:set var="age" value="18"></c:set>
<c:if test="${ age > 26 }" var="flag" scope="session">
	<b>年龄大于26岁</b>
</c:if>
<c:if test="${ age <= 26}" var="flag1" scope="page">
	<b>年龄小于等于26岁</b>
</c:if>
<p>flag:${flag}</p>
<P>flag1:${flag1}</P>

<br>
<P>3) 循环迭代 </P>
<p>forEach方式:</p>
<c:forEach begin="1" end="10" var="i" step="1" >
	<span>${i} </span>
</c:forEach>
<P>forEach方式2:自定义一个Persion类注意itemn必须采用EL标签</P>
<%
	List list = new ArrayList();
	list.add(new Person("WeiyiGeek",21));
	list.add(new Person("张伟",21));
	list.add(new Person("刘安心",21));
	pageContext.setAttribute("list", list);
%>
<c:forEach var="person" items="${list}">
 <p><b>姓名:</b> ${person.name}, <b>年龄:</b> ${person.age} </p>
</c:forEach>




</body>
</html>