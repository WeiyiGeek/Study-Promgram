<?php
/***
 * 各项排序数组的函数
 */
 $a = ["b","c","a",1,2,100=>3,"A"];
 echo "原数组：";
 print_r($a);
 //bool sort(); 函数 从小到大进行排序
 echo "<br/>Value 升序(注意重新索引)：";
 sort($a); //本身都对数组进行取地址;升序
 print_r($a);
 //bool rsort(); 函数 采用从大到小排序
 echo "<br/>value 降序(注意重新索引)：";
 rsort($a); //本身都对数组进行取地址;降序
 print_r($a);
 echo "<br><br><br>";


 //bool ksort(); 按键值排序 （升序）
 $b = array("b"=>"LOVE", "a"=>"I", "c"=>"Study", "8"=>"Language", 4=>"PHP");
 echo "原数组：";
 print_r($b);

 echo "<br/>Key 升序(注意关联索引)：";
 ksort($b); //本身都对数组进行取地址;升序
 print_r($b);

 //bool krsot(); 按键值排序 （降序）
 echo "<br/>Key 降序(注意重新索引)：";
 krsort($b); //本身都对数组进行取地址;降序
 print_r($b);
 echo "<br><br><br>";

 //bool asort(); arsort(); 保持关联数组的关系;
 $c = ["L"=>"Linux","A"=>"Apahce","M"=>"Mysql","P"=>"PHP"];
 $d = ["L"=>"Linux","A"=>"Apahce","M"=>"Mysql","P"=>"PHP"];
 echo "原数组：";
 print_r($d);
 echo "<br>采用sort方式";sort($c);
 print_r($c);
 echo "<br>采用asort方式";asort($d);
 print_r($d);
 echo "<br>采用arsort方式";arsort($d);
 print_r($d);