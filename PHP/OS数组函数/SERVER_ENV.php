<?php
    /** $_SERVER 超全局数组打印**/
    //echo '<pre>';
    //print_r($_SERVER);
    //echo '</pre><br>Totle : '.count($_SERVER);

    echo "User_Agent : ".$_SERVER['HTTP_USER_AGENT']."<br>";
    echo "Current IP : ".$_SERVER['REMOTE_ADDR']."<br>";
    //三种方式获取上网者IP（不能只采用一种）
    function getip() {
		if(!empty($_SERVER['HTTP_CLIENT_IP'])) { //请求客户端IP
			return $_SERVER['HTTP_CLIENT_IP'];
		} else if(!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) { //代理IP
			return $_SERVER['HTTP_X_FORWARDED_FOR'];
		} else if(!empty($_SERVER['REMOTE_ADDR'])) { //远程路由节点地址
			return $_SERVER['REMOTE_ADDR'];
		}else{
			return '未知IP';
		}
	}
    echo "Precise IP : ".getip();
    $ip = getenv('REMOTE_ADDR');
    echo $ip;

    //$_ENV 使用案例 需要在php.ini 开启variable_order:"EGPCS"
    echo '<pre>';
    print_r($_ENV);
    echo '</pre><br>Totle : '.count($_ENV)."<br/>";

    echo'Computer Name : '.getenv('USERDOMAIN')."<br>";
    echo'OS Archite : '.getenv('PROCESSOR_ARCHITEW6432')."<br>";
    echo'CPU Infromation : '.getenv('PROCESSOR_IDENTIFIER')."<br>";


