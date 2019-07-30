<?php
	//each()函数 代码案例
    $arr = ["Name"=>"Weiyi", "Job"=>"Geek", 23, "ChongQing"];
    
    echo "<pre>";
    $demo = each($arr);  //'Name' 关联
    echo "Key : ".$demo[0]."    Value :".$demo[1]."<br><br>";
    $demo = each($arr);  //'Job' 关联
    echo "Key : ".$demo['key']."    Value :".$demo['value']."<br><br>";
    
    print_r(each($arr));  // 索引：1
	print_r(each($arr));  // 索引：2
	var_dump(each($arr));  //当数组指针在文件末尾的时候 返回一个 boolean类型 为fasle
    echo "</pre>";


    //each 与 while 的案例
$arr = ["Name"=>"Weiyi", "Job"=>"Geek", 23, "ChongQing"];
while($temp = each($arr)){
    echo "{$temp[0]} ==>> {$temp[1]}<br>";
}
reset($arr);  //重新让数组指针指向数组的第一个元素,从而让下面的while能正常的执行里面的语句
while($temp = each($arr)){
    echo "{$temp[0]} ==>> {$temp[1]}<br>";
}