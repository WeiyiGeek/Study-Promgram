<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>异步查询用户名称是否存在</title>
<!-- Jquery 引入外部 JS -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<script>
	//## (1)原生JS实现Ajax异步请求
	function checkUser(){
	    //1.创建ajax请求对象
	    var request = window.XMLHttpRequest ? new XMLHttpRequest():new ActiveXObject("msxml2.XMLHTTP") ? new ActiveXObject("msxml2.XMLHTTP"):new ActiveXObject("Microsoft.XMLHTTP"); 
	    
	    //2.获取输入的用户名
		var user = document.getElementById("username").value;
	    
		//3.ajax请求
		request.open("POST","CheckUserServlet",true);
		request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		request.onreadystatechange = function(){
			if(request.readyState == 4 && request.status == 200){
			    var jsondata=eval("("+request.responseText+")");
				if(!jsondata.status){
					document.getElementById("msg").innerHTML = "<font color='red'>用户名已存在!</font>";
				}else{
					document.getElementById("msg").innerHTML = "<font color='green'>用户名可用!</font>";
				}
			}
		}
		request.send("checkuser="+user);
	}
	
	//## (2)JQuery实现Ajax异步请求(文档加载完毕时候进行)
	$("document").ready(function(){
	   $("#name").blur(function(){
	      var user = $(this).val();
	      console.log(user);
	      $.post("CheckUserServlet",{checkuser:user},function(data,status){
	          if (status == "success"){
	              //Jquery 直接解析 json 
		      		if(data.status){
					  $("#msg1").html("<font color='green'>姓名可用!</font>");
		      		}else{
		      		  $("#msg1").html("<font color='red'>姓名已存在!</font>");
		      		}
	          }
	      });
	   });
	});
	
</script>
<div align="center">
<form action="RegisterServlet">
	<label for="username">用户名:</label>
	<input type="text" name="username" id="username" onblur="checkUser()"/> &nbsp; <span id="msg"></span><br>
	<label for="name">真实姓名:</label>
	<input type="text" name="username" id="name"/> &nbsp; <span id="msg1"></span> <br>
	<input type="submit" value="注册"/>
</form>
</div>
<br>
</body>
</html>