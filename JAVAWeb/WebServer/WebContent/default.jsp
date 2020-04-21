<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<h3> WeiyiGeek blog  </h3>
<c:if test="${not empty user}">
<p> 欢迎您， ${user.sname} 用户</p>
</c:if>
<c:if test="${empty user}">
<p> 您好， <a href="./Login.jsp">请登陆</a></p>
</c:if>
</body>
</html>