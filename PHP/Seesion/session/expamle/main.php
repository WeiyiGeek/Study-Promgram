<?php
    include_once("./config.ini.php");  //包含配置文件
    //判断用户是否登录
    if(!(isset($_SESSION['isLogin']) && $_SESSION['isLogin'] === 1)){
        header("Location:login.php");  //用户没登录跳转
    } 

    echo "你好:".htmlspecialchars($_SESSION['username'])." 用户 , <a href='logout.php'>退出</a><br>";

    if($_SESSION['allow_1'] == 1){
        echo "您有查看浏览的权限 <br>";
    }else{
        echo "您 没有 查看浏览的权限<br>";
    }

    if($_SESSION['allow_2'] == 1){
        echo "您有修改删除的权限<br>";
    }else{
        echo "您 没有 修改删除的权限<br>";
    }

    //邮件查询
    $stmt = $link->prepare("select id,title,ptime,content from email where uid = ? order by id desc");
    $stmt -> bindParam(1,$_SESSION['id'], PDO::PARAM_INT);
    $stmt -> execute();
    $count = $stmt->rowCount();
    if($count > 0 ){
        echo "亲爱哒".htmlspecialchars($_SESSION['username']).",你有".$count."封邮件信息！<br>";
        echo "<h6>邮件信息</h6>
                <table border='1'>
                <tr><th>ID</th><th>时间</th><th>标题</th><th>内容</th></tr>";
        while(list($id,$title,$ptime,$content) = $stmt->fetch(PDO::FETCH_NUM))
        {
            echo "<tr><td>$id</td><td>".date("Y-m-d H:i:s",$ptime)."</td><td>$title</td><td>$content</td></tr>";
        }
        echo  "</table>";

    }else{
        echo "不存在任何邮件";
    }
