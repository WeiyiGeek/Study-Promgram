<?php

class A{
    public $id1;
    private function demo1(){
        echo "Hello, A {$this->id1}";
    }
}

class B extends A{
    public $id2;
    protected function demo2(){
        echo "Hello, B {$this->id2}";
    }
}

class C extends B{
    public $id3;
    public function demo3(){
        echo "{$this->id1} Hello, {$this->id2} C {$this->id3}<br>";
        echo "调用父类的proteted修饰词的方法：";
        $this->demo2();

        echo "<br>调用父类的private修饰词的方法：";
        $this->demo1();
    }
}

//继承不能调用private私有修饰词
$t = new C();
$t->id1 = 1;
$t->id2 = 2;
$t->id3 = 3;
$t->demo3();

