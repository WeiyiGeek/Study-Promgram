<?php

	echo 'break;<br>';
	for($i=0; $i<100; $i++) {
		if($i >= 10)
			break;
		echo "{$i} ";
	
	}

	echo '<br><br>continue;<br>';
	$i = 0; 
	while($i < 10 ){
		$i++;		
		if($i%3 == 0)
			continue;

		echo "{$i} ";
	}

	echo '<br><br>新语法特点:</br>';
	//新语句特点（值得学习）
	for($i=0; $i < 3; $i++) {
		for($j=0; $j<10; $j++) {
			if($j>2)
				continue 2;  //直接退到最外层中,然后继续执行第三表达式
			echo "# ${i} ${j} <br/>";
		}
		echo '<br>';
	}
	echo '<br/>';

	
	//采用break直接跳出两层循环
	$i = 0;
	while($i < 100){
		$i++;
		for($j = 10; $j > 0; $j--)
		{
			if($j == 5)
			{
				break 2;  
			}
			echo "{$i} + {$j} = ".($i + $j)."<br>";
		}
	}

	exit("die()函数,就是exit()函数的别名,都有相同的作用");
	die("这里输出后，以后的代码不执行");
?>