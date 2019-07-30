<?php
    //判断当前星期
    $week = date("D");
    switch($week){
        case "Mon" : echo "当前是星期一 \n <br>"; break;
        case "Tue" : echo "当前是星期二 \n <br>"; break;
        case "Wed" : echo "当前是星期三 \n <br>"; break;
        case "Thu" : echo "当前是星期四 \n <br>"; break;
        case "Fri" : echo "当前是星期五 \n <br>"; break;
        case "Sat" : echo "当前是星期六 \n <br>"; break;
        case "Sun" : echo "当前是星期天 \n <br>"; break;
        default : die("程序将退出 Sorry！");        
    }


    //下面是非常值得学习的让某一case中常量都执行同一条语句
	$floor = 1;
	switch($floor) {
		case 1:  
		case 01:  
		case 001:
			echo "这是第一层<br>";  //和值1 01 001匹配时，没有break，将控制转移到下一个case中的语句
		       	break;
		case 2:  
			echo "这是第二层<br>"; 
		       	break;
		case 3: 
			echo "这是第三层<br>"; 
		       	break;
		case 4:  
			echo "这是第四层<br>";  
			break;
		case 5:  
			echo "这是第五层<br>";  
			break;

		default: 
			echo "这是其它楼层<br>";
		       	break;
	}


?>