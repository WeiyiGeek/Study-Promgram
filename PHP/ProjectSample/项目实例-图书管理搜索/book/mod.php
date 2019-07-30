<?php 
    @include_once("header.php");
    @include_once("../function.inc.php");
    @include_once("../classes/fileupload.class.php");
    @include_once("../classes/image.class.php");

    //修改数据
    if(isset($_GET['action']) && ($_GET['action'] == 'mod'))
    {
        $sql = "select id,bookname,publisher,author,price,pic,detail from books where id=".$_GET['id'];
        
        $res = $link->query($sql);
        if($res->num_rows >= 1){
            echo "<p style='color:red'>查询成功</p>";
        }else{
            echo "<br><p style='color:white;background-color:red'>";
            die("无该条图书记录");
        }
        list($id,$bookname,$publisher,$author,$price,$pic,$detail)=$res->fetch_row();
    }

    //提交修改后的数据
    if(isset($_POST['dosubmit'])){
        $id = number_format($_POST['id']);
        $bookname = $_POST['bookname'];
        $publisher = $_POST['publisher'];
        $author = $_POST['author'];
        $price = $_POST['bookprice'];
        $detail = $_POST['descr'];
        //判断用户是否有上传的动作
        if($_FILES['bookimg']['error'] == 0)
        {
            $pic = upload('bookimg');
            if(!$pic){
                echo "上传失败";
                $sql1 = "update books set bookname='{$bookname}',publisher='{$publisher}',author='{$author}',price={$price},detail='{$detail}',modtime='".time()."' where id={$id}";
            }else{
                unlink("../uploads/{$_POST['srcimg']}");
                unlink("../uploads/th_{$_POST['srcimg']}");
                $sql1 = "update books set bookname='{$bookname}',publisher='{$publisher}',author='{$author}',price={$price},pic='{$pic}',detail='{$detail}',modtime='".time()."' where id={$id}";
            }
        }else{
            $sql1 = "update books set bookname='{$bookname}',publisher='{$publisher}',author='{$author}',price={$price},detail='{$detail}',modtime='".time()."' where id={$id}";
        }
       
        echo "<br>".$sql1."<br>";
        $res = $link->query($sql1);
        if($res && ($link->affected_rows > 0)){
            echo "修改添据成功 <br>";
        }else{
            echo "修改失败<br>";
        }
    }
   

?>
<h3>修改图书</h3>
<form action="mod.php?action=mod&id=<?php echo $_GET['id']?>" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<?php echo $id ?>" />
<label for="bookname">图书名称</label><input type="text" id="bookname" name="bookname" value="<?php echo $bookname ?>" /><br>
<label for="publisher">出版社</label><input type="text" id="publisher" name="publisher" value="<?php echo $publisher ?>" /><br>
<label for="author">作者</label><input type="text" name="author" id="author" value="<?php echo $author ?>" /><br>
<label for="bookprice">价格</label><input type="text" name="bookprice" id="bookprice" value="<?php echo $price ?>" /><br>
<div> 
<?php echo "<img src='../uploads/th_{$pic}' alt='图片图书' width='200' height='200'>" ?>
<input type="hidden" name="srcimg" value="<?php echo $pic?>" />
</div>
<label for="bookimg">图片</label><input type="file" name="bookimg" id="bookimg" value="<?php echo $pic ?>" /><br>
<label for="descr">描述</label><textarea name="descr" id="descr" cols="30" rows="5"><?php echo $detail ?></textarea><br>
<input type="submit" value="提交" name="dosubmit">
</form>
<?php include "footer.php"; ?> 