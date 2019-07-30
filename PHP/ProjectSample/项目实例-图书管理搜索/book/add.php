<?php 
    @include_once("header.php");
    @include_once("../function.inc.php");
    @include_once("../classes/fileupload.class.php");
    @include_once("../classes/image.class.php");

    if(isset($_POST['dosubmit'])){
        $bookname = $_POST['bookname'];
        $publisher = $_POST['publisher'];
        $author = $_POST['author'];
        $price = $_POST['bookprice'];
        $pic = upload("bookimg");
        if(!$pic)
        {   
            echo "文件上传失败";
            $pic = "fail.png";
        }
        $detail = $_POST['descr'];
        $sql = "insert into books(bookname,publisher,author,price,pic,detail,ptime) values('{$bookname}','{$publisher}','{$author}','{$price}','{$pic}','{$detail}',".time().")";
        echo "<br>".$sql."<br>";
        $res = $link->query($sql);
        if($res && ($link->affected_rows > 0)){
            echo "添加数据成功 <br>";
        }else{
            echo "添加失败<br>";
        }
    }
   

?>
<h3>添加图书</h3>
<form action="add.php" method="post" enctype="multipart/form-data" >
<label for="bookname">图书名称</label><input type="text" id="bookname" name="bookname"><br>
<label for="publisher">出版社</label><input type="text" id="publisher" name="publisher"><br>
<label for="author">作者</label><input type="text" name="author" id="author"><br>
<label for="bookprice">价格</label><input type="text" name="bookprice" id="bookprice"><br>
<label for="bookimg">图片</label><input type="file" name="bookimg" id="bookimg"><br>
<input type="hidden" name="MAX_FILE_SIZE" value="1000000" />
<label for="descr">描述</label><textarea name="descr" id="descr" cols="30" rows="5"></textarea><br>
<input type="submit" value="提交" name="dosubmit">
</form>
<?php include "footer.php"; ?> 