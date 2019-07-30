<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>demo 3 | 文件基本操作处理（重要）</title>
</head>
<body >
    <?php
    /*
        //1.文件内容基础操作
        $arr = file("text.txt");
        echo "test.txt文件行数：".count($arr)."<br>";
        print_r($arr);

        //本地文件的争取整存
        file_put_contents("text.txt","PHP是一门最好的语言！");
        echo file_get_contents("text.txt");

        //远程文件网页进行写入到文件
        file_put_contents("baidu.html",file_get_contents("https://baidu.com"));  
        //读取文件内容或者网页内容进行输出
        readfile("baidu.txt");
        echo file_get_contents("http://soso.com");
    */
        //2.文件打开与关闭
        $fp = fopen("text.txt","r+t");  //注意mode如果是w+或者w都将覆盖内容
        echo "资源类型：";
        var_dump($fp);

        //指针位置
        echo "当前文件指针位置：".ftell($fp)."<br>";
        //更改指针指向位置
        fseek($fp,5);
        echo "fseek后文件指针位置：".ftell($fp)."<br>";
        fseek($fp,0);

        echo "<br>截取字符数(中文占3字节)：";
        file_put_contents("text.txt","PHP中文三生三世实时");

        //读取字符串
        echo fread($fp,filesize("text.txt"))." --- ";       
        ftruncate($fp,9);

        @rewind($fp);  //重新指向资源头部
        echo fread($fp,filesize("text.txt"))."<br><hr><br>";

        //写入字符串
        fwrite($fp,"1.是写入的内容\n2.换行后的内容\n3.再次换行");  //r+t 如果是文本模式t,则\n为兼容windows\r\n换行
        @rewind($fp);  //重新指向文件指针初始地址
        while(!feof($fp)){
            echo fread($fp,filesize("text.txt"));  //遇到换行默认为结束读取（所以需要多个fread进行读取）
        }

        echo "<br><hr><br>";
        //读取一个字符
        @rewind($fp);
        while(!feof($fp)){
            echo fgetc($fp);
        }

        echo "<br><hr><br>";
        //读取一行字符串（也是默认以换行结尾）
        @rewind($fp);
        while(!feof($fp)){
            echo fgets($fp);
        }
    
        //截取后两位中文字符
        fseek($fp,-6,SEEK_END);
        echo "<br><hr><p style='color:red'>文件中截取的后两位字符：".fgets($fp);
        fclose($fp);  //关闭
    ?>
</body>
</html>