<?php

class Person{
    private $name = "张珊";
    private $age = 20;
    function __construct($n, $a){
        $this->name = $n;
        $this->age = $a;
    }

    function pub(){
        echo "My Name is {$this->name}, I age's : {$this->age}";
    }

    function __call($method, $argment){
        echo "<p>方法为:$method , 参数为:";
        print_r($argment);
        echo "不存在的！</p>";
    }
}

$test = new Person("qq",10);
$test -> pub();

$demo = new Person("凌日",56);
$test -> say(123,456,678);
$test -> nomore("123","456","789");

