<?php
/**
 * 验证码的类 （a按功能进行建立方法）
 */
class Vcode{
    private $width;
    private $height;
    private $num;
    private $code; //返回验证码
    private $imgobj;

    //构造方法初始化三个参数 
    //验证码图片的高度，宽度，字符数量
    function __construct($width=80,$height=25,$num=4){
        $this->width = $width;
        $this->height = $height;
        $this->num = $num;
        $this->code = $this->createcode();
    }

    //或者字符的验证码，保存在服务器中
    function getcode(){
        return $this->code;
    }

    //图像输出
    function showcode(){
        //创建背景 （color,大小，边框）
        $this->createbg();
        //画字（大小）
        $this->createstring();
        //干扰元素（点，线）
        $this->setdisturb();
        //输出图像
        $this->printimg();
    }
    //创建背景
    private function createbg(){
        $this->imgobj = imagecreatetruecolor($this->width,$this->height);
        $bgcolor = imagecolorallocate($this->imgobj,rand(252,255),rand(252,255),rand(252,255));
        imagefill($this->imgobj,0,0,$bgcolor);
        imagerectangle($this->imgobj,0,0,$this->width-1,$this->height-1,imagecolorallocate($this->imgobj,0,0,0));
    }
    //创建字符
    private function createstring(){
        for($j = 0; $j < $this->num; $j++){
            //深色区变化
            $fontcolor = imagecolorallocate($this->imgobj,rand(0,128),rand(0,128),rand(0,128)); 
            $fontsize=rand(3,5);
            //平均存放每个字符
            $x = ($this->width / $this->num) * $j + 3;
            $y = rand(0,imagefontheight($fontsize)-3);
            imagechar($this->imgobj,$fontsize,$x,$y,$this->code[$j],$fontcolor);
        }
    }
   

    //设置干扰
    private function setdisturb(){
        //点点
        for($i = 0; $i < 100; $i++){
            $discolor = imagecolorallocate($this->imgobj,rand(0,255),rand(0,255),rand(0,255));
            imagesetpixel($this->imgobj,rand(1,$this->width - 2),rand(1,$this->height -2),$discolor);
        }
        //线条圆狐
        for($i = 0; $i < 5; $i++){
            $discolor = imagecolorallocate($this->imgobj,rand(100,255),rand(100,255),rand(100,255));
            imagearc($this->imgobj,rand(-10,$this->width+10),rand(-10,$this->width+10),rand(30,300),rand(30,300),55,48,$discolor);
        }
    }
    //输出图像 (新函数)
    private function printimg(){
        if(imagetypes() & IMG_GIF){
            header("Content-Type:image/gif");
            imagegif($this->imgobj);
        }elseif(function_exists("imagejpeg")){
            header("Content-Type:image/jpeg");
            imagejpeg($this->imgobj);
        }elseif(imagetypes() & IMG_PNG){
            header("Content-Type:image/png");
            imagepng($this->imgobj);
        }else {
            die("No Image support in the PHP server");
        }
        
    }

    //生成验证码
    private function createcode(){
        $codes="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        $code="";
        for($i=0;$i < $this->num;$i++){
            $code.=$codes[rand(0,strlen($codes)-1)];
        }
        return $code;
    }

    //析构方法进行示范
    function __destruct(){
        imagedestroy($this->imgobj);
        //echo $this->code;
    }
}
