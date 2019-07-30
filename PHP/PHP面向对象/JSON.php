<?php
	$arr = array("name"=>"zhangsan", "age"=>10, "sex"=>"男");
	//串行化
	$str = json_encode($arr);
	echo $str."<br><br>";

    //第二个参数false串行化为对象
    $parr= json_decode($str, false);
    echo "<pre>";
	var_dump($parr);
    echo "</pre>";

	//返串行化, 第二个参数true返串行化为数组
    $sarr= json_decode($str, true);
    echo "<br>";
	print_r($sarr);
	
