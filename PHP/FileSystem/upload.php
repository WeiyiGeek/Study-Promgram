<?php
date_default_timezone_set("Asia/Chongqing");
/**
 * 文件上传demo
 */
echo "<pre>";
print_r($_POST);
 //注意表单enctype类型对于二进制文件上传到服务端脚本中的异同
print_r($_FILES);
echo "</pre>";


/*上传文件处理 */

/** 
//1.判断错误
if(($errnum = $_FILES['img']['error']) > 0){
    switch($errnum){
        case 1:
            echo "表示上传文件的大小超出了约定值";
            break;
        case 2:
            echo "表示上传文件大小超出了HTML表单隐藏域属性的MAX＿FILE＿SIZE元素所指定的最大值";
            break;
        case 3:
            echo "表示文件只被部分上传";
            break;
        case 4:
            echo "表示没有上传任何文件"; 
            break;
        default:
            echo "<p style='color:red'>未知错误</p>";
    }
    exit;
}

//判断类型
$hz = explode(".",basename($_FILES['img']['name']));
$allowtype = array("gif","png","jpg","jpeg");
if(!in_array($hz[1],$allowtype)){
    echo "上传类型不合法";
    exit;
}

//3.判断大小
$maxsize=1000000;
if($_FILES['img']['size'] > $maxsize){
    echo "上传的文件超过了,${maxsize}Byte！";
    exit;
}


//4.上传文件随机名
$upfiletmp = $_FILES['img']['tmp_name'];
$upfile = "./uploads/".date("YmdHis").rand(100,999).".".$hz[1];

//将上传到临时目录下的上传文件，复制到我指定的目录之下，指定的名字就可完成上传了
if(move_uploaded_file($upfiletmp,$upfile)){
    echo "文件上传成功";
}else{
    echo "文件上传失败";
}
*/
?>