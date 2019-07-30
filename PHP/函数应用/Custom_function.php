<?php

    //create function taskID($param1, $param2)
    // 函数参数 -> 形参
    function taskID($param1, $param2)
    {
        echo "<p style='color:gray;'>正在执行add运算, $param1 + $param2 结果为:</p>";
        return $param1 + $param2;
    }
    //函数参数 -> 实参
    $result=taskID(66,99);
    echo "{$result}<br><br>";


    if(function_exists('taskID'))
    {
        echo 'taskID（）函数存在！<br><br>';
    }else{
        echo 'taskID（）函数不存在<br><br>';
    }


    //补充函数 -> 写入文本到文件之中
    $command = "system('ipconfig');";
	file_put_contents("ip.txt", $command);


    $str = ""; //进行声明
    echo table("用户表",10, 10, 2, 'red', 1, 800, 'left');  //实参 (实际的参数)  10 x 10 
	//声明函数时，提供的参数， 形参（形式上的参数）
	function table($tablename, $rows, $cols, $num, $color, $border, $width, $align){
        global $str;  //全局变量
		$str .= '<table border="'.$border.'" width="'.$width.'" align="'.$align.'">';
		$str .= '<caption><h1>'.$tablename.'</h1></caption>';
		for($i=0; $i<$rows; $i++) {
            $bg = ($i%$num==0) ? $color : "";
            
			$str.= '<tr bgcolor="'.$bg.'">';
			for($j=0; $j < $cols; $j++ ) {
				$str .= '<td>'.($i*10+$j).'</td>';  //值得学习
			}
			$str .= '</tr>';
		}

		$str .= '</table>';
		return $str;
	}
