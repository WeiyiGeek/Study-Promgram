<?php
/**
 * 用户输入验证码值验证
 * 
 */

 session_start();
if(isset($_POST['dosubmit'])){
    //让用户输入不区分大小写
    if(strtoupper($_SESSION['code']) == strtoupper($_POST['code'])){
        echo "验证码-ok";
    }else{
        echo "验证码不匹配";
    }

    if(isset($_POST['username']) && isset($_POST['password'])){
        echo "ok";
    }else{
        echo "no";
    }
}


?>