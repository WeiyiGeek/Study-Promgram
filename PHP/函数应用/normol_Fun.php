<?php
    /**
     * @功能 ：处理两个数相加
     * 
     * @param 1： number $a 这是第一个加数
     * @param 2： number $b 这是第二个加数
     * 
     * @return number(number $a, number $b)
     * 
     */

     function add($a,$b){
         return ($a + $b);
     }

     echo "<p>两个数之和为：</p>".add(123, 456);
     echo "<br>".add(3.2, 5.4);
	 echo "<br>".add(10, 5.4);

