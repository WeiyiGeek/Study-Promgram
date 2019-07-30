<?php
/**
 * 图片水印函数
    String @param1 源文件图片 
    String @param2 水印图片文件
 */

 function watermark($src,$dest){
    //1.互通源于水印图片信息 
    list($sw,$sh,$stype) = getimagesize($src);
    list($dw,$dh,$dtype) = getimagesize($dest);
 
    //2.建立通用数组
    $type = array(1=>"gif",2=>"jpeg",3=>"png",4=>"bmp");

    //3.建立资源
    $imgsrc = "imagecreatefrom".$type[$stype];
    $imgsrc = $imgsrc($src);
    $wimgdest = "imagecreatefrom".$type[$dtype];
    $wimgdest = $wimgdest($dest);;
    

    //4.设置水印
    $x = rand(3,$sw - $dw);
    $y = rand(3,$sh - $dh);
    //x,y是在背景画布上的坐标，后面是要设置水印图片位置与长宽设置
    imagecopy($imgsrc,$wimgdest,$x,$y,0,0,$dw,$dh);

    //5.显示水印
    header("Content-Type:image/{$type[$stype]}");
    $save = "image{$type[$stype]}";
    $save($imgsrc);
    //6.释放资源
    imagedestroy($imgsrc);
    imagedestroy($wimgdest);
}

watermark("windows.jpg","php.gif");
?>