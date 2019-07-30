<?php
error_reporting(E_ALL & ~E_NOTICE & ~E_WARNING);
/** 不同系统中的目录的处理的方法 */
//1.路径分隔符号“/”常量
echo "Directory_sepapator()常量:<br/>";
echo "C:".DIRECTORY_SEPARATOR."etc".DIRECTORY_SEPARATOR."ssh".DIRECTORY_SEPARATOR."config"."<br>";
echo "AAA".PATH_SEPARATOR."bbb".PATH_SEPARATOR."ccc"."<br>";

//2.建议使用的换行符合(右键源代码)
echo "通用换行符号";
echo PHP_EOL."aaaaaaaaaaaaaaa".PHP_EOL;
echo "BBBBBBBBBBBBBBB".PHP_EOL."<br>";

//3.注意绝对路径与相对路径
echo "<img src='./img.jpg' width='50px' height='100px' alt='网站服务器跟目录'>";
mkdir("/phpmkdir");                 //建立文件夹 - 操作系统根目录(及安装web应用程序磁盘根)
echo "<br>";

//4.PHP文件路径相关函数
$path = "c:\\php\\test\\demo.php";
echo basename($path)."   |    ";
echo basename($path,".php")."<br>";
echo dirname($path);
echo "<pre>";
print_r(pathinfo($path));
echo "</pre>";

echo "规范化路径：";
echo realpath($path)."<br>";
echo realpath('./../../etc/passwd');  ///etc/passwd

?>