<?php
// $f = @fopen ('date','w');  //向服务器里创建文件写信息 write date
// if($f){
// fwrite($f,'Hello PHP');
// fclose($f);
// echo'ok';
// }else{
// 	echo "创建文件失败！";
// }

// $f = @fopen('date','r');//向服务器里读取文件写信息 read date
// while (!feof($f)) {
// 	$content = fgets($f);  //读了第一行
// 	echo $content;
// }
// fclose($f);

echo "采用file_get_contents函数读取文件".'<br>';
echo file_get_contents('date'); //直接读取全部文件文本
