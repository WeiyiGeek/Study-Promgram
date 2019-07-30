<?php
    /*** 栈的数组演示  ***/
    $stack = array();
    echo "栈（stack）:";

    //压栈
    array_push($stack, "1");
    array_push($stack, "2");
    array_push($stack, "3");
    array_push($stack, "4",5,6);
    print_r($stack);
    echo "<br>";
   //弹栈 (后进先出)
    echo array_pop($stack)."   ";  //6
    echo array_pop($stack)."   ";  //5
    echo array_pop($stack)."   ";  //4
    echo "<br>";

    print_r($stack);
    echo "<br><br>";



    /** 队列的数组演示 */
    $queue = array();
    array_unshift($queue,"1");
    array_unshift($queue,"2");
   // array_unshift($queue,"3",4,5,6); // 3 4 5 6 2 1 (这里比较特别)
    array_unshift($queue,"3");
    array_unshift($queue,"4");
    array_unshift($queue,"5");
    array_unshift($queue,"6");
    echo "队列（queue）:";
    print_r($queue);
    echo "<br>";

    //出队列 （先进先出）
    echo array_pop($queue)." ";  //1
    echo array_pop($queue)." ";  //2
    echo array_pop($queue)." ";  //3

    echo array_shift($queue); //这里将队尾的6取出 （注意这里函数与存队列相似不要搞混）
    echo "<br>";
    
    print_r($queue);



