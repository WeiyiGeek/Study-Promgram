<?php
/**
 *  static 修饰符 案例
 * 
 */
class Person {
    public $id;
    public $name;
    public $age;
    public static $country;

    const SEX = "男性";   //使用const关键字

    function __construct($i,$n,$a,$c){
        $this->id = $i;
        $this->name = $n;
        $this->age = $a;
        self::$country = $c;  //注意self 特殊关键字 类后面:: 又 $+属性
    }

    public function say() {
        echo "<p>我的名子是：{$this->name}, 我的年龄是：{$this->age}, 我的ID是：{$this->id}, 我得国家是 ".self::$country."</p><br>"; //this代表对象 self代表类
    }

    static function mySex(){
        echo "<br>我的性别是 ：".self::SEX;
    }

}

//采用类直接访问设置静态属性
Person::$country = "中国";
echo Person::$country;

//对象不能使用静态属性 (否则会报错) 只有采用类与self进行输出
$demo = new Person(1024,"Apahce",23,"USA");
echo Person::$country;  //采用这种方法更改类里面得静态属性
$demo->say();


//只有静态方法才能使用静态属性得案例
class Student {
    static $numid = 1023;
    static $name = "PHP";
    static $house = "16105";

    //使用self应该非常注意 $ 
    public static function say(){
        echo "我的学号是：".self::$numid. ", 我的姓名是：".self::$name.", 我的宿舍是：".self::$house."<br>";

    }

    public function date(){
        echo "使用@能实现利用类来调用不是静态得方法,但不推荐！<br>";
    }
}

Student::say();
@Student::date();   //注意这里


//const关键字 demo
echo "<br>输出Const定义的常量（采用类进行访问）：".Person::SEX;
Person::mySex();
