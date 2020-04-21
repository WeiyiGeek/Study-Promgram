<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 使用jstl内置函数 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员信息编辑</title>
</head>


<body>
<script>
function submit_check(){
	if ( confirm("您是否进行更新提交?") ) {
		return true;
	}else{
		return false;
	}
}
</script>
	<form action="updatePersonServlet" method="POST" onsubmit="return submit_check()">
		<input type="hidden" name="sid" value="${person.sid }">
		<!-- 采用表格会更好看一点 -->
		<table border="1" width="auto" cellpadding="1" cellspacing="0">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${person.sname }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
				   <input type="radio"
					name="gender" value="男"
					<c:if test="${person.gender == '男'}">checked</c:if>>男 <input
					type="radio" name="gender" value="女"
					<c:if test="${person.gender == '女'}">checked</c:if>>女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="telephone" value="${person.telephone }"></td>
			</tr>
			<tr>
				<td>加入时间</td>
				<td><input type="text" name="jointime" value="${person.jointime }"></td>
			</tr>
			<tr>
				<td>job</td>
				<td>
					<input type="checkbox" name="job"value=安全
					<c:if test="${fn:contains(person.job,'安全') }">checked</c:if>>安全
					<input type="checkbox" name="job" value="运维"
					<c:if test="${fn:contains(person.job,'运维') }">checked</c:if>>运维
					<input type="checkbox" name="job" value="开发"
					<c:if test="${fn:contains(person.job,'开发') }">checked</c:if>>开发
					<input type="checkbox" name="job" value="测试"
					<c:if test="${fn:contains(person.job,'测试') }">checked</c:if>>测试
					<input type="checkbox" name="job" value="主管"
					<c:if test="${fn:contains(person.job,'主管') }">checked</c:if>>主管
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="3" cols="20">${person.info }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新"></td>
			</tr>
		</table>
	</form>
</body>
</html>