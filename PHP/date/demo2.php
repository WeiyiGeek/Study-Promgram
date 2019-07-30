<?php
/***
 *  设置时区不用+8小时
 */

 //获取当前时区
echo "当前时区：".date_default_timezone_get()."<br/>";
echo date("Y年m月d日 H小时:i分钟:s秒数",time())."<br/><br/>";

date_default_timezone_set("Asia/Shanghai");
echo date("Y年m月d日 H小时:i分钟:s秒数",time())."<br/><br/>";


//设置当前时区
date_default_timezone_set("PRC");
echo "当前时区：".date_default_timezone_get()."<br/>";
echo date("Y年m月d日 H小时:i分钟:s秒数",time())."<br><br/>";


//程序执行微妙数
$i = 1;
echo "Start : ".microtime(TRUE)."<br/>";
while($i < 10000000){
    $i++;
}

echo "Stop : ".microtime(TRUE)."<br/>";


?>