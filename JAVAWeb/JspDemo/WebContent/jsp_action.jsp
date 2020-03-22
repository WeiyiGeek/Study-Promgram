<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 动态标签</title>
</head>
<body>

<!-- 示例1. -->
<h1>这是/Demo1/include.jsp"页面body元素内的内容:</h1>
<jsp:include page="./Demo1/include.jsp"></jsp:include>

<h2>请求转发到/Demo1/forward.jsp页面</h2>
<%--
<jsp:forward page="./Demo1/forward.jsp"></jsp:forward>
--%>

<h3>请求转发携带指定参数到/Demo1/forward.jsp页面</h3>
<jsp:forward page="./Demo1/forward.jsp">
	<jsp:param value="WeiyiGeek" name="name"/>
	<jsp:param value="18" name="age"/>
	<jsp:param value="Computer" name="Love"/>
</jsp:forward>

</body>
</html>