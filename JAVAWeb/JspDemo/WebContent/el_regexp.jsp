<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式</title>
</head>
<body>

<p>1) 采用EL表达式输出变量属性的值</p>
<% 
int a = 1024; 
String b = "Java Program"; 
pageContext.setAttribute("a",a);
pageContext.setAttribute("b",b);
%>

${a}
${b}

<hr>

<p>2) 采用EL表达式输出内置4大域对象定义的属性</p>
<%
	pageContext.setAttribute("name", "pageContext");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "application");
%>

${pageScope.name}
${requestScope.name}
${sessionScope.name}
${ applicationScope.name }

<hr>

<p>3) 采用EL表达式输出数组内容</p>
<%
	String[] name = {"WeiyiGeek","Weiyi","Weiye"};
	pageContext.setAttribute("arrayName", name);
%>

${arrayName[0]} ,${ arrayName[1] },${ arrayName[2] }

<hr>

<p>4) 采用EL表达式输出数组集合 ArrayList 内容</p>
<%
	ArrayList al = new ArrayList();
	al.add("abc");
	al.add("def");
	al.add("1024");
	pageContext.setAttribute("al", al);
%>

${al[0]},${al[1]},${al[2]}

<hr>


<p>5) 采用EL表达式输出数组集合 Map 内容</p>
<%
	Map map = new HashMap();
	map.put("a","map集合需要导包");
	map.put("b","WeiyiGeek");
	map.put("c.d",1024); //特殊部分
	pageContext.setAttribute("map", map);
%>

${map.a},${map.b},${map["c.d"]}

<hr>

<p>6)获取javabean之自定义对象的数据（需要采用page指令导包）</p>
<%--
Person person=new Person();
person.setName("taoshihan");
pageContext.setAttribute("person",person);
--%>
取值的方式：${person.name}

</body>
</html>