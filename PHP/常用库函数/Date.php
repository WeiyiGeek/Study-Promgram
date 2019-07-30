<!DOCTYPE htm>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHP获取date</title>
</head>

<body>
<?php
echo '时间戳:'.time().'<br>';
echo '当前时区:'.date_default_timezone_get().'<br/>';
date_default_timezone_set('Asia/Shanghai');

function Te(){
	for($i=1;$i>0;$i++)
	echo '当前时间:'.date('Y年m月d日 H:i:s');
}
Te();
?>

</body>
</html>