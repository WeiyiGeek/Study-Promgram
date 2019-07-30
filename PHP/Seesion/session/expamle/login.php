<?php

    //处理登录
    if(isset($_POST['dosub']) && !empty($_POST['username']) && !empty($_POST['password']))
    {
        include_once("./config.ini.php");  //包含配置文件
        //到数据库查询是否正常
        $stmt = $link->prepare("select id,username,allow_1,allow_2 from user where username = ? and password= ?");
        $stmt->execute(array($_POST['username'],md5($_POST['password'])));

        //判断是否账号密码正常
        if($stmt->rowCount() > 0)
        {
            //将用户信息放入Session中
            $_SESSION=$stmt->fetch(PDO::FETCH_ASSOC);
            //登录标记
            $_SESSION['isLogin'] = 1;
            header("Location:main.php");
            //print_r($_SESSION);
            //echo session_id();
        }else{
            echo "<p style='color:red'>账号或者密码错误！<p>";
        }
    }


?>
<form action="login.php" method="post">
        <label for="user">用户名：</label><input type="text" name="username" id="user"/><br>
        <label for="pass">密&nbsp;&nbsp;&nbsp;码：</label><input type="password" name="password" id="pass"/><br>
        <input type="submit" value="登录" name="dosub">
        <input type="button" value="清除" onclick="document.getElementById('user').value='';document.getElementById('pass').value='';">
</form>
