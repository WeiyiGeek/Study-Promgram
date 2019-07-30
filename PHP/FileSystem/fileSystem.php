<?php
/** 文件系统初始 */

//1.文件类型 （不建议采用）
echo "文件类型：".filetype("send_Server.html")."<br>";
echo "文件类型：".filetype("demo")."<br><hr>";

//2.第二种判断文件类型
echo is_file("send_Server.html")?"这是一个文件<br>":"这不是文件<br>";
echo is_dir("demo")?"这是一个目录<br>":"这不是目录<br>";
echo is_link("ultraiso.chm")?"Link<br>":"Windows下无法判断是否为link文件 - Not Link<br>";//Windows下无法判断是否为link文件
echo is_writable("send_Server.html")?"文件可写":"不可写";

?>