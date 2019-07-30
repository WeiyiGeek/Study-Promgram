<?php
/** 
 *  事务处理演示 PDO
*/
try {
    $link = new PDO("mysql:host=localhost;dbname=demo","root","123456",array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
    //1.关闭自动提交
    $link->setAttribute(PDO::ATTR_AUTOCOMMIT,0);
} catch (PDOException $th) {
    echo "<p style='color:red'>数据库连接失败".$th->getMessage()."</p>";
    exit();
}

//pdo事务处理
try{
    //2.开启事务处理
    $link->beginTransaction();  //inTransaction() | PDO::inTransaction — 检查是否在一个事务内 
    $pri = 100;

    //掌门人转出100
    $affect_res = $link->exec("update demo set price=price-{$pri} where id=1");
    if($affect_res > 0 ){
        echo "<p>掌门人转出{$pri}元成功！<p>";
    }else{
        throw new PDOException("掌门人转出失败"); //抛出异常
    }
    //凡哥收到100
    $affect_res = $link->exec("update demo set price=price+{$pri} where id=3");
    if($affect_res > 0 ){
        echo "<p>凡哥收到{$pri}元成功！<p>";
    }else{
        throw new PDOException("凡哥收入失败"); //抛出异常
    }
    echo "<p>交易成功</p>";
    //3.手动提交SQL
    $link->commit();

}catch(PDOException $e){

    echo "<p>失败原因：".$e->getMessage();
    echo " <br>- 交易失败</p>";
    //4.错误回滚
    $link->rollBack();
    exit();
}
//5.事后开启自动提交
$link->setAttribute(PDO::ATTR_AUTOCOMMIT,1);

?>