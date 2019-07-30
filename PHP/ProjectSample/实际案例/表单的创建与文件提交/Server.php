<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>php表单提交</title>
</head>
<body>
<?php
if(isset($_GET['name'])){
	echo "用户名:".$_GET['name'];
}else{
	echo "请输入帐号:<br>";
}
if (isset($_GET['password'])){
	echo "<br>密码:".$_GET['password'];
}else{
	echo "<br>请输入密码:";
}
?>
</body>
</html>