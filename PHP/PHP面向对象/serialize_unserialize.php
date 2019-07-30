<?php

class Person{
    private $name;
    private $age;
    function __construct($n, $a){
        $this->name = $n;
        $this->age = $a;
    }
    function say(){
        echo "<p style='color:red'>This is Name : {$this->name} , age {$this->age}</p>";
    }

    function __sleep(){
        echo "<p>只串行化，name 和 age = 28 : </p>";
		return array("name","age"); //需要返回属性
    }

    function __wakeup(){
        echo "<p>返串行化时自动调用我这个方法了，相当于初始化</p>";
		$this->age = 12;
    }
}

$o = new Person("PHP",28);
$str = serialize($o);                       //将对象串行化
@file_put_contents("objstr.txt", $str);      //将字符串保存在文件夹objstr.txt中

echo "<p style='color:red;'>对象转完字符串， 保存到文件中成功!</p>";

$str = @file_get_contents("objstr.txt"); //读出字符串从文件中
$p = unserialize($str);     //返串行化
$p->say();