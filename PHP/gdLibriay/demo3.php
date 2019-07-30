<?php
/***
 * 实现文字水印
 * @param1 图片资源
 * @oaram2 字符串水印
 */
 function fontsy($img,$str)
 {
    list($imgwidth,$imgheight,$type)=getimagesize($img);
    //print_r(getimagesize($img));
    $types = array(1=>"gif",2=>"jpeg",3=>"png");

    //为了处理各种的图片类型的背景 进行函数字符串的拼接
    $imgfrom = "imagecreatefrom".$types[$type];
    $imgobj = $imgfrom($img);

    $color = imagecolorallocate($imgobj,255,0,0);
    $x = ($imgwidth - imagefontwidth(15) * strlen($str))/2;
    $y = ($imgheight - imagefontheight(15)) / 2;

    //文字水印
    imagestring($imgobj,15,$x,$y,$str,$color);
    header("Content-type:image/$types[$type]");
    $save = "image".$types[$type];
    $save($imgobj);
    imagedestroy($imgobj);
 }

 fontsy("windows.jpg","Microsoft");
 fontsy("test.png","Microsoft");

?>