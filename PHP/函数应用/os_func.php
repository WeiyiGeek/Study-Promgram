<?php
    /***
     * function ：判断文件夹里面的那些是文件那些是目录
     * @param : 需要显示文件的文件夹
     */
    header("Content-Type: text/html; charset=gb2312");

    function showDir($dirpath){
		$dir = opendir($dirpath);   //打开目录资源 （重要）
        readdir($dir);              // ".." 上级目录 这里使用是为了过滤非文件或文件夹
        readdir($dir);              // "." 本级目录
        while(($file = readdir($dir))){
            $file = $dirpath.'/'.$file;     //非常注意需要添加上目录路径(由于我在下面这个文件夹里面)
            if(is_dir($file)){
                echo "目录 ：{$file} <br>";
                showDir($file);         //采用了递归函数,打印目录下的其他的文件夹
            }else{
                echo "文件 ：{$file} <br>";
            }
        }
        closedir($dir); //关闭打开的目录资源 （重要）
    }
    showDir($_GET['path']);     //存在目录泄露的漏洞
