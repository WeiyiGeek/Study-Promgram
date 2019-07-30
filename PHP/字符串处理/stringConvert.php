<?php
/*
 * 去空格与指定字符 rtrim() ltrim() trim()两边的字符包括字符串里面得;
 * 填充字符串函数str_pad($str,num,str,位置);
 * 字符大小写转换 strtoupper(),strtolower(),ucfirst(一个字符串的首字母),ucwords(每个单词的首字母);
 */
	$str = "#Hello World!";
	echo "String:".$str."<br>str lenth:".strlen($str);
	echo "<br/>去除左边的 # : ".ltrim($str,"#")."变化的长度：".strlen(ltrim($str,"#"));
	echo "<br/>去除右边的 ! : ".rtrim($str,"!")."变化的长度：".strlen(rtrim($str,"!"));
	echo "<br/>去除字符串中的大写字母:".trim($str,"#A..Za..d!")."变化的长度：".strlen(trim($str,"#A..Za..d!")); //0..9,a..z都可以

	echo "<br/><hr/><br/>";
	$str1 = "php7.0";
	echo "src-length:".strlen($str1)."---".str_pad($str1,12,"#",STR_PAD_BOTH)."---".strlen(str_pad($str1,12,"#",STR_PAD_BOTH))."<br>";
	echo "src-length:".strlen($str1)."---".str_pad($str1,10,"@",STR_PAD_RIGHT)."<br>";
	echo "src-length:".strlen($str1)."---".str_pad($str1,10,"!",STR_PAD_LEFT)."<br>";

	echo "<br/><hr/><br/>";
	$str2 = "Her is my more than LOVE,I love her Every much!";
	echo "<br>原话：".$str2;
	echo "<br>大写字符串：".strtoupper($str2);
	echo "<br>小写字符串：".strtolower($str2);
	echo "<br>字符串首字母大写：".ucfirst($str2);
    echo "<br>单词大写：".ucwords($str2);
	echo "<p>组合利用</p>".ucfirst(strtolower($str2));

	//字符串取反
	echo "<br><br>原字符串 ：".$str2."<br>";
	echo "反字符串 ：".strrev($str2)."<br><br>";

	//数字字符串个数话
	$str4="12345678901";
	echo "数字字符串 ：{$str4} <br>";
	echo "数字格式化后 ：".number_format($str4)."<br>";
	echo "数字格式化后 ：".number_format($str4,2)."<br>"; //保留两位小数
	echo "数字格式化后 ：".number_format($str4,0,"","-")."<br>"; //指定分割符号




?>

