<?php
/**
 * 采用PDO方法连接数据库与PDO常见属性的设置
 * 
 *   setAttribute();  getAttribute();
 * 
 *   PDO::ATTR_ERRMODE
 *  1. 默认的错误模式（不提示, 我们看到到问题. 被忽视!）
 *  2. 警告模式 PDO::ERRMODE_WARNING
 *  3. 异常的模式 PDO::ERRMODE_EXCEPTION
 **/
$DSN = 'mysql:host=127.0.0.1;dbname=demo;charset=utf8';
$dbname = 'root';
$dbpss = '123456';
//1.pdo连接
try{
     //连接的时候设置属性 Persistent 常连接设置
     $link = new PDO($DSN,$dbname,$dbpss,array(PDO::ATTR_AUTOCOMMIT=>1,PDO::ATTR_PERSISTENT=>true));
     //错误模式设置
     //$link->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
     $link->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}catch(PDDException $e){
     echo "数据库连接错误：".$e->getMessage();
     exit();
}
echo "<p>连接成功</p>";

//2.pdo属性
for($i = 3; $i < 9;$i++)
{
     echo "integer {$i} : ".$link->getAttribute($i)."<br>";
}
echo "<hr>";
echo "<br>PDO是否关闭自动提交功能：". $link->getAttribute(PDO::ATTR_AUTOCOMMIT); //是否自动提交
echo "<br>当前PDO的错误处理的模式：". $link->getAttribute(PDO::ATTR_ERRMODE); 
echo "<br>表字段字符的大小写转换： ". $link->getAttribute(PDO::ATTR_CASE); 
echo "<br>与连接状态相关特有信息： ". $link->getAttribute(PDO::ATTR_CONNECTION_STATUS); 
echo "<br>空字符串转换为SQL的null：". $link->getAttribute(PDO::ATTR_ORACLE_NULLS); 
echo "<br>应用程序提前获取数据大小(持续连接)：".$link->getAttribute(PDO::ATTR_PERSISTENT); //常连接
echo "<br>与数据库特有的服务器信息：".$link->getAttribute(PDO::ATTR_SERVER_INFO); 
echo "<br>数据库服务器版本号信息：". $link->getAttribute(PDO::ATTR_SERVER_VERSION);
echo "<br>数据库客户端版本号信息：". $link->getAttribute(PDO::ATTR_CLIENT_VERSION); //常量：PDO::ATTR_CLIENT_VERSION = 5 - 返回 PDO 驱动所用客户端库的版本信息。

//我们操作一个不存在的表
$affect = @$link->exec("delete from user");  //返回TRUE/FALSE
var_dump($affect);
if(!$affect){
    echo "<pre>执行失败错误值:".$link->errorCode()." 原因：";
    print_r($link->errorInfo());
}

//采用抛出异常的方法
try {
     $affect = $link->exec("select * from user1");
} catch (PDOException $event) {
     //throw $th;
     echo $event->getMessage();
}