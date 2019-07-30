<?php
/** 基于URL 传递 Session ID */
    ini_set('session.use_cookies','0');  //禁用cookie
    ini_set('session.use_only_cookies','0');  //如何cookie 可以存储还是默认为1
    $sid = !empty($_GET[session_name()]) ? $_GET[session_name()] : '';
    if($sid != ''){
        //重点 将传递过来的session id，设置成为本页面的sessionid，以便获取数据
        session_id($sid);  
    }
    session_start();
    echo  session_name()." = ".session_id()."<br>";
    $_SESSION['demo'] = "demo";
    $_SESSION['lx']['name'] = "张三";
    $_SESSION['lx']['age'] = 25;
?>
<!-- 方法1 -->
<a href="urldemo.php?<?php echo session_name()."=".session_id() ?>">方法1</a>

<!-- 方法2 -自动浏览器是否支持cookie存储，否则自动采用传输 -->
<a href="urldemo.php?<?php echo SID; ?>">方法2</a>
