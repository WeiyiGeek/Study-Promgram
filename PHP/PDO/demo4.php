<?php
/** 
 *  PDO演示预处理
*/
try {
    $link = new PDO("mysql:host=localhost;dbname=demo","root","123456",array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
} catch (PDOException $th) {
    echo "<p style='color:red'>数据库连接失败".$th->getMessage()."</p>";
    exit();
}

$sql = "delete from user where id='{$_GET['id']}'";  //容易导致SQL注入
try{
    $red = $link->exec($sql);
}catch(PDOException $e){
    echo $e->getMessage();
}
echo $red;
echo $sql;
