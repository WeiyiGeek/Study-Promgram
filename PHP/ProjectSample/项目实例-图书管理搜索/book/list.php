<?php

    @include_once("header.php");
    @include_once("../classes/page.class.php");

    $where = "";

    //@搜寻动作
    if(isset($_GET['action']) && $_GET['action'] == "search")
    {
        $tmp = !empty($_POST)? $_POST:$_GET;
        $whr = array();
        //查询条件不为空的时候
        if(!empty($tmp['bookname']))
        {
           $whr[] = "bookname like '%".$tmp['bookname']."%'";
        }

         //查询条件不为空的时候
         if(!empty($tmp['author']))
         {
            $whr[] = "author like '%".$tmp['author']."%'";
         }

          //查询条件不为空的时候
        if(!empty($tmp['minprice']))
        {
           $whr[] = "price >= ".$tmp['minprice'];
        }

         //查询条件不为空的时候
         if(!empty($tmp['maxprice']))
         {
            $whr[] = "price <= ".$tmp['maxprice'];
         }

         if(!empty($whr)){
            $where = " where ".implode(" and ",$whr);
         } 
         // 兼容 get 请求 (非常重要值得学习)
        $url = "action=search&".http_build_query($tmp);
    }

    //@删除动作
    if(isset($_GET['action']) && $_GET['action'] == "del")
    {
        if(!empty($_POST['id']))
        {
            //多条目删除
            $sql = "select pic from books where id in(".implode(',',$_POST['id']).")";
            $srcimg = ($link->query($sql))->fetch_all();
            //值得学习,将数组进行按字符分割
            $sql = "delete from books where id in(".implode(',',$_POST['id']).")";
        }else{
            $sql = "delete from books where id='{$_GET['id']}'";

        }
          echo "<br>$sql<br/>";
        $res = $link->query($sql);
        echo "<br>Affected rows (DELETE): $link->affected_rows <br>";
        if($res && $link->affected_rows > 0)
        {
            if(isset($_GET['img']) && !empty($_GET['img'])){
                @unlink("../uploads/{$_GET['img']}");
                @unlink("../uploads/th_{$_GET['img']}");
            }else{
                for($i = 0; $i < count($srcimg); $i++)
                {
                    echo $srcimg[$i][0]."<br>";  //删除多个书籍图片
                    @unlink("../uploads/{$srcimg[$i][0]}");
                    @unlink("../uploads/th_{$srcimg[$i][0]}");
                }
            }
            echo "<br>删除条目与图片成功";
        }else{
            echo "<br>删除失败";
        }
    }

    //@获取总记录数
    $res = $link->query("select count(*) as total from books $where");
    $cunt = $res->fetch_assoc();
    echo "<br>总条数：".$cunt['total']."<br>";

    //@创建分页对象
    $page = new Page($cunt['total'],$num,$url);

    $sql = "select id,bookname,publisher,author,price,pic,ptime from books {$where} order by id {$page->limit}";
    echo "<br>$sql<br/>";
    $res = $link->query($sql);
    echo "<hr><p>图书搜索:</p>";
    echo "<form action='list.php?action=search' method='POST'>";
    $html = '按书名:<input type="text" name="bookname" value="'.$tmp['bookname'].'"> &nbsp; 按作者：<input type="text" name="author" value="'.$tmp['author'].'"> &nbsp;&nbsp; 
    按价格：<input type="number" name="minprice" value="'.$tmp['minprice'].'"> - <input type="number" name="maxprice" value="'.$tmp['maxprice'].'">
    <input type="submit" value="搜索">
    ';
    echo "{$html}</form>";

    //需要添加表单(值得学习)
    echo '<hr><form action="list.php?action=del" method="post" onsubmit="return confirm(\'是否确定删除记录?\')">';
    echo "<table border='1' width='100%' style='border-spacing: 0px;border-collapse: collapse;'>";
    echo "<caption><h3>图片列表</h3></caption> ";
    echo "<tr style='color:#888'><th>选择</th><th>编号</th><th>图书名</th><th>出版社</th><th>作者</th><th>价格</th><th>添加时间</th><th>操作</th></tr>";
    while(list($id,$bookname,$publisher,$author,$price,$pic,$ptime) = $res->fetch_row())
    {
        echo '<tr><td><input type="checkbox" name="id[]" value="'.$id.'"></td>';
        echo "<td>{$id}</td>";
        echo "<td>{$bookname}</td>";
        echo "<td>{$publisher}</td>";
        echo "<td>{$author}</td>";
        echo "<td>￥".number_format($price,2,".",",")." 元</td>";
        echo "<td>".date("Y-m-d H:i:s",$ptime)."</td>";
        echo '<td><a href="mod.php?action=mod&id='.$id.'">修改</a>/
        <a onclick="return confirm(\'是否删除这本记录?\')" href="list.php?action=del&'.$url.'&page='.$page->page.'&id='.$id.'&img='.$pic.'">删除</a></td></tr>';
    }

    echo "<tr><td><input type='submit' value='删除'></td><td colspan='7' align='right'>{$page->fpage()}</td></tr><table></form>";
 
?>
<?php
        include "footer.php";
?>