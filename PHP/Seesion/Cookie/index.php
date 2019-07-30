<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<?php
/** 显示 存入 cook的页面*/
if(empty($_COOKIE['user']))
{
    echo '登录:<input type="button" value="登录" onclick="location.href=\'login.php\'"/>';
    die("用户未登录");
}else{
    //为了安全需要进行转义
    echo "欢迎您". htmlspecialchars($_COOKIE['user'])."用户 , 密码为". htmlspecialchars($_COOKIE['pass'])."<br>";
    //遍历info数组
    foreach ($_COOKIE['info'] as $key => $value) {
       echo htmlspecialchars($key)."=".htmlspecialchars($value)." <br>";
    }
    //索引数组
    echo  "{$_COOKIE['arr'][0]}  -- {$_COOKIE['arr'][1]} <br>";
}

echo '注销用户:<input type="button" value="退出"  onclick="location.href=\'logout.php\'"/>';

?>
</body>
</html>
