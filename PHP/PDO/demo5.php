<?php
/** PDO 预处理语句 防止SQL注入 */

 //1.数据库连接
try{
    $link = new PDO('mysql:host=localhost;dbname=demo','root','123456',array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
}catch(PDOException $e){
    echo "<br>:连接失败，失败原因：<br>".$e->getMessage();
    exit;
}
echo "<p>ok</p>";
//2.语句准备
try {
    /*** 方法一 ***/
    //索引数组  -- prepare 方法,采用？进行预处理语句
    $stmt = $link->prepare("insert into demo(username,price) values(?,?)");
    //bindValue 方法，绑定占位符的标识 (将问号和一个变量关联起来)
    $stmt->bindParam(1,$username);
    $stmt->bindParam(2,$price);
    //给变量一个值， 就会给准好的语句中的对应?一个值
    $username = "1.李连杰";
    $price = 2000;
    //执行预处理语句（有几个执行几次）
    $stmt->execute();
    //赋值
    $username = "2.李连杰";
    $price = 2000;
    //执行预处理语句（有几个执行几次）
    $stmt->execute();
    //也可以这样
    $stmt->execute(array("3.测试",4000));  //可以直接采用数组的形式（方便）


    /*** 方法二  ***/
    //采用名字参数
    $stmt = $link->prepare("insert into demo(username,price) values(:name,:price)");
    //绑定参数 与 类型(PDO::预处理常量)
    $stmt -> bindParam("name",$name,PDO::PARAM_STR);
    $stmt -> bindParam("price",$price,PDO::PARAM_INT);
    //赋值参数
    $name = "WhatWeb";
    $price = "1920805";
    //执行预处理语句
    $stmt->execute();
    //关联数组的使用
    $stmt->execute(array("name"=>"whatwww","price"=>1955));
    //也能GET/POST方法直接执行（常用）
    $stmt->execute($_GET);
    
} catch (PDOException $th) {
    echo "<br>连接失败，失败原因：<br>".$th->getMessage();
    exit;
}
    echo "完成执行";
?>