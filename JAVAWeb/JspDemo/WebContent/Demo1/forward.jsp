<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>转发页面</title>
</head>
<body>
	<h1>Forward.jsp?<%=request.getQueryString() %></h1>
	<p>显示转发请求的参数:</p>
	Name:<%=request.getParameter("name") %>
	<br>
	Age:<%=request.getParameter("age") %>
	<br>
	喜好:<%=new String(request.getParameter("Love").getBytes("ISO-8859-1"),"UTF-8") %>
</body>
</html>