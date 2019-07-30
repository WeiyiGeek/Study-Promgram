<?php
    include_once("conf.ini.php");
    include_once("session.php");


    $_SESSION['ceshi'] = "123456";

    echo session_id()."--";

    //session_destroy();
    echo '<a href="logout.php">退出</a>';