<?php
/** 配置文件 */
//常量声明
session_start();
const DSN = "mysql:host=localhost;dbname=demo";
const USER = "root";
const PASS = "123456";

//数据库连接
try {
    $link = new PDO(DSN,USER,PASS,array(PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION));
} catch (PDOException $th) {
    echo "连接失败：".$th->getMessage()."<br>";
    exit;
}
?>



