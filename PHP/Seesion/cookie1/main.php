<?php
	include "public.class.php";
    echo "你好{$_COOKIE['username']}, <a href='logout.php'>退出</a>";
    if($_COOKIE['allow_1'] == 1)
    {
        echo "这是首页， 你是登录的， 你有权限可以看到这个页面！<br>";
    }else{
        die("对不起，你没有查看权限");
    }

?>
	<a href="main.php">首页</a><br>
	<a href="list.php">列表页</a><br>
	