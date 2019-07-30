<?php
    //显示所有的错误除了 提示错误
   error_reporting(E_ALL & ~E_NOTICE);
    //get
    $getData = $_GET['select'];
    if(isset($getData)){
        echo "<b>这是一个get请求数据</b>";
    }

    //post
    $postData = [$_POST['name'],$_POST['url']];
    if(isset($postData)){
        echo $postData[0]."<br>\n";
        echo $postData[1];
    }
?>