<?php
/***
 * GD库初始使用案例
 */

 //1.建立画布资源
$image = imagecreatetruecolor(200,200); //建立空白页面

 //2.画布颜色及其图像设置
 $white = imagecolorallocate($image,255,255,255);
 $black = imagecolorallocate($image,0X00,0X00,0X00);
 $red = imagecolorallocate($image,255,0,0);
 imageFill($image, 0, 0, $white);                    	//绘制背景
 imageLine($image, 0, 0, 200, 200, $black);        	//画线
 imageLine($image, 0, 200, 200, 0,$black);
 imageString($image, 4, 0, 100, 'Hello World , PHP GD', $red);  	//添加字串

 //3.输出或者报错图像
 header("Content-Type:image/png");
 if(imagepng($image))
 //if(imagepng($image,"test.png"))  //保存到当前的目录下名为test.png
{
    echo "图片输出成功！";
}
else
{
    echo "输出图像失败！";
}
 //4.释放画布资源
imagedestroy($image);

?>