<?php

//单字节substr 与 多字节 em_substr;
$en="This is a strings and";
$cn="中国重庆";
echo "<p><b>中文与英文字符截取：</b></p>";
echo substr($en,4,12)."<br>"; 
echo mb_substr($cn,0,4,"utf-8")."<br>";

// chr() 与 ord() 之间的转换
echo "<br>字符与Ascii码转换：";
for($i = 97 ; $i < 123; $i++){
    $cc = chr($i);
    echo $cc."-";  //Ascii->string
    echo ord($cc)."<br>";   //string->Ascii
}
?>