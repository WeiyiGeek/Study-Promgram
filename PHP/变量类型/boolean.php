<?php
// boolean false (为假的情况)
// int 0
// float 0.0 0.00
// string "" "0" (注意非常特殊,字符串只有一个0的时候才是假)
	$bool1 = true;
	$bool2 = false;
	var_dump($bool1);
	var_dumP($bool2);
	echo "<br/><br/>";
	if($bool2)
	{
		echo "<b style='color:green'>bool2 TRUE VALUE</b><br/><br/>";
	}else{
		echo "<b style='color:red'>bool2 FALSE VALUE</b><br/><br/>";
	}


// array 空数组 - 为假
	$arr = array();
	if($arr)
	{
		echo "<b style='color:green'>arr TRUE VALUE</b><br/><br/>";
	}else{
		echo "<b style='color:red'>arr FALSE VALUE</b><br/><br/>";
	}


#// object (特殊-这是为真)
	class Test{
	}
	$obj = new Test; 
	if($obj)
	{
		echo "<b style='color:green'>obj TRUE VALUE</b><br/><br/>";
	}else{
		echo "<b style='color:red'>obj FALSE VALUE</b><br/><br/>";
	}


#//rescurces (特殊-这是为真)
	$link = mysql_connect("localhost","root","");
	if($link)
	{
		echo "<b style='color:green'>link TRUE VALUE</b><br/><br/>";
	}else{
		echo "<b style='color:red'>link FALSE VALUE</b><br/><br/>";
	}

// null
	$nul = null;
	if($nul)
	{
		echo "<b style='color:green'>nul TRUE VALUE</b><br/><br/>";
	}else{
		echo "<b style='color:red'>nul FALSE VALUE</b><br/><br/>";
	}

?>
