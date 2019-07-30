<?php
/***
 * 子类里面允许重写（覆盖）父类的方法，在子类中，使用parent访问父类中的被覆盖的属性和方法；
 * 
 */
class Person{
    public $id;
    public $name;
    public function __construct($id,$name){
        $this->id = $id;
        $this->name = $name;    
    }
    public function say(){
        echo '<br>say a talk about！<br>';
    }

}

class Stu extends Person
{
    public $cls;
    public function __construct($id,$name,$cls=1024){
        parent::__construct($id,$name);
        $this->cls = $cls;
        echo "{$this->id} {$this->name} {$this->cls}";
    }

    public function say(){
        parent::say();
        echo "{$this->cls} is shcool id!<br>";
    }
}


$st = new Stu(1,"张伟",10103);
$st->cls="1056";
$st->say();
