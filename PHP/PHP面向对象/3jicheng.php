<?php

//父类
class Person
{
    private $id;
    public $name;
    protected $age;
    protected $worker;

    function __construct($id,$name,$age,$worker){
        $this->id = $id;
        $this->name = $name;
        $this->age = $age;
        $this->worker = $worker;
    }

    function __destruct(){
        echo "<br>继承性 --- 测试完毕, 再见 {$this->worker}";
    }

}

//扩展子类（1）
class Teacher extends Person
{
    public $school;
    public function sc(){
        echo "欢迎您职位{$this->worker}, 姓名：{$this->name}, 学校: {$this->school} , 年龄 {$this->age}";
    }

}

//扩展子类（2）
class Student extends Person
{
    public $clas;
    function cl(){
        echo "欢迎您职位{$this->worker}, 姓名：{$this->name}, 班级：{$this->clas} , 年龄 {$this->age}";
    }
    
}


$te = new Teacher(1,"小于",35,"Tea");
$te->school = "重庆第二师范大学";
$te->sc();

echo "<br><br>";

$st = new Student(2,"小花",21,"Stu");
$st->clas="15102";
$st->cl();
