<?php
	// integer Example And Float Example
	/*
	h e l l o
	104 = 64 + 32 + 8
	0 0000000 00000000 00000000 01101000

	*/

	// int
	$dec = 1024;
	$oct = 077;
	$hex = 0xff;
	echo "$dec - $oct - $hex <br>";

	// PHP 不支持无符号整数 （造过范围会自动改变类型）
	$var = 2147483647;
	var_dump($var);
	$var = 2147483647+1;
	var_dump($var);
	
	echo "<br><br>";

	// float double
	$f1 = 3000000000000000000;
	$f2 = 0.00000000000000003;
	$f3 = 6E+5;          //6E5 这样也是OK的
	$f4 = 1E-5;
	var_dump($f1);
	echo "<br><br>";

	var_dump($f2);	
	echo "<br><br>";
	echo "$f3 <br/>$f4<br>";
?>
<script>
	var a = 0;
	for(var i=0; i<10; i++) {
		a+=0.1;
	}
	alert(a);
</script>