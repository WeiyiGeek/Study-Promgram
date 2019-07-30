<?php
    //include_once("./config.ini.php");  //包含配置文件
    session_start();
    
    $logoutuser = $_SESSION['username'];// 获取退出用户名
    $_SESSION = array();    //清空数组

    //删除cookie中的session_id
    if(isset($_COOKIE[session_name()]))
    {
        setcookie(session_name(),"",time()-3600,"/");
    }
    
    //销毁所有的session资源(服务器中)
    session_destroy();

    echo "再见{$logoutuser}用户,您已经退出";
    echo "<a href='login.php'>重新登录</a>";