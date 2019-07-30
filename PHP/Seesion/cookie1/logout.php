<?php
    /** cookie清除  */
    if(!empty($_COOKIE))
    {
        $time = time()-3600;
		setCookie("uid", "", $time, "/");
		setCookie("username", "", $time, "/");
		setCookie("allow_1", "", $time, "/");
		setCookie("allow_2", "", $time, "/");
        setCookie("isLogin", "", $time, "/"); 			//设置一个登录判断的标记isLogin
        header("Location:index.php");
	}else{
        echo "正在跳转首页";
        echo '<script>setTimeout(\'location="index.php"\', 3000);</script>';

    }
?>