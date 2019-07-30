<?php
    /**
     * 闭包函数(closures function) 
     */
    //案例一：值得关注
    $num = 1024;
    function mainfun(){
        $num = 2048;
        echo "0)this is main function ${num} <br>";
        function one(){
            global $num; //声明调用的全部变量实际是主函数外部的$num的值
            echo "1)this is one function ${num} <br>";
        }
        function two(){
            global $num;
            echo "2)this is two function ${num} <br>";
        }
        one();
        two();
    }
    mainfun();  //必须调用主函数后才能执行one这个子函数
    echo "在主函数调用后,再次调用one()函数 ：";
    one();


    //案例二：简单的闭包函数
    function main($name = 'Weiyi', $job = 'Security',$str = '--- Company infomation ---'){
    
        $anonymouse = function($str) use($name, $job){         //这里的use是使用的匿名函数外部的变量
            echo "<br/>{$str} <br/>";
            echo "Name = {$name} , job = {$job} <br/>";
        }; //非常注意闭包函数后有;号
        $anonymouse($str);
    }
    main(); //默认参数
    echo "<br><br>再次调用 :";
    main("WeiyiGeek", "HR" , "--- My Canmpay ---");  //自我创新