<?php
/** session 回收机制 */
//浏览器关闭失效，回收时间60秒，10个因素
session_start(array([
    'gc_maxlifetime' => 10,
    'gc_divisor' => 10,
    'save_path'=> "D:/xampp/tmp",
    'read_and_close' => true,
    ]));

echo session_name()." - ".session_id();
//设置seesion
$_SESSION['user'] = "admin"; 

//获取session
echo "<br>".$_SESSION['user']."用户";

//session_destroy();
?>