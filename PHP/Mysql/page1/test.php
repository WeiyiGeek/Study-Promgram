<?php
	header("Content-Type:text/html;charset=utf-8");
	//加载分页类
	include "page.class.php";

	//连接数据库选择一个库作用默认的库
	$link =new mysqli("localhost", "root", "123456","demo");
	if($link->connect_error)
		die("数据库连接失败!");


	//获取总记录数
	$result = $link->query("select count(*) as total from user");
	$data =  $result->fetch_assoc();
	//创建分页对象
	$page = new Page($data['total'], 10, "id=5", false);
	$page->set("prev", "|<<");  //可以设置显示文字在类中
	$page->set("next", ">>|");
	
	echo "当前页为：".$page->page."<br>";


	//执行SQL 获取显示的数据条目
	$sql = "select id,user,age,comment from user order by id {$page->limit}";

	echo $sql."<br>";
	$result = $link->query($sql);
	$arr = $result->fetch_row();


	echo '<table border="1" width="100%" align="center"  style="border:1px solid red">';
	echo '<caption><h5>USERS</h5></caption>';
	echo '<tr>';
	echo '<th>ID</th>';
	echo '<th>user</th>';
	echo '<th>AGE</th>';
	echo '<th>COMMENT</th>';
	echo '</tr>';

	while(list($id, $user, $age, $comment) = $res->fetch_row()) {
		echo '<tr>';
		echo "<td>{$id}</td>";
		echo "<td>{$user}</td>";
		echo "<td>{$age}</td>";
		echo "<td>{$comment}</td>";
		echo '</tr>';
	}
	//使用fpage()方法， 获取分页内容
	echo '<tr><td colspan="4" align="right">'.$page->fpage(3,4,5,6,7,0).'</td></tr>';
	echo '</table>';


	//关闭
	$result->close();
	$link->close();
