<?php
/**
 * @function : 多个参数相加
 * @param : [number $...]
 * @return : number demo([number $...])
 */

//返回一个数组,包含所有参数
 function ervey_args(){
    echo "##########################";
    echo "<br/>";
    $result = func_get_args(); //返回一个数组变量给变量 
    var_dump($result);
 }

 ervey_args(6,6,6);
 echo "<br/>";
 ervey_args(1,2,3,4,5,6,7,8,9,0);
 echo "<br/><br/><br/>"; 

 //返回参数的总个数并求其中的参数的之和
 function function_args_add(){
     echo "*******************************";
     $result = 0;
     for ($i=0; $i < func_num_args(); $i++) {    //不超过我们输入的参数个数
         $result += func_get_arg($i);            //直接获取数组的下标值
     }
     echo "<br>1+2...+9 = ";
     return $result;
 }
 echo function_args_add(1,2,3,4,5,6,7,8,9,0);