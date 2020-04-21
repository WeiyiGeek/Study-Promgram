<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员添加</title>
</head>
<body>

<script>
function submit_check(){
	if ( confirm("您是否进行添加提交?") ) {
		return true;
	}else{
		return false;
	}
}
</script>

<form action="addPersonServlet" method="POST" onsubmit="return submit_check()">
	 <label for="name">姓名:</label>
	 <input type="text" name="name" id="name"/>
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
     <textarea rows="1" cols="10" name="info" id="info"></textarea>
	 <br>
	 <input type="submit" value="提交">
</form>
</body>
</html>