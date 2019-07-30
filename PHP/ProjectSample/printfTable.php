<?php
    /*保证行与列对齐 - Method 1 */
    echo '<table border="1" align="center" width="800" bgcolor="#F0F0F0">';
    echo '<caption><h3>循环练习使用表格输出</h3></caption>';
    $i = 0;
    while($i < 100){
        if($i % 10 == 0){
            echo '<tr>';
        }
        echo '<td>'.$i.'</td>';
        $i++;        //第一次 i = 9 然后自加的时候 （！Study）
        if($i % 10 == 0){  //闭合第一行,这时i = 10; 有重新执行上一个if语句
            echo '</tr>';
        }
    }
    echo '</table>';
    

    /*保证行与列对齐 - Method 2 while 内层判断 */
    echo '<table border="1" align="center" width="800">';
    echo '<caption><h3>循环练习使用表格输出</h3></caption>';
    $a = 0;
    while($a < 100)
    {
        $b = 0;
        if($a % 4 == 0){  //精辟之处（！study）
            echo '<tr bgcolor="#F0F000">';
        }else{
            echo '<tr>';

        }
        while($b < 10){
            echo '<td>'.$a.'</td>';
            $b++;
            $a++;
        }
        echo '</tr>';
    }
    echo '</table>';
    