<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
</head>
<body>
<div class="login" style="border: 1px black solid">
   <form action="LoginServlet" method="POST">
	用户: <input type="text" name="username"> <br/>
	密码: <input type="text" name="password"> <br/>
	<input type="checkbox" name="autoLogin"> 自动登陆   <br/>
   	<input type="submit" value="登陆">
   	<input type="button" value="注册" onclick="location.href='./Register.jsp'"> 
   </form>
</div>
</body>
</html>