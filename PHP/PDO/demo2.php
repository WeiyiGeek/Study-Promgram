<?php
/* 
 * PDO中执行SQL语句的方法有两个主要的:
*/
try {
	//创建对象
	$pdo = new PDO("mysql:host=localhost;dbname=demo", "root", "123456");
	//设置错误使用异常的模式
	$pdo -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}catch(PDOException $e) {
	echo "数据库连接失败：".$e->getMessage();
	exit;
}

//exec 方法
try {
    $stent = $pdo->exec('insert into user(user,age,comment) values("test123",15,"like"),("demo123",19,"iphone")');
    echo "影响得行数：".$stent;
    echo "<br>最后的插入的ID：".$pdo->lastinsertid();
} catch (PDOException $th) {
    echo $th->getMessage();
}


//query 方法
try {
    $stent = $pdo->query('select * from user');

} catch (PDOException $th) {
    echo $th->getMessage();
    exit();
}

//返回有关联数组与索引数组 （一般不建议使用-还有更好的方法）
foreach($stent as $value)
{
    echo "<p>";
    for($i = 0; $i < (count($value)/2) ;$i++)
    {
        echo $value[$i]." -- ";
    }
    echo "</p>";
}
?>