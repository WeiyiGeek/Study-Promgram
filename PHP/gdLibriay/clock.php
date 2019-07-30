<?php
/***
 * 
 * 绘制时钟
 */
//当前时间
date_default_timezone_set("PRC");
$h=date("H",time());
$m=date("i",time());
$s=date("s",time());

//绘制图像
$img = imagecreatetruecolor(300,300);
$red =  imagecolorallocate($img,255,0,0);
$black = imagecolorallocate($img,0,0,0);
imagefill($img,0,0,imagecolorallocate($img,255,255,255));
//圆盘
imageellipse($img,110,110,160,160,$black);
imagefilledellipse($img,110,110,4,4,$black);
imagestring($img,5,100,30,12,$black);
imagestring($img,5,180,105,3,$black);
imagestring($img,5,105,170,6,$black);
imagestring($img,5,30,105,9,$black);


//指针需要用到三角函数 与圆弧
// 1 rad = pi() / 180  
// M_PI / 180 = 1 角度 => 1秒6度  所以这里M_PI / 180 * 6  => M_PI / 30
$len = 70;
$x = 110 + $len * sin(M_PI / 30 * $s);   //加上圆心的坐标 0~180 为正  180 ~（该+）
$y = 110 - $len * cos(M_PI / 30 * $s);   //0 ~ 90 | 270 ~ 360 为正 （该减）

imageline($img,110,110,$x,$y,$red);

imagestring($img,10,50,260,"Time => {$h}:{$m}:{$s}",$red);  //时间

//显示图像
header("Content-Type:image/png");
imagepng($img);

//释放图像
imagedestroy($img);

?>