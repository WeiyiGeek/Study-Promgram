<?php
/**
 * php 连接数据库 并输出数据
 */
$link = new mysqli('127.0.0.1','root','123456','demo') or die("数据库连接失败");
echo "Success".$link->host_info."<br><hr>";

$sql = "insert into user value({$_GET['id']},'{$_GET['name']}',{$_GET['age']})";
echo "<br>执行SQL:".$sql;
$res = $link->query($sql);
echo  ($link->affected_rows > 0)?"<br>操作成功<hr><br>":"<br><b style='color:red'>操作失败</b><hr>";

$res = $link->query("select * from user");
echo "<table border='1' width='800' align='center'>";

//获取字段
echo "<tr>";
while($info = $res->fetch_field()){
    echo "<th>".$info->name."</th>";
}
echo "</tr>";

//获取字段内容
while($arr = $res->fetch_row()){
    echo "<tr>";
        //不建议循环，还是建议一列一列的写
        foreach($arr as $value){
            echo "<td style='color:green'>".$value."</td>";
        }
    echo "</tr>";
}
echo "</table>";
echo "字段数：".$link->field_count."个,行数：".$res->num_rows."条记录<br>";

echo "<pre>";
    var_dump($link->get_charset());
echo "</pre>";
    $link->set_charset("gbk");
    print_r($link->get_charset());
    //关闭mysql连接
    $res->close();
    $link->close();
    

?>
