<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
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

<script>
function submit_check(){
    var pass1 = document.getElementById('password1').value;
    var pass2 = document.getElementById('password2').value;
    if ( pass1 != pass2 ){
        alert("两次输入的密码不一致!");
        return false;
    }
	if (confirm("您是否进行添加提交?") ) {
		return true;
	}else{
		return false;
	}
}
</script>
<div class="register" style="border: 1px black solid">

<form action="RegisterServlet" method="POST" onsubmit="return submit_check()">
	 <label for="username">姓名:</label>
	 <input type="text" name="username" id="username" onblur="checkUser()"/> &nbsp; <span id="msg"></span>
	 <br>
	  <label for="password">密码:</label>
	  <input type="text" name="password" id="password1"/>
	 <br>
	  <label for="password2">密码确认:</label>
	  <input type="text" id="password2"/>
	 <br>
	 <label for="gender">性别:</label>
	 <input type="radio" name="gender" value="男">男
	 <input type="radio" name="gender" value="女">女
	 <br>
	 
	 <label for="telephone">电话号码:</label>
	 <input type="tel" name="telephone" id="telephone"/>
	 <br>
	 
	 <label for="job">工作职位:</label>
	 <input type="checkbox" name="job" value="安全">安全
	 <input type="checkbox" name="job" value="运维">运维
	 <input type="checkbox" name="job" value="开发">开发
	 <input type="checkbox" name="job" value="测试">测试
	 <input type="checkbox" name="job" value="主管">主管
	 <br>
	 
     <label for="jointime">加入时间:</label>
	 <input type="date" name="jointime"/>
	 <br>
	 
     <label for="info">备注:</label>
     <textarea rows="5" cols="30" name="info" id="info"></textarea>
	 <br>
	 <input type="submit" value="注册">
	 <input type="reset" value="重置">
</form>
</div>

</body>
</html>