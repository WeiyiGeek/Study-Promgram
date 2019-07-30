<?php
/**
 *   存储读取|写入数据 
 */
try{
    $link = new PDO("mysql:host=localhost;dbname=demo","root","123456",array(PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION));
}catch(PDOException $e){
   // echo "ERROR";
    exit;
}
//get
if(isset($_GET['img']))
{
    $stmt = $link->prepare("select minetype, data from images where id=?");
    $stmt -> execute(array(2));
	list($mimetype, $data) = $stmt->fetch(PDO::FETCH_NUM);
	header("Content-Type: {$mimetype}");
	echo $data;  //注意是直接输出
}

//post
if(isset($_POST['dosub']))
{
$stmt = $link->prepare("insert into images(name,minetype,data) values(?,?,?)");
$stmt->bindParam(1,$_FILES['pic']['name']);
$stmt->bindParam(2,$_FILES['pic']['type']);
//直接使用文件资源就可以入库，而不用读出文件再插入
$fp = fopen($_FILES['pic']['tmp_name'], "rb");
$stmt->bindParam(3,$fp,PDO::PARAM_LOB);  //存取二进制数据
$stmt->execute();
print_r($_FILES);
echo "上传成功";
}

$str ='<form action="demo7.php" method="post" enctype="multipart/form-data">
	up pic: <input type="file" name="pic">
	<input type="submit"  name="dosub" value="up pic">
</form>';
echo $str;



?>