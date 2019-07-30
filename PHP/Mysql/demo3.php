<?php
/**
 * php查询资源
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
 $link1->query("set names utf8");

 //step 4.执行语句
 //执行有结果（返回结果集资源） DQL
$res = $link1->query("select * from user limit 0,10");

// while($arr = $res->fetch_row()){
//     print_r($arr);
//     echo "<br>";
// }
print_r($res->fetch_row());     //索引 - 0 
echo "<br><hr>";
print_r($res->fetch_assoc());      //索引 - 下标名称(列表名)
echo "<br><hr>";
print_r($res->fetch_array(MYSQLI_NUM));  //相当于 row
echo "<br>";
print_r($res->fetch_array(MYSQLI_ASSOC));  //相当于 assoc
echo "<br>";
print_r($res->fetch_array(MYSQLI_BOTH));
echo "<br><hr>";
print_r($res->fetch_object());
echo "<br><hr>";
//field字段信息
while($finfo = $res->fetch_field()) {
    printf("Name:     %s\n", $finfo->name);
    printf("Table:    %s\n", $finfo->table);
    printf("max. Len: %d\n", $finfo->max_length);
    printf("Flags:    %d\n", $finfo->flags);
    printf("charsetnr: %d\n",$finfo->charsetnr);
    printf("Type:     %d\n<br>", $finfo->type);

}
echo "<br><hr>";

print_r($res->fetch_all(MYSQLI_BOTH));
 $res->close();
 //step last.关闭connect数据库连接
 $link1->close();
?>