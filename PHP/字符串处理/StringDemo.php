<?php
$strArray = array("this","is","a","strings!");
$str = "This is a Strings";
echo "字符串格式得个数：";
count($strArray);

//查看echo与print得不同
var_dump(echo("string")); //非指令方式
var_dump(print("string"));

echo "mutil","parament","php","command<br>"; //指令模式,可以输注多个值
print("this is string\n");


//看看print与sprintf的差别 （从C语言过度过来得）
$num = 100.678;
printf("%daaaaaaaa{$num}aaaaaaaaaaaaaaaa\n", $num);
$resultStr = sprintf("%d%% -- %b -- %o -- %x --\n%c--%s \n-- %u -- %e -- %f\n",$num,15,7,15,'a',$num,10000,$num);
print($resultStr);


//$link=@mysql_connect(“”,””,””)or die(“失败”)
//die() 与 exit() 函数功能相同：
die("案例文档到此为止了");
exit("我是不显示的由于die()函数");

?>