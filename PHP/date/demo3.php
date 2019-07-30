<?php
/***
 *  日期核心组件编写
 * 
 */

 date_default_timezone_set("PRC");
 //年月日
 $year = isset($_GET['year']) ? $_GET['year']:date("Y");
 $month = isset($_GET['month']) ? $_GET['month']:date("m");
 $day = isset($_GET['day']) ? $_GET['day']:date("d");

 //获取当年当前月得天数
 $daynum = date("t",mktime(0,0,0,$month,$day,$year));

 //获取当月1号是星期几
 $currentweek = date("w",mktime(0,0,0,$month,1,$year));

 echo "今天是{$year}年{$month}月{$day},时间:".date("H:i:s",time())."<br>";
 echo date("今天是Y年m月d,时间:H:i:s",time())."<br>";

//表格日历
echo  '<table border="1" width="300"><tr>';
//表头
echo  '<th style="background:grren">日</th>';
echo  '<th style="background:grren">一</th>';
echo  '<th style="background:grren">二</th>';
echo  '<th style="background:grren">三</th>';
echo  '<th style="background:grren">四</th>';
echo  '<th style="background:grren">五</th>';
echo  '<th style="background:grren">六</th></tr>';

echo  '<tr>';

for($i = 0; $i < $currentweek; $i++){
    echo "<td>#</td>";
}

for($j=1; $j < $daynum; $j++){
    $i++;
    if($j == $day){
        echo "<td style='background:red'>{$j}</td>";
    }else{
        echo "<td>{$j}</td>";
    }
    if($i%7 == 0){
        echo "</tr><tr>";
    }
}

//值得学习,当最后一个日期不是星期6时候进行利用#补齐
while(!($i%7==0)){
    echo "<td>#</td>";
    $i++;
}
echo '</tr></table>';
