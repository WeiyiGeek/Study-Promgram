<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>留言板本</title>
</head>
<body>
<form action="message.php" method="post">
    <label for="username">用户：</label><input type="text" id="username" name="username" autocompele=""><br>
    <label for="title">标题：</label><input type="text" id="title" name="title"><br>
    <label for="contents">内容：</label><textarea name="contents" id="contents" cols="30" rows="5"></textarea><br>
    <input type="submit" value="提交" name="sub">
</form>
<?php
    /***
     * php 记事本的实现
     */
    date_default_timezone_set("Asia/Chongqing");  //注意时区的设置
    header("Content-Type:text/html;charset:utf-8");
    $filename = "message.txt";
    if(isset($_POST['sub']) && !empty($_POST['username'])){
        //字符分割使用||换行使用[n]
        $mess = "{$_POST['username']}|{$_POST['title']}|{$_POST['contents']}|".time()."[n]";
        writeMessage($filename,$mess);
       
    }

    function writeMessage($filename,$mess){
        $fp = fopen($filename,"a+");
        //采用文件锁机制防止文件读写出问题
        $fp = fopen($filename, "a");
        //写加锁
		if(flock($fp, LOCK_EX+LOCK_NB)) { 
			fwrite($fp, $mess);
			flock($fp, LOCK_UN+LOCK_NB);  //解锁
		}
        else
        {
			echo "写入锁定失败!";
		}
        echo '<script>alert("提交成功");window.location="./message.php"</script>';
        fclose($fp);
    }

    function readMessage($filename){
        $mess = "";
		$fp = fopen($filename, "r");
		flock($fp, LOCK_SH+LOCK_NB);  //读锁定
		while(!feof($fp)) {
			$mess.=fread($fp, 1024);
		}
		flock($fp, LOCK_UN+LOCK_NB);  //释放
        $mess = rtrim($mess,"[n]");  //如果是两行去掉最后一个[n] 防止2行数据分成3行
        $arr = explode("[n]",$mess);  //进行分割
        foreach($arr as $key => $value){
            list($username,$title,$content,$subtime) = explode("|",$value);
            echo "提交时间：".date("Y-m-d H:i:s",$subtime)." 用户：<b>".$username."</b> 标题：".$title."<i> 内容：".$content."</i><hr>";
        }
    }
    readMessage("message.txt");
?>
</body>
</html>