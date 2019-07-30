<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JSON格式数据的操作</title>
</head>

<body>

<?php
//Json format
//[1,2,3,8,"Hello",[6,8,9],{"H":"Hello"}]
//{"h":"Hello","W":"World"}  Key / Value
$arr = array(1,2,5,8,'Hello','Jikexueyuan',array('h'=>'Hello','E'=>'Eita'));
//print_r($arr[4]);  //打印输出数组
echo json_encode($arr).'<br>';  //进行Json encode
$jsonStr = '{"h":"Hello","E":"Eita","0":[1,2,5,8,"Hello","Jikexueyuan"]}';
$obj = json_decode($jsonStr);   //进行Json decode
print_r($obj);
//echo '<br>';
echo $obj->h;
?>
</body>
</html>tml>