<?php
            /***
             * demo 2. 绘制各类图像
             */

             //1.建立画布资源
            $img=imagecreatetruecolor(500,500);
                //设置图像色彩
            
            $white = imagecolorallocate($img,0xff,0xff,0xff);
            $black = imagecolorallocate($img,0x00,0x00,0x00);
            $pink = imagecolorallocate($img,0xff,0x00,0xff);
            $red = imagecolorallocate($img,0xff,0x00,0x00);
            $green = imagecolorallocate($img,0x00,0xff,0x00);
            $blue = imagecolorallocate($img,0x00,0x00,0xff);
            $coloralpha=imagecolorallocatealpha($img,0x57,0x9b,0x67,125);


            //2.绘画各类图像
            imagefill($img,0,0,$white);      //画布背景填充
            imagesetpixel($img,2,2,$black);  // 像素点
            imagesetpixel($img,2,4,$black);  
            imagesetpixel($img,4,2,$black);

            imageline($img,0,0,500,500,$pink);  //对角线
            imageline($img,500,0,0,500,$pink);

            imagerectangle($img,100,100,200,200,$blue);  //矩形
            imagefilledrectangle($img,200,200,230,230,$green);

            imageellipse($img,250,150,50,50,$black);  //圆形或者椭圆形
            imagefilledellipse($img,350,350,30,30,$red);

            imagearc($img,350,150,50,50,0,270,$black);  //圆弧
            imagefilledarc($img,150,350,50,50,0,270,$blue,IMG_ARC_ROUNDED); //这里需要注意样式

            imagestring($img,10,100,350,"PHP-GD Rows",$red);  //字符串（水平）
            imagestringup($img,10,100,350,"PHP-GD Columns",$red);  //字符串（垂直）
            imagechar($img,20,360,322,'P',$black);  //单个字符
            imagecharup($img,20,320,322,'H',$black);
            imagechar($img,20,330,322,'P',$black);
            imagettftext($img,20,30,267,100,imagecolorallocate($img,195,120,165),"D:\\xampp\\htdocs\\php\\gdLibriay\\simkai.ttf","自定义字体"); //字体（30是度数）

            //3.输出图像画布

            header("Content-Type:image/png");
            imagepng($img);


            //4.释放资源
            imagedestroy($img);
?>
