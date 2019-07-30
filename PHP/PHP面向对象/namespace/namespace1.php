<?php
namespace myself;
function var_dump($a) {
	echo "<p style='color:red'>$a</p>";
}
var_dump(100); //类名空间中使用重定义系统函数
\var_dump(100);  //显示原来的系统函数

?>