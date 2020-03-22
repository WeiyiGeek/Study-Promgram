<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body>
<% 
	//判断用户是否成功登陆登录则显示，否则不显示
	if(!"ok".equals(session.getAttribute("login"))){
%>
	<script type="text/javascript">alert('您还未登录，请重新登录!');window.location="./Login.jsp";</script>
<% 
	response.sendRedirect("Login.jsp");
	}
%>

<B>管理员信息列表:</B>
<table border="1" width="700">
	<tr>
	<th>序号</th><th>姓名</th><th>密码</th><th>年龄</th><th>地址</th>
	</tr>
	<c:forEach items="${list}" var="user">
	<tr>
		<td>${user.id}</td>
		<td>${user.username}</td>
		<td>${user.password}</td>
		<td>${user.age}</td>
		<td>${user.address}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>