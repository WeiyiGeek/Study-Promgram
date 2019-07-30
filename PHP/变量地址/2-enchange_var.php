<?php
//enchange variable
	$hello =  "Hello";
	$$hello = "World";
	$$$hello = "PHP";
	$$$$hello = "Language";

	echo $hello.$$hello.$$$hello.$$$$hello."<br/>";
	echo $hello.$Hello.$World.$PHP."<br/>";

	$a= 'Weiyi';
	$$a= 'Geek';
	echo "printf < Method-1 > : $a ${$a}<br/>";
	echo "printf < Method-2 > : $a $Weiyi";
?>

