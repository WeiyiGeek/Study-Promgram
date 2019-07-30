<?php
	/*
	 * PHP 字符串 
	 *  1. 声明一个字符串必须使用单引号 或 双引号引起来
	 *  2. 字符串是没有长度限制 "" " " "无限长"
	 *  3. 在单引号中可使用双引号， 在双引号中也可以使用单引号
	 *  4. 在单引号中不能再使用单引号， 在双引号不能再使用双引号
	 *
	 */
	 /*
	//单双引号的都是代表字符串
	$str = 'a';  //单引号的字符
	var_dump($str);
	ECHO "<BR/>";	
	$str = "this is a 'demo'"; //双引号引起来只服从
	var_dump($str);
	ECHO "<BR/>";

	//单双引号的嵌套使用
	$str0 = 'this is a "double"';
	$str1 = "this is a 'dog'";
	echo $str0."<br/>".$str1."<br/><br/>";
	
	//区分单双引号对变量的不同的处理
	$love = 520;
	$life = 1314;
	$str2 = 'I $love you a $life';
	$str3 = "I $love you a $life";
	echo $str2."<br/>".$str3."<br/><br/>";

	
	//单双引号对转义字符“\”初识
	echo '<b style="color:red">this is a \"simple\" string</b><br/>';	     		//输出：this is a \"simple\" string
    echo '<b style="color:red">this \n is \r a \t simple string\\ </b><br/></br>';      //输出：this \n is \r a \t simple string\
	
	echo "<b style='color:blue'>this is a \'simple\'string </b><br/>";	      							//输出：this is a \'simple\' string
    echo "<b style='color:blue'>this \n is \r a \t simple string</b>";         //输出的时候隐藏转义字符
	
	*/

/*花括号来引用包含变量 */
$beer='WeiyiGeek';
echo "$beer's taste is great<br/>";    //输出：Heineken's taste is great
echo "He drank some $beers<br/>";      //输出：He drank some 
echo "He drank some ${beer}s<br/>";    //输出：He drank some Heinekens
echo "He drank some {$beer}s<br/><br/><br/>";    //输出：He drank some Heinekens
   
/*定界符标识符 有双引号的功能*/
$str =<<<hello
	This\'s a demo with ${beer}\n;
	this is a\tEnter Key \n\r ok;<br/><br/>
hello;
//坑啊一定要顶行写
echo $str;

/*定界符标识符 有单引号的功能*/
$str =<<<'ch'
	this \" a demo with ${beer}\n;
	this is \n a \t some \r personl
ch;
echo $str;


  