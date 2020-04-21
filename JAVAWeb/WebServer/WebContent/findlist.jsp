<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作人员显示</title>
</head>
<body>
<script>

function doDelete(sid){
	var flag = confirm("是否确定删除该位员工?");
	if (flag){
		location.href="delPersonServlet?sid="+sid;
	}
}

</script>
<div align="center">
<form action="SearchPersonServlet" method="post">
<table border="1" width="auto" cellpadding="1" cellspacing="0">
	<tr>
		<td colspan="8">
				按姓名查询:<input type="text" name="sname"/>
					&nbsp;
					按性别查询:<select name="sgender">
								<option value="">--请选择--
								<option value="男">男
								<option value="女">女
							  </select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
		</td>
	</tr>
	<tr><th>SID</th><th>姓名</th><th>性别</th><th>电话号码</th><th>工作职位</th><th>加入时间</th><th>备注</th><th>操作</th></tr>
	<!-- jstl 表达式 -->
	<c:forEach items="${ PersonList }" var="person">
	<tr>
		<td>${person.sid}</td>
		<td>${person.sname}</td>
		<td>${person.gender}</td>
		<td>${person.telephone}</td>
		<td>${person.job}</td>
		<td>${person.jointime}</td>
		<td>${person.info}</td>
		<td><a href="editPersonServlet?sid=${ person.sid }">修改</a> | <a href="#" onclick="doDelete(${person.sid})">删除</a></td>
	</tr>
	</c:forEach>
	
	
</table>
</form>
</div>


</body>
</html>