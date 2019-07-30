<?php
/*
*   进阶的数组排序
*/

$a = ["file.txt","FILE21.txt","file2.txt","file1.txt","file11.txt"];
echo "原数组：";
print_r($a);
echo "<pre>";
echo "<br>常规排序sort()：";
//sort($a);
//print_r($a);
//采用自然排序函数 区分大小写 natsort();
echo "<br>自然排序natsort() 区分大小写（大写优先排列）：";
natsort($a);
print_r($a);
//采用自然排序函数 区分大小写 natsort();
echo "<br>自然排序natcasesort() 不区分大小写：";
natcasesort($a);
print_r($a);
echo "</pre>";
