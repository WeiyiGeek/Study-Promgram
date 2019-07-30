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
 } else{
    echo 'Success... ' . $link1->host_info . "<br>";
 }


 //step 2.设置连接后的字符集等
 //实验时候采用：
 $link1->query("set names utf8");
 //mysqli_query("set names utf8");


 //step 3.选择一个其他数据库作为默认的数据库使用
 $link1->select_db("demo");  //可以选择数据库
 //mysqli_select_db("demo");


 //step 4.执行语句
 //操作数据库SQL语句执行 DML DCL DQL DDL 管理、控制、查询、定义
 //语句分为两种：1.执行无结果（返回Boolean） 2.执行有结果（返回结果集资源）

 //无结果集的语句：DML DCL DDL 
 $sql1 = "create table bro_users(id int)";
 $sql2 = "insert into bro_users values(1)";
 $sql3 = "show tables";
 $sql4 = "insert into user values({$_GET['id']},'张三',52)";
    //$res = $link1->query($sql1);
    //$res = $link1->query($sql2);
 echo "执行SQL:".$sql4;
 $res = $link1->query($sql4)."<br>";

 if($link1->affected_rows > 0){
    echo "操作成功";
 }else{
     echo "操作失败:".$link1->connect_error;
 }

 echo "当前索引值：".$link1->insert_id;
 //step last.关闭connect数据库连接
 $link1->close();

?>