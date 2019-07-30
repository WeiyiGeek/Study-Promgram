<?php
/*
 *  多维数组  (数组的数组)
 *
 */
//Method 1 :
$wage = array(
	"市场部" => array(
		array(1, "高某", "市场部经理", 5000.00),
		array(2, "洛某", "职员", 3000.00),
		array(3, "峰某", "职员", 2400.00),
	),
	"产品部" => array(
		array(1, "李某", "产品部经理", 6000.00),
		array(2, "周某", "职员", 4000.00),
		array(3, "吴某", "职员", 3200.00)
	),
	"财务部" => array(
		array(1, "郑某", "财务部经理", 4500.00),
		array(2, "王某", "职员", 2000.00),
		array(3, "冯某", "职员", 1500.00)
	)
); 
print_r( $wage["市场部"] );         //访问数组$wage中的第一个元素
echo "<br/>";
print_r( $wage["市场部"][1] );       //访问数组$wage["市场部"]中的第二个元素
echo "<br/>";

print_r( $wage["市场部"][1][3] );    //访问数组$wage["市场部"][1]中的第四个元素，输出3000

echo "<br/><br/><br/>";


//	Methos 2 : 
$class = [	
	"市场部" => [
		 	["name"=>"zs", "age"=>20, "sex"=>"男", "email"=>"aaa@bbb.com"], 
			["name"=>"ls", "age"=>21, "sex"=>"女", "email"=>"bbb@bbb.com"], 
			["name"=>"ww", "age"=>22, "sex"=>"男", "email"=>"cccc@bbb.com"]
	],
	
	"产品部" => [
		 	["name"=>"zs", "age"=>20, "sex"=>"男", "email"=>"aaa@bbb.com"], 
			["name"=>"ls", "age"=>99, "sex"=>"女", "email"=>"bbb@bbb.com"], 
			["name"=>"ww", "age"=>22, "sex"=>"男", "email"=>"cccc@bbb.com"]
	],
	
	"财务部" => [
		 	["name"=>"zs", "age"=>20, "sex"=>"男", "email"=>"aaa@bbb.com"], 
			["name"=>"ls", "age"=>21, "sex"=>"女", "email"=>"bbb@bbb.com"], 
			["name"=>"ww", "age"=>22, "sex"=>"男", "email"=>"cccc@bbb.com"]
	]
];
	
	echo $class['产品部'][1]['age']."<br>".$class['产品部'][1]['email'];

	echo '<pre>';
	print_r($class);
	echo '</pre>';

