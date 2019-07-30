<?php
/***
 *  自定义异常类实现重写继承方法
 */

//新建一个类继承Exception,写出对应这个异常解决方法, 就是一下正常类的结构
/* 自定义的一个异常处理类，但必须是扩展内异常处理类的子类 */
class myException extends Exception{
    //重写构造方法
    function __construct($msg,$code=0){
        parent::__construct($msg);
    }
     //重写父类方法，自定义字符串输出的样式
    public function __toString() {        
		  return __CLASS__.":[".$this->code."]:".$this->message."<br>";
	}

    //重定义构造器使第一个参数 message 变为必须被指定的属性
    function loading(){
        echo "5.恢复加载 Loading .... <br>";
    }
}

//在定义一个异常处理类
class demoEx extends Exception{
    function chuli(){
        echo "<p> n#修复工具加载 <p>";
    }
}

//建立正常的类
class Tv {
    function loa($bo){
        if(!$bo)
           throw new demoEx();
        echo "n -- 工具加载中 --  <br>";
    }
}

echo "1.Start <br>";
try {
    echo "2.正在加载 Loading .... <br/>";

    $gell = new Tv();
    $gell -> loa(false);  //控制程序异常(值得学习)

    throw new myException("<b style='color:red'>4.采用恢复工具 Tools .....</b><br>");

}catch (myException $e){
    echo "3.加载失败 Not Loading .... <br/>";
    //构造方法重写之后效果进行使用方法
    echo  $e->getMessage();
    $e->loading();
}catch (demoEx $e){
    $e->chuli();
}

echo "6.Stop <br>";

?>