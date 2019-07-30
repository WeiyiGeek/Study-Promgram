<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>php表单提交</title>
</head>
<body>
<?php
if($_POST['a']&&$_POST['b']){
	echo $_POST['a']+$_POST['b'];
}else{
	echo "请输入参数";
}
?>
</body>
</html>