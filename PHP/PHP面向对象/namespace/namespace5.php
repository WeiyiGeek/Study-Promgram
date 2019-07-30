<?php
    namespace root\ti;

    function test(){
        echo "this is dynamic function!!<br>";
    }

    echo "NAMESPACE : ".__NAMESPACE__."<br>";

  //method 1
    $an = "\\root\\ti\\test";
    $an();

  //method 2
    $na1 = __NAMESPACE__.'\test';
    $na1();

    //method 3
    \root\ti\test();
    namespace\test();  //特别注意这种格式

   class Hello{
		static function world() {
			echo "This is 全局的函数() ; <br>";
    }
  }

?>