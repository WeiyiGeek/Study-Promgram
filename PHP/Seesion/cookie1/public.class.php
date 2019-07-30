<?php
   header("Content-Type:text/html;charset=utf-8");
	//判断是否是登录的，如果是登录的我们才可以通过 $_COOKIE['isLogin']=1
	if(!(isset($_COOKIE['isLogin']) && $_COOKIE['isLogin']==1)) {
		echo "用户你还没有登录呢？请选登录";
        echo '<script>setTimeout(\'location="index.php"\', 3000);</script>';
        //header("Location:login.php");  //跳转
        die("请登录");
	}

?>