<?php

echo $_GET[k];

class Magic{
    //成员属性
    public $name = "First Name";
    private $name1;
	private $age1;
	private $sex1;

    //构造方法
    function __construct($name1="", $age1=20, $sex1="男") {
		$this->name1 = $name1;
		$this->age1 = $age1;
		$this->sex1 = $sex1;
    }
    
    /*
    //注意这里$pri是接收私有描述符的成员的属性名称;
    function __get($pri) {	
        echo "1. $pri  ######### __get ##### ";
		return $this->$pri;
    }
    //控制设置的值;
	function __set($name, $value) {
        echo "2. $name  ######### __set ##### <br>";
	    if($name=="age") {
			if($value < 0 or $value > 100)
				return;
			}
			$this->$name = $value;
	}
    */

    function __unset($priname)
    {
		echo "3.$priname !!!!!!!! __unset !!!!!!!!!!<br>";
		if($priname != "age")  {
			unset($this->$priname);
		}
    }
    function __isset($priname)
    {
        echo "4.$priname !!!!!!!! __isset !!!!!!!!!!<br>";
		if($priname=="age1")
			return true;
		return isset($this->$priname);
	}


    //析构方法
    function __destruct() {
			echo "<br><br>再见 : {$this->name1} {$this->age1} {$this->sex1} <br>";
	}
}

$p1 = new Magic("妹子", 88, "女");
/*
echo "Pulibc : ".$p1->name."<br>";
echo "Private : ".$p1->name1."<br>";   //将会调用 __get();
echo "Private : ".$p1->sex1."<br>";

$p1->name1="毕思珠";                  //设置值将会调用 __set();
$p1->age1=15;
*/

unset($p1->name);   //public 访问描述符   
echo isset($p1->name) ? "对象中的{$obj}是存的属性<br>" : "对象p1中不存在{$obj}属性<br><br>";  //会调用 __isset()
echo isset($p1->age1) ? "对象中的{$obj}是存的属性<br>" : "对象p1中不存在{$obj}属性<br><br>";;  //会调用 __isset()
unset($p1->name1);   //private 访问描述符   会调用__unset();
unset($p1->sex1);    //                    会调用__unset();
   
?>