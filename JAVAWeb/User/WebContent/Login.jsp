<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>

<h2>用户登录:</h2>
<form action="Login" method="post">
	<label for="name">用户名：</label>
	<input type="text" id="name" name="name" value="" max="16" />
	<br>
	<label for="pass">密码：</label>
	<input type="password" id="pass" name="pass" value="" max="16" min="6"/>
	<br>
	<input type="submit" value="登录">
	<input type="button" id="reset" value="重置">
</form>
</body>
</html>