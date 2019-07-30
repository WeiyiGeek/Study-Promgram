<?php

    //$_COOKIE 代码案例
    setcookie("name", "weiyiGeek", time()+3600, "/");      //存活时间3600s,在根路径中都有效
    setcookie("age", "20", time()+3600, "/");
    print_r($_COOKIE);
    echo "<br>";

    //$_SESSION 简单案例
    session_start();  //开启 session 才能写入
    $_SESSION['addr']="ChongQing  Nan an qu";
    print_r($_SESSION);
    echo "<br><br>";

    //$GLOBALS 简单案例 
    echo "<pre>";
    echo "globals['_COOKIE']['name'] = ".$GLOBALS['_COOKIE']['name']."<br>";
    echo "globals['_SESSION']['addr'] = ".$GLOBALS['_SESSION']['addr']."<br>";
    print_r($GLOBALS);
    echo "</pre>";
