<?php

class Person {
    protected $id;
    protected $name;
    protected $age;

     /*  在PHP中final不定义常量, 所以就不会使用，也不能使用final来修饰成员属性
	 *  1. final可以修饰类  --- 这个类不能去扩展， 不能有子类 (不让别人去扩展， 这个类是最终的类时)
	 *  2. final可以修饰方法  --- 这个方法，就不能在子类中覆盖(不让子类去改这个方法， 或扩展这个方法的功能时， 这个方法也就时最终的方法)
     */
    final function say(){
        echo "我是不能被覆盖或者修改得<br>";
    }
}

class Stu extends Person
{
    public $house;
    public function __construct($i,$n,$a,$h)
    {
        $this->id = $i;
        $this->name = $n;
        $this->age = $a;
        $this->house = $h;
    }
    public function talk(){
        echo "{$this->id} {$this->name} {$this->age} {$this->house}";
    }

    /*  Cannot override final method Person::say()  会报错不能重写say()
    public function say(){
        echo "测试父类中say()得函数能否被覆盖<br>";
    }
    */

}

$p = new Person();
$s = new Stu(1,"张伟",23,16105);

echo ($p instanceof Person) ? "<p>对象p在Person类中</p>":"<p>对象p不在类中</p>";
echo ($s instanceof Stu) ? "<p>对象s在Stu类中</p>":"<p>对象s不在类中</p>";
echo ($s instanceof Person) ? "<p>对象s也在Person类中</p>":"<p>对象s不在类中</p>";  //这就是由于类继承,判断对象是不是在类中



