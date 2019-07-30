<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>目录与文件操作实例</title>
</head>
<body>
    <fieldset>
        <legend>目录信息遍历</legend>
        
        <?php
                    $dir= "./phpMyAdmin";
        /*
            //1.glob()函数使用模式匹配 - 可以使用递归的方式
            $dir= "./phpMyAdmin";
            foreach(glob("./phpMyAdmin/*") as $key => $value){
                echo "++".$value."<br>";
                if(is_dir($value)){
                    foreach(glob($value."/*.php") as $key => $file){
                        echo "--".$file."<br>";
                    }
                }
                unset($file);
            }
            unset($value);
            echo '<br><hr><br>';
            //2.方法2进行遍历
                //打开目录 返回一个资源对象
            $dirobj = opendir($dir); 
                //如果读到底则返回false
            while($filename = readdir($dirobj)){
                if($filename != "." && $filename != ".."){
                    $filename = $dir."/".$filename;  //如果不加所有的都是文件
                    if(is_dir($filename)){
                        echo "目录：".$filename."<br>";
                    }else{
                        echo "文件：".$filename."  --- 文件时间创建".date("y/n/t H:i:s",filectime($filename))."<br>";

                    }
                }
            }
            echo "##########################################################<br>";
            rewinddir($dirobj);  //将资源指针从底部指向起始位置
            while($filename = readdir($dirobj)){
                if($filename != "." && $filename != ".."){
                    $filename = $dir."/".$filename;  //如果不加所有的都是文件
                    if(is_dir($filename)){
                        echo "目录：".$filename."<br>";
                    }else{
                        echo "文件：".$filename."  --- 文件时间创建".date("y/n/t H:i:s",filectime($filename))."<br>";

                    }
                }
            }

            closedir($dirobj); //关闭一个资源对象
            **/
         ?>
    </fieldset> 
    <fieldset>
            <legend>文件与目录遍历（递归）-统计目录与文件个数</legend>
            <?php
            //1.磁盘大小与可用空间
            $total = round(disk_total_space("/") / pow(2,30));
            $free = round(disk_free_space("/") / pow(2,30));

            echo "<b>当前系统根目录</b><br>空间总大小：".$total."GB<br>"."可用空间：".$free."GB<br>";
            //2.统计一个目录下的文件与字目录的个数
            $dircunt = 0;
            $filecunt = 0;

            //方便采用递归
            function getdircount($file){
                global $dircunt;
                global $filecunt;
                $dirsize = 0;
            
                $dirobj = opendir($file);
                while($field = readdir($dirobj)){
                    //过滤. 和 ..
                    if($field != "." && $field != "..")
                    {
                        //拼接路径（非常重要）
                        $field = $file.DIRECTORY_SEPARATOR.$field;
                        if(is_dir($field)){
                            $dircunt++;
                            $dirsize +=getdircount($field); //递归遍历
                        }else{
                            $filecunt++;
                            $dirsize += filesize($field);
                        }

                    }
                }
                closedir($dirobj);
                return $dirsize;
            }
            $size = round( getdircount($dir) / pow(1024,2),3);
            echo "<b>统计的目录".$dir."</b><br>目录数为:".$dircunt."个<br>文件数为:".$filecunt."个<br>目录大小：".$size."MB";
           ?>
    </fieldset>
           
</body>
</html>