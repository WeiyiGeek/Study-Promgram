<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>file and dirctory 操作处理</title>
</head>
<body>

    <fieldset>
        <legend>2.文件复制与移动</legend>
            <?php
                //2.文件目录移动重命名
                if(file_exists("demo")){
                    rename("demo1","demoDemo");
                }
                if(file_exists("demo.txt")){
                    rename("demo.txt","demoDemo.backup");
                }
                //封装成为函数目录的拷贝
                /** 
                 * $dirsrc  源 
                 * $dirto    目标
                */
                function copydir($dirsrc,$dirto){
                    if(file_exists($dirto)){
                        if(!is_dir($dirto)){
                            echo "<b style='color:red'>目标不是一个目录，不能COPY进去</b><br>";
                            exit();
                        }
                    }else{
                        mkdir($dirto);  //不存在则建立目录
                    }
                    $obj=opendir($dirsrc);
                    while($field = readdir($obj)){
                        //不要忘记判断. 与 ..
                       if($field != '.' && $field != ".."){
                        $srcfile=$dirsrc."/".$field; //源目录 很重要
                        $tofile=$dirto."/".$field;   //目标目录 很重要

                        if(is_dir($srcfile)){
                            copydir($srcfile,$tofile);
                        }else{
                            copy($srcfile,$tofile);
                        }
                       }
                    }
                    closedir($obj);
                    return "复制完成";                
                }
                echo copydir("demoDemo","demo");
            ?>
    </fieldset>

    <fieldset>
        <legend>1.文件目录建立删除</legend>
        <?php
            //1.文件与删除建立
            if(!file_exists("newDirctory")){
                mkdir("newDirctory",0644);
                echo "建立文件夹成功";
            }else{
                echo "文件夹已存在<br>";
                rmdir("newDirctory"); //注意只能删除空目录
                echo "文件夹已删除";
            }
            unlink("img.jpg"); //删除文件夹

            //遍历删除目录与文件
            function delfd($file){
                if(!file_exists($file)){
                    die("文件夹不存在");
                }
                if(is_file($file)){
                    unlink($file);
                }
                //重点来了
                $obj = opendir($file);
                while($field = readdir($obj)){
                    //Danger :必须要排除 . 与 ..
                    if($field != "." && $field != ".."){
                       $field = $file."/".$field;
                        if(is_dir($field)){
                            delfd($field);
                        }else{
                            unlink($field);
                            echo "已删除：${field}<br>";
                        }
                    }
                }
                closedir($obj);
                rmdir($file);
            }
            delfd("./phpMyadmin");
        ?>
    </fieldset>
</body>
</html>