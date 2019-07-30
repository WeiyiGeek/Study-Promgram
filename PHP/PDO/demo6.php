<?php
/** PDO 预处理语句 -> 查询语句 防止SQL注入 */
 //1.数据库连接
try{
    $link = new PDO('mysql:host=localhost;dbname=demo','root','123456',array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
}catch(PDOException $e){
    echo "<br>:连接失败，失败原因：<br>".$e->getMessage();
    exit;
}

try{
    //2.查询语句
    $sql = " select id,username,price from demo where price >= ?";
    $stmt = $link->prepare($sql);
    $stmt -> execute(array(1000));

    //3.遍历语句 
    echo "<p>影响行数：".$stmt->rowCount()."</p>";  
    //echo "<p>影响行数：".$stmt->lastInsertId();  //如何获取最后一个自动增涨的ID呢?
    echo "<table width='800px' border='1' style='border:2px solid red'>";
    echo "<tr><th>ID</th><th>USERNAME</th><th>PRICE</th><tr>";
		
    //方法1 : 直接使用循环来
    foreach($stmt as $row){
       echo "<tr><td>$row[id]</td><td>$row[username]</td><td>$row[price]</td></tr>";
    }
    echo "</table>";


    //方法2 : 返回所有数据库里面的一个二维数组
    $stmt = $link->prepare($sql);
    $stmt -> execute(array(1000));
    //设置返回数据为索引还是下标
    $stmt->setFetchMode(PDO::FETCH_NUM);    //下标 $stmt->setFetchMode(PDO::FETCH_ASSOC);  //索引
    print_r($stmt->fetchAll());
    echo "<br>";


    //方法3 : 返回一行数据
    $stmt = $link->prepare($sql);
    $stmt -> execute(array(1000));
    while(list($id,$name,$price) = $stmt->fetch())
    {
        echo "<br>$id - $name - $price";
    }
    echo "<br>";


    //方法4 ：通过列号来绑定
    $stmt = $link->prepare($sql);
    $stmt -> execute(array(1000));
    /*  通过列号绑定  - 建议使用同一的 */
    $stmt->bindColumn(1, $binname);
    $stmt->bindColumn(2, $binprice);
    /*  通过列名绑定  $stmt->bindColumn('calories', $cals);  */
    //可以设置结果的模式, 以下的代码使用fetch()或fetchAll()都是使用这个方面设置的数组的格式
    $stmt -> setFetchMode(PDO::FETCH_NUM);
    while($stmt->fetch())
    {
        echo "<br> $binname -- $binprice |";
    }

}catch(PDOException $e){
    echo "<br>错误信息{$e->getMessage()}<br>";
}