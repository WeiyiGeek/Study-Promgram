<?php
/**
 *  1)使用等号比较字符串（常见）
 * 	注意：如果不区分大小写进行比较就采用strtolower()或者strtoupper()转换成大小写;
 * 
 * 	2)字符比较
 * 	strcmnp
 */
	$str1= "Apple";
	$str2 = "apple";
	//常规（不区分大写）
	if(strtolower($str1) == strtolower($str2))
	{	
		echo "0x00#字符串相同 V <br>";
	}else{
		echo "0x00#字符串不相同 X <br>";
	}

    //区分大小写
    $bool = strcmp($str1,$str2);
	if($bool == 0){	
		echo "0x01#字符串相同 V <br>";
	}else{
		echo "0x01#字符串不相同 X <br>";
	}

    //不区分大小写
    $bool = strcasecmp($str1,$str2);
	if($bool == 0){	
		echo "0x02#字符串相同 V <br>";
	}else{
		echo "0x02#字符串不相同 X <br>";
	}

	$stra = array("file1.txt","file2.txt");
	switch(strcasecmp($stra[0],$stra[1])) {
		case 1:
			echo "第一个字符串 大于 第二个字符串<br>";
			break;
		case -1:
			echo "第一个字符串 小于 第二个字符串<br>";
			break;
		case 0:
			echo "两个字符串相等<br>";
			break;
	
	}

    echo "<br><hr><br>";
	//自然排序(区分大小写)
	$arr=array("file1.txt", "File2.txt", "File11.txt", "file12.txt");
	usort($arr, "strnatcmp");
    print_r($arr);
    
    echo "<br><hr><br>";

	//自然排序(不区分大小写)
	$arr=array("file1.txt", "File2.txt", "File11.txt", "file12.txt");
	usort($arr, "strnatcasecmp");
	print_r($arr);
	
