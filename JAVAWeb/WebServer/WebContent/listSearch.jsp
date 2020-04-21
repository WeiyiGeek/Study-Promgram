<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${words}" var="word">
	<span style="font-size:x-small;" align="left" onclick="setting(this)">${word.title }</span>
	<span style="width: 100%;display: block;border: 0.1px solid black"></span>
</c:forEach>
</body>
</html>