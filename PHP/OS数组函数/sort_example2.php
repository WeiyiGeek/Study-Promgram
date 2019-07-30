<?php
/*
* 用户自定义函数排序
*/

$arr = ["File121.txt","File111.txt","file12.txt","file11.txt"];
echo "初始数组：";
print_r($arr);

//使用用户自定义的函数来排序 返回 1 -1 0
//uasort(); 会保持下标的关系
usort($arr,function($a, $b){
    $alen = strlen($a);
    $blen = strlen($b);
    if($alen > $blen){
        return 1; //从短
    }else if($alen < $blen){
        return -1; //到长
    }else{
        return 0;
    }
});
echo "<pre><br>使用自定义排序usort函数后：<br>";
print_r($arr);
echo "</pre><br>";

//对于key键按照想要的进行排序
$a = array("Linux"=>"1","Apahce"=>"2","Mysql"=>"3","Lanuage"=>"4");
echo "初始数组：";
print_r($a);
uksort($a,function($a, $b){
    $alen = strlen($a);
    $blen = strlen($b);
    if($alen > $blen){
        return -1; //从长
    }else if($alen < $blen){
        return 1; //到短
    }else{
        return 0;
    }
});
echo "<pre><br>使用自定义排序uksort函数后：<br>";
print_r($a);
echo "</pre><br>";