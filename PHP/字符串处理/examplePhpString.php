<?php
$str = "I love study php pragram language";

echo "<b>1) $str </b><br> String length :".strlen($str)."<br>";

echo "<br>2) 字符类型与数组的关系:<br>";
echo "使用数组[]形式获取第一/三个字符 <b style='color:red'>".$str[0]."-".$str[2]."</b><br>";
echo "字符串建议使用{}形式第一/三个字符  <b style='color:red'>".$str{0}."-".$str{2}."</b><br>";
echo "同样我们也能修改字符的值：";
$str{0} = "You"; //只会提取收字母
echo "$str<br><br>";

echo "3) 字符串类型非数组类型：";
var_dump($str[10]);

echo "<br><br>4) 中文字符集的不同占用的长度也不相同：";
$chinese = "中国重庆";
echo "<br>$chinese String length :".strlen($chinese);

echo "<br><br>5) 复习 <<< 定界符的实验：<br/>";
$str =<<<test
    this\tis\ta\tstring!\n;
    只能小写定界符;<br><br>
test;
echo "$str";

//声明一个关联数组，数组名为$lamp, 成员有4个
$lamp = array( 'os'=>'Linux', 'webserver' =>'Apache', 'db'=>'MySQL', 'language'=>'php' );
define("two","webserver");

echo "6)采用字符串解析数组与对象：<br>";
echo "The First Value: $lamp[os] <br>";          //但是注意：不要在［］中使用引号，否则会在引号处结束 除非使用花括弧
echo "The Second Value: {$lamp[two]} <br>";       
echo "The Second Value: {$lamp['language']} <br>";    //建议使用的方式
echo "My Databases is {$lamp['db']} <br>";       //如果在对关联数组下标使用引号就必须使用花括号，否则将出错
  
class num {
    var $one = "100";
};

$num_obj = new num();
echo "object string demo : $num_obj->one <br>";
echo "object string demo : {$num_obj->one}";

echo count($lamp);
?>