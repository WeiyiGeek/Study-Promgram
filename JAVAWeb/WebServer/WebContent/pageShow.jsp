<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页数据显示</title>
</head>
<body>
<div align="center">
<table border="1" width="auto" cellpadding="1" cellspacing="0">
	<tr><th>SID</th><th>姓名</th><th>性别</th><th>电话号码</th><th>工作职位</th><th>加入时间</th><th>备注</th><th>操作</th></tr>
	<!-- jstl 表达式 -->
	<c:forEach items="${page.lp }" var="person">
	<tr>
		<td>${person.sid}</td>
		<td>${person.sname}</td>
		<td>${person.gender}</td>
		<td>${person.telephone}</td>
		<td>${person.job}</td>
		<td>${person.jointime}</td>
		<td>${person.info}</td>
		<td><a href="editPersonServlet?sid=${person.sid }">修改</a> | <a href="#" onclick="doDelete(${person.sid})">删除</a></td>
	</tr>
	</c:forEach>
	<tr>
	<!-- 
	private int currentPage; //显示第几页
	private int showCount; //每页显示几条
	private int pageTotal; //一共几页
	private int total; //信息总条数
	private List<Person> lp; //查询到的的数据
	 -->
	<td colspan="8"> 
	第 ${page.currentPage} / ${page.pageTotal} 页  &nbsp; &nbsp; 
	每页显示:${page.showCount} 条 &nbsp;&nbsp; 
	总共有:${page.total} 条 &nbsp; &nbsp; 
	<c:if test="${ page.currentPage != 1 }">
		<a href="pageList?page=1&count=${page.showCount}">首页</a> &nbsp; 
		<a href="pageList?page=${page.currentPage - 1}&count=${page.showCount}">上一页 </a> &nbsp;  | 
	</c:if>
	
	<!-- 遍历显示页数(坑呀) -->
	<c:forEach begin="1" end="${page.pageTotal}" var="i">
		<c:if test="${page.currentPage == i}">
			<span style="color:red">${page.currentPage}</span> &nbsp; 
		</c:if>
		<c:if test="${page.currentPage != i}">
			<a href="pageList?page=${i}&count=${page.showCount}">${i}</a> &nbsp; 
		</c:if>
	</c:forEach>

	
	<c:if test="${ page.currentPage != page.pageTotal }">
		| <a href="pageList?page=${page.currentPage + 1}&count=${page.showCount}">下一页 </a> &nbsp; 
		<a href="pageList?page=${page.pageTotal}&count=${page.showCount}">末页 </a> 
	</c:if>
	
</td>
<tr>
</table>
</div>


</body>
</html>