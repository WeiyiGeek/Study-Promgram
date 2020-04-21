<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Session</title>
</head>
<body>
<h1>Session 操作显示 </h1>
<p>
<!-- 简单的JSP定义说明 -->
<%! int a = 1234; %>
<% int b = 1024; %>
<b>a 值 = </b><%=a %> <br/>
<b>b 值 = </b><%=b %> <br/>
</p>

<!-- 登陆表单判断用户是否登录 -->
<!-- //3.获取会话设置的属性 -->
<% if (session.getAttribute("login") != "yes") { %>
<form action="Demo3" method="get">
	用户名称: <input type="text" name="name"><br>
	用户密码: <input type="password" name="pass"><br>
	<input type="submit" value="提交">
</form>
<% } else { %>
	<h4>尊敬的用户您已经成功登录了</h4> <p><a href="Demo3?action=logout">注销登陆</a></p>
	<p>请选择购买的商品：</p>
	<ol>
		<li><a href='Demo3?id=1'>安全数据</a></li>
		<li><a href='Demo3?id=2'>安全开发运维</a></li>
		<li><a href='Demo3?id=3'>DevOps</a></li>
		<li><a href='Demo3?id=4'>大型分布式网站架构</a></li>
		<li><a href='Demo3?id=5'>安全威胁分析</a></li>
	</ol>
	<hr>
	<p>您的购物车:<a href="#cart">go</a></p>
	<div>
		<table style="border: 1px black solid" cellspacing="1" cellpadding="1"  rules="all" align="center">
			<tr><th>商品名称</th> <th>购买数量</th></tr>
				<% //6.从Session中获取到map;
					Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("cart");
					//遍历Map
					if (map != null)
					{
						for(String key: map.keySet()){
							int value = map.get(key);
							%>
							<tr> <td><%=key %></td> <td><%=value %> 本</td> </tr>
							<% 
						}
					}else{
						%>
							<tr> <td>暂无</td> <td>暂无</td> </tr>
						<%
					}
				%>
				
			</table>
	</div>
	<br>
	<p><a href="Demo3?action=del">清空购物车</a></p>
<% } %>
</body>
</html>