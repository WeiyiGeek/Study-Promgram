<?php
    //invoke() 代码案例
class Person
{
    private $name;
    function __construct($n){
        $this->name = $n;
    }
    function __invoke($a,$b,$c)
    {
        echo "<p style='color:red'>Name = {$this->name}在对象引用后加上()调用时自动调用这个方法{$a}=={$b}=={$c}<br></p>";
    } 

    static function __callstatic($method, $args) {
        echo "<p style='color:pink'>你调用的静态方法$method(".implode(",", $args).")不存在";  //implode()进行拼接
    }
}
$p = new Person("Java");
$p(1,2,3);

$p::say("likle","Love");  //静态方法调用方式

?>