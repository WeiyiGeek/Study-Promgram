<?php
/***
 * 实现图片剪切
 * @param1 图片资源
 * @oaram2 缩放宽度
 * @param3 缩放高度
 */
function thumb($img,$width,$height){
    list($w,$h,$type) = getimagesize($img);
    $types = array(1=>"gif",2=>"jpeg",3=>"png",4=>"bmp");

    //变量函数
    $createimage = "imagecreatefrom".$types[$type];

    //原图片
    $imgsrc = $createimage($img);
    //目标图片
    $imgdest = imagecreatetruecolor($width,$height);

    //等比例缩放 （需要了解）
    $ratio_orig = $w / $h;
    if ($width / $height > $ratio_orig) {
        $width = $height * $ratio_orig;
    } else {
        $height = $width / $ratio_orig;
    }

    //缩放图片
    imagecopyresampled($imgdest,$imgsrc,0,0,0,0,$width,$height,$w,$h);

    //输出图片资源
    header("Content-Type:image/$types[$type]");
    $save = "image".$types[$type];
    $save($imgdest);
    //释放原/目标图片资源
    imagedestroy($imgsrc);
    imagedestroy($imgdest);
}
thumb("windows.jpg",150,150);



 /***
 * 实现图片剪切
 * @param1 图片资源
 * @oaram2 剪切起始x坐标
 * @param3 剪切起始y坐标
 * @param4 剪切宽度
 * @param5 剪切高度
 */
// function cut($imgsrc,$x,$y,$destwidth,$destheight){
//     list($srcwidth,$srcheight,$type) = getimagesize($imgsrc);
//     $types = array(1=>"gif",2=>"jpeg",3=>"png",4=>"bmp");

//     //变量函数
//     $createimage = "imagecreatefrom".$types[$type];

//     //原图片
//     $imgsrc = $createimage($imgsrc);
//     //目标图片
//     $imgdest = imagecreatetruecolor($destwidth,$destheight);


//     //剪切图片 （注意设置的是要剪切的宽高）
//     imagecopyresampled($imgdest,$imgsrc,0,0,$x,$y,$destwidth,$destheight,$destwidth,$destheight);

//     //输出图片资源
//     header("Content-Type:image/$types[$type]");
//     $save = "image".$types[$type];
//     $save($imgdest);
//     //释放原/目标图片资源
//     imagedestroy($imgsrc);
//     imagedestroy($imgdest);
// }
// //从（50,50）开始剪切100*100的高宽图片
// cut("new_windows.jpg",50,50,200,200);

?>