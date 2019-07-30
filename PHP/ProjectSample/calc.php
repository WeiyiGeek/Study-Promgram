<?php
	error_reporting(E_ALL & ~E_NOTICE);
	if(isset($_POST['sub']))
	{
		//用户提交后执行
		$num1 = $_POST['num1'];
		$num2 = $_POST['num2'];
		//这个是运算后的结果
		$result = "";
		$bz = true;

		//判断用户输入的数据
		if(($num1 == "") && ($num2 == ""))
		{
			$bz=false;
			echo "Error （1）: 输入框没有有效的数字";
		}else{
			if(!is_numeric($num1) && !is_numeric($num2)){
			$bz=false;
			echo "Error （2）: 不是有效的数字不能计算";
			}
		}
		//判断用户选择是那一个运算符号
		if($bz){
			switch($_POST['ysf']){
				case '+':
					$result=$num1 + $num2;
					break;
				case '-':
					$result=$num1 - $num2;
					break;
				case '*':
					$result=$num1 * $num2;
					break;
				case '/':
					$result=$num1 / $num2;
					break;
				case '%':
					$result=$num1 % $num2;
					break;
			}

		}
	}
?>
<html>
	<head>
		<title>简单计算器</title>
		<meta charset="utf-8"/>
	</head>
	<body>
		<table border="0" width="400" align="center">
		<form action="jsq.php" method="post">
			<caption><h4>简单计算器</h4></caption>
			<tr>
				<td><input type="text" size="8" name="num1" value="<?php echo $num1;?>" /><br></td> <!--设置长度size-->
				<td>	
					<select name="ysf">
						<!--采用三元运算符，判断提交后的符号从而进行选择-->
						<option <?php echo ($_POST['ysf']=='+')?"selected":"";?> value="+">+</option>  <!--这里也值得学习,和最后靠近?的不需要加;-->
						<option <?php echo ($_POST['ysf']=='-')?"selected":"";?> value="-">-</option>
						<option <?php echo ($_POST['ysf']=='*')?"selected":"";?> value="*">x</option>  <!--选入默认的运算符号-->
						<option <?php echo ($_POST['ysf']=='/')?"selected":"";?> value="/">/</option>
						<option <?php echo ($_POST['ysf']=='%')?"selected":"";?> value="%">%</option>
					</select>
				</td>
				<td><input type="text" size="8" name="num2" value="<?php echo $num2;?>" /><br></td>  <!--保留输入值值得学习-->
				<td><input type="submit" name="sub" value="计算"></td>
			<tr>
			<tr>
				<td colspan="4">
				<?php 
					if($bz){
						echo "计算表达式结果 ：{$num1}  ".$_POST['ysf']."  {$num2} = {$result}";
					}
				?>
				</td>
			</tr>
		</form>
		</table>
	</body>
</html>
