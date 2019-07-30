<?php
/**
 *  htmlspecialchars  htmlentities(); //html编码
 *  strip_tags(); //特殊tag剔除
 *  stripslashes();
 *  addslashes($title)
 * 
 * 	nl2br();  //\n转换换行<br>
 * 
 */
	if(isset($_POST['dosubmit'])) {
		$title = $_POST['title'];
		echo htmlspecialchars($title,ENT_COMPAT)."<br>";
        echo htmlentities($title)."<br>";   //ascii实体编码
        echo strip_tags($title, "<b><u>")."<br>";  //需要保留的标记

        echo addslashes($title)."<br>"; //加入转义\
        echo stripslashes($title)."<br>";  //删除转义 \
		
		echo "<br><hr><br>";
		$str = "this is a string one，\n";
		$str .= "this is a string two，\n";
		$str .= "this is a string threr；\n";
		echo "常规输出 ：".$str;
		echo "将\n转换成<br>输出 : ".nl2br($str);
	}

?>
<br>
<form action="" method="post">
	title: <input type="text" name="title" value="" />
	<input type="submit" name="dosubmit"  value="提交" /><br>
</form>
<br><hr><br>
<?php

        $str = "<B>WebServer:</B> & 'Linux' & 'Apache'";    //常有HTML标记和单引号的字符串
            echo htmlentities($str, ENT_COMPAT);            //转换HTML标记和转换双引号
            echo "<br>\n";
            echo htmlentities($str, ENT_QUOTES);           //转换HTML标记和转换两种引号
            echo "<br>\n";
            echo htmlentities($str, ENT_NOQUOTES);      //转换HTML标记和不对引号转换
?>
