<?php
    /**
     * 简单的递归函数功能（即函数的自我调用）
     * notice : 必须存在终结条件
    */

    function recur($num){
        echo " $num |";  //这就是 递
        
        if($num > 0){
            recur($num-1);
        }else{
            echo "<br/>";
        }

        echo " $num -";  //这里是 归
    }
    echo "递：";
    recur(10);
    echo " ：归";