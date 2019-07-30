<?php
/*** 接受传递的页面 */
    //将其他页面的phpsesssion id 传递到该页面进行接收
    ini_set('session.use_cookies','0');
    ini_set('session.use_only_cookies','0');  //如何cookie 可以存储还是默认为1
    $sid = !empty($_GET[session_name()]) ? $_GET[session_name()] : '';
    //判断id是否为空为空就生成
    if($sid != ''){
        //重点 将传递过来的session id，设置成为本页面的sessionid，以便获取数据
        session_id($sid);  
    }else{
        header("Location:demo3.php");
    }
    //开启会话
    session_start();

    echo "Session_ID : ".session_id()."<br><pre>";
    print_r($_SESSION);
    echo "</pre>";

?>
<!-- 方法1 -->
<a href="demo3.php?<?php echo session_name()."=".session_id() ?>">方法1-首页</a>
<!-- 方法2 -自动浏览器是否支持cookie存储，否则自动采用传输 -->
<a href="demo3.php?<?php echo SID; ?>">方法2-首页</a>
