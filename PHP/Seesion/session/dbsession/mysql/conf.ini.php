<?php
    try{
        $link = new PDO('mysql:host=localhost;dbname=demo','root','123456',array(PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION));
    }catch(PDOException $e){
        echo "数据库错误：$e->getMessage()";
        exit;
    }
?>