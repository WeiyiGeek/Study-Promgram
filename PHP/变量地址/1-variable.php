<?php
	//variable name
	$name = "WeiyiGeek";
	$age = 28;
	echo "My name is ".$name.",my age ".$age."<br>";


	//operation  diffrent var 
	$a = 1;
	$A = 2;
	$add = $a + $A;
	echo "a + A = ".$add."<br>";

	//var type(valuwe)
	var_dump($add);
	
	//var isnot exsit
	if(isset($a)){
		echo "<p style='color:red'>var a is exsit!</p>";
	}
	
	//delete var 
	$a = $b = $c = $d = 1;
	//释放了$c变量,所有会有提示
	unset($c);
	echo $a."-".$b."-".$c."-".$d."<br>";


	//var isnot empty
	$c = "";
	var_dump(empty($c));
?>
