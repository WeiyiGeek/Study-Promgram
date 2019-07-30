<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
</head>
<body>
    <?php
       if(isset($_POST['dosub']))
       {
           // PDO数据库配置文件
            try{
                $pdo = new PDO("mysql:host=localhost;dbname=demo","root","123456",array(PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION));
            }catch(PDOException $e){
                echo "<p>失败：{$e->getMessage()}</p>";
            die("数据库连接失败");
            }
            echo "ok";
            //防止注入
            $stmt = $pdo -> prepare("select id, username, allow_1, allow_2 from user where username=? and password=?");
            $stmt -> execute(array($_POST['username'],md5($_POST['password'])));

		   //如果查出数据，说明这个用户是存在的，就让登录
		   if($stmt->rowCount() > 0) {
			list($id, $username, $allow_1, $allow_2) = $stmt->fetch(PDO::FETCH_NUM);
			$time = time()+24*60*60;
			setCookie("uid", $id, $time, "/");
			setCookie("username", $username, $time, "/");
			setCookie("allow_1", $allow_1, $time, "/");
			setCookie("allow_2", $allow_2, $time, "/");
			setCookie("isLogin", 1, $time, "/"); 			//设置一个登录判断的标记isLogin
            header("Location:main.php");
                echo "登录成功";
		    } else {
			    echo "登录失败!";
		    }
        }

        if(isset($_COOKIE['isLogin']) && $_COOKIE['isLogin']==1)
        {
            header("Location:main.php");
        }

    ?>
    <form action="index.php" method="post">
        <label for="user">用户名：</label><input type="text" name="username" id="user"/><br>
        <label for="pass">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label><input type="password" name="password" id="pass"/><br>
        <input type="submit" value="登录" name="dosub">
    </form>
</body>
</html>