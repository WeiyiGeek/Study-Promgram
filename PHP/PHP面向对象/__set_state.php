<?php
/**
 *  1. eval()函数 --- 检查并执行PHP代码
 *	$str = "echo 'abc';";
 *  eval($str); //abc
 * 
 *  var_dump();
 *  var_export();
 */

 //查看var_dump() 与var_export()异同
    $arr = array("Name"=>"PHP","Age"=>22,"AddR"=>"重庆涪陵");
    var_export($arr);  //打印为数组

    echo "<pre>";
    var_dump($arr);   //打印为数组
    echo "</pre>";

    $b = var_export($arr,true);  //特别注意这里也是true
    var_dump($b);     //返回字符串

    echo "<br><br>";
    eval('$a='.var_export($arr,true).';');  //返回数组,并且可以执行php代码
    var_dump($a);  //数组
    echo $a['Name'];
    echo "<br><br>";

    //查看魔术方式__set_state($arr)
    //	__set_state() 方法 ， 就是在使用var_export()方法时， 导出一个类的信息时自动调用的方法
    class Person{
        private $name;
        private $id;
        function __construct($n,$i){
            $this->name = $n;
            $this->id = $i;
        }

        static function __set_state($arr)
        {
            print_r($arr); //打印传入得数组参数

            $p = new Person("李伟",2);
            $p->name=$arr['name'];  //将传入数组下标为0得值给name
            $p->id=2;
            return $p;  //记住要返回对象;
        }
    }

    $p = new Person("张伟",1);

    $b = var_export($p, true);  //返回得是String
    eval('$c='.var_export($p,true).';');  //会自动调用魔术方法 (转入数组)

    echo '<pre>';
    var_dump($b);    //String
    var_dump($c);   //Array
    echo '</pre>';
