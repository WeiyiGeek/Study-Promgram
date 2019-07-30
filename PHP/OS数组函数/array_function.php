<?php
	//关于键值対的函数
	$lamp = array("os"=>"Linux", "webserver"=>"Apache" , "db"=>"MySQL", "language"=>"PHP");
	print_r($lamp);  //输出数组
	echo '<br>';

	//array_values();案例
	list($os, $webserver, $db, $language) =  array_values($lamp);  //注意list()只能解析连续的索引数组
	echo $os."<br>";
	echo $webserver."<br>";
	echo $db."<br>";
	echo $language."<br>";

	//array_keys();案例
	$lampk = ["os"=>"Linux", "webserver"=>"Apache", "ws"=>"Apache", "num"=>10, "aa"=>"10", "db"=>"MySQL", "language"=>"PHP"];
	echo "<pre>";
	print_r(array_keys($lampk));	 //全部返回所有键名,并放入索引数组中;
	echo "</pre>";

	print_r(array_keys($lampk, "Apache", false));  //匹配相同的值,返回其key
	echo "<br/>";
	print_r(array_keys($lampk, 10, true)); 	      //精准匹配 - 数值为10的
	
	//in_array();案例
	$lampi = array("os"=>"Linux", "language"=>"PHP", "num"=>"10", "NUM"=>10, array("a", "b"),"dbfirst"=>1,"test"=>NULL);
	if(in_array(10, $lampi, true)){  				//精准类型匹配如果是“10”是不能匹配上的
		echo "<br/>数值 10 在 lampi 数组中<br/>";
	}else{
		echo "<br/>数值 10 不在 lampi 数组中<br/>";
	}
	if(in_array(array("b","a"), $lampi, true)){  		//还能判断数组是不是在数组之中 (新版本都支持)	
		echo "数组在 lampi 数组中<br/>";
	}else{
		echo "数组不在 lampi 数组中<br/>";
	}

	//array_search();案例
	echo "<br/>key - > ".array_search("10",$lampi,true)."<br>";  //返回 key 键名

	//array_key_exists();案例  与 isset() 差异
	if(array_key_exists("test",$lampi)){
		echo "<br>键值存在数组中<br>";
	}else{
		echo "<br>键值不存在数组中<br>";
	}
	if(isset($lampi['test'])){   // (isset() 对于数组中为 NULL 的值不会返回 TRUE，而 array_key_exists() 会。)
		echo "键值存在数组中<br>";
	}else{
		echo "键值不存在数组中<br>";

	}

	//array_filp(); 案例 只能处理整数与字符串
	$arr = ["Name"=>"Weiyi", "Job"=>"Geek", "WEB"=>"Apache","one"=>"TWO","two"=>"TWO"];
	$changearr = array_flip($arr);
	echo "<pre>";
	print_r($changearr); //但是会有一个弊端那就是 “value是可以重复的” 但是key是不能重复的,后面会覆盖前面的值;
	echo "</pre>";


	//array_reverse(); 案例 取反
	$arr1 = ["one"=>"www","two"=>"baidu","there"=>"com"];
	echo "<pre>";
	print_r(array_reverse($arr1));
	echo "</pre>";