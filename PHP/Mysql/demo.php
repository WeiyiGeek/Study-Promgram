<?php
/**
 * php连接数据库资源演示
 * 
 */
error_reporting(E_ALL & ~E_WARNING);

 //step 0.基础信息
 $host = "localhost";
 $mysqluser = "root";
 $mysqlpass = "123456";
 $db = "demo";
 //step 1.连接数据库（返回资源）
 //方法1：面向对象
 $link1 = new mysqli($host,$mysqluser,$mysqlpass,$db);  //正确返回资源 / 错误返回boolean
 if($link1->connect_error){
    die('Connect ErrOr['.$link1->connect_errno.']：'.$link1->connect_error);
 }
 else
 {
    echo 'Success... ' . $link1->host_info . "<br>";
 }   
 echo $link1->server_info."<br>";
 echo $link1->client_info."<br><hr>";
 $link1->close();


 //方法2 ： 面向过程
$link = mysqli_connect('127.0.0.1',$mysqluser,$mysqlpass, $db);
if(!$link){
    die('Connect Error (' . mysqli_connect_errno() . ') '. mysqli_connect_error());
}
echo 'Success... ' . mysqli_get_host_info($link) . "<br>";
echo "Server version:".mysqli_get_server_info($link)."<br>";
printf("\nClient library version: %s\n", mysqli_get_client_info());
mysqli_close($link);


 //step 2.设置连接后的字符集等
 //实验：
 //mysqli_query("set names utf8");
 //mysqli_select_db("demo");


 //step 3.选择一个数据库作为默认的数据库使用

 //step 4.执行语句

 //step last.关闭connect数据库连接

?>