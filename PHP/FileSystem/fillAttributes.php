<?php
/**文件系统属性demo */
$filename = $_GET['name'];

function fileAttr($filename){
    //判断文件是不是存在
    if(file_exists($filename)){
        echo "文件或者文件夹存在:".$filename."<br>";
    }else{
        echo "文件或者文件夹不存在！<br>";
        die("请重新输入要显示的文件名！<br>");
    }

    //判断是目录还是文件夹以及其他类型
    fileTe($filename);

    //判断文件的权限（Linux下fileperms()）
    echo is_readable($filename)?"可读<br>":"不可读<br>";
    echo is_writable($filename)?"可写<br>":"不可写<br>";
    echo is_executable($filename)?"可执行<br>":"不可执行<br>";


    //文件大小
    echo filese($filename)."<br>";

    //文件的创建时间
    echo "Create: " . date ("m-d-Y H:i:s.", filectime($filename))."<br>";
    echo "Visit: " . date ("m-d-Y H:i:s.", fileatime($filename))."<br>";
    echo "last modified: " . date ("m-d-Y H:i:s.", filemtime($filename))."<br>";

    //判断文件所有者(Linux下有效)
    //echo "文件所有者：";
    //print_r(posix_getpwuid(fileowner($filename)));
}

//#判断文件或是目录的函数
function fileTe($filename){
    //我们可以获得block、char、dir、fifo、file、link和unknown七种类型。(为了适配Linux)
    $type = filetype($filename);
    switch ($type) {
        case 'dir':
            echo "This is a dirctory~<br>";
            break;
        case 'file':
             echo "This is a file~<br>";
            break;
        case 'char':
             echo "This is a char~<br>";
            break;
        case 'block':
             echo "This is a block~<br>";
            break;
        case 'fifo':
             echo "This is a fifo~<br>";
            break;
        case 'link':
             echo "This is a fifo~<br>";
            break;     
        default:
            echo "file is unknown~<br>";
            break;
    }
}

//文件大小（值得学习）
function filese($filename){
        $size = filesize($filename);
        if($size > pow(2,40)){
            $size /= pow(2,40);
            $dw = "TB";
        }elseif($size > pow(2,30)){
             $size /= pow(2,30);
             $dw = "GB";
        }elseif($size > pow(2,20)){
             $size /= pow(2,20);
             $dw = "MB";
        }elseif($size > pow(2,10)){
            $size /= pow(2,10);
            $dw = "KB";
        }else{
            $dw = "Bytes";
        }
        return $size."(".$dw.")"; 
}

//函数调用
fileAttr($filename);

//采用stat()数组获取文件属性(Linux推荐) - 不同文件系统对时间的判断方法可能是不相同的。
echo "<pre>";
print_r(stat($filename));
echo "</pre>";

?>