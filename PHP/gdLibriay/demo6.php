<?php
/**
 * 实现图像的旋转
 * @param 旋转图片
 * @param 旋转角度
 */

 function rotate($src,$angle){
    list($sw,$sh,$stype) = getimagesize($src);
    $type = array(1=>"gif",2=>"jpeg",3=>"png",4=>"bmp");
    //1.建立图片资源
    $imgfrom = "imagecreatefrom".$type[$stype];
    $imgobj = $imgfrom($src);
    //2.旋转图片
    $xz = imagerotate($imgobj,$angle,imagecolorallocate($imgobj,255,255,255));

    //3.显示图片
    header("Content-Type:image/{$type[$stype]}");
    $save = "image".$type[$stype];
    $save($xz);
    //释放图片资源
    imagedestroy($imgobj);
    imagedestroy($xz);

 }
 //负数为顺时针
 rotate("test.png",-50);


 /****
  * 实现图像的翻转,默认水平翻转
  *  @param 图像翻转
     @param 按照水平还是垂直翻转 horizonal x / vertical y
  */
function reversal($src,$orien="x"){
    list($sw,$sh,$stype) = getimagesize($src);
    $type = array(1=>"gif",2=>"jpeg",3=>"png",4=>"bmp");
    //1.建立图片资源
    $imgfrom = "imagecreatefrom".$type[$stype];
    $imgobj = $imgfrom($src);
    $newobj = imagecreatetruecolor($sw,$sh);

    //判断进行水平翻转还是垂直翻转
    //源图像 -> 新图像
    if($orien == "x"){
        for($x = 0; $x < $sw; $x++){
            // 目标 源 目标生成x 目标生成y 源x 源y 源宽度1像素 源高度
            imagecopy($newobj,$imgobj,$sw-$x-1,0,$x,0,1,$sh);
        }
    }else{
        for($y = 0; $y < $sh; $y++){
            //有点绕： 目标资源 源资源
            //源资源的x不变y从$y变化，且宽度为$sw，高度为1像素进行复制到目标资x不变为0,y进行从下到上
            imagecopy($newobj,$imgobj,0,$sh-$y-1,0,$y,$sw,1);
        }
    }
       
    //3.显示图片
    header("Content-Type:image/{$type[$stype]}");
    $save = "image".$type[$stype];
    $save($newobj);
    //释放图片资源
    imagedestroy($imgobj);
    imagedestroy($newobj);
    
}

reversal("new_windows.jpg","x");

?>