<?php
/**对多个数组进行排序**/
//array_multisort(); 第一个数组影响第二个数组排序
$a = ["a","10",20,"b"];
$b = [1,2,4,3];

//array_multisort($a,$b); //第二个数组根据第一个数组变化而变化
// a ->  "10" "a" "b" 20  //一一对应排序 (默认升序)
// b ->   2    1   3  4

//采用 DESC 降序  / ASC 升序
// a -> 20  "b" "a" "10"        //一一对应排序
// b ->  4   3    1    2
array_multisort($a,SORT_DESC,$b);  //降序 
print_r($a);
    echo "<br>";
print_r($b);


echo "<pre>模拟表结构排序：<br>";
echo "</pre>";
//模拟表结构排序
$date = array(
    array("id"=>1,"name"=>"aa","age"=>10),
    array("id"=>2,"name"=>"dd","age"=>19),
    array("id"=>3,"name"=>"cc","age"=>15),
    array("id"=>4,"name"=>"bb","age"=>15),
    array("id"=>4,"name"=>"bb","age"=>18),

);

$ages = array(); //先按年龄排序
$names = array(); //再按名字排序
foreach($date as $value){
    $ages[] = $value['age'];
    $names[] = $value['name'];
}

array_multisort($ages,$names,$date);  //先按年龄排序 再按照名字排列 受到影响的是$date
//array_multisort($ages,SORT_DESC,$names,$date);  //先按年龄排序（倒叙） 再按照名字排列 
print_r($date[0]);    echo "<br>";
print_r($date[1]);    echo "<br>";
print_r($date[2]);    echo "<br>";
print_r($date[3]);    echo "<br>";
print_r($date[4]);
