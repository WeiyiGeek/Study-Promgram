<?php

class girlFriend {
    public $name;
    public $age = 21;
    public $height = '166';

    public function mainFun($nl,$sg){
        /** $this 关键字 来表示对象本身自己 **/
        return "Name is {$this->name} , Age = {$nl}, 身高为 {$sg} cm";   //注意对象指向后的成员不加$
    }


    /** 构造方法 （默认将执行一次|可用初始化）函数名与类名相同 PHP version 4 **/
    public function girlFriend($name,$age,$sex="女"){
        $this->name = $name;
        $this->age = $age;
        echo "PHP version 4.*| 申请对象后自动调用(构造方法) ：{$this->name} , {$age} , {$sex} ;<br>";
    }
    /** 构造方法 PHP version 5 | 优先级比上面那种方式 高 **/
    public function __construct($name,$age,$sex="女"){
        $this->name = $name;
        $this->age = $age;
        echo "PHP version 5.*| 申请对象后自动调用(构造方法) ：{$this->name} , {$age} , {$sex} ;<br>";
    }

    /** 析构方法 （对象释放的时候执行）PHP version 5 注意：没有参数**/
    public function __destruct(){
        echo "由于对象放在 \"栈\"里面 \"后进先出\" | 析构方法 （对象释放的时候执行,无参数）： {$this->name} 下次再见,see you！<br/>";
    }
}

//申明两个对象
$objOne = new girlFriend("张三",66);
$objTwo = new girlFriend("李四",100,"男");

//给对象里面的成员属性赋值
$objOne->name = "赵小花";

$objTwo->name = "经小花";
$objTwo->age = 23;
$objTwo->height = '175';


echo  "<br><br>";
//引用对象里面的方法 (突发奇想)
echo $objOne->mainFun($objOne->age,$objOne->height)."<br>";
echo $objTwo->mainFun($objTwo->age,$objTwo->height)."<br>";



