<?php
    //字符串运算符 "."

    $html = '<html>'.'<body>'.'<h5>字符串运算符 "."</h5>'.'</body>'.'</html>';  //拼接网页代码
    echo $html;
    
    $a = "Weiyi";
    $a .= "Geek";
    var_dump($a);
    echo "<br/>拼接字符串：{$a}<br><br>";

    //使用三种方式进行输入拼接的字符串
    echo "My Name is ".$a."<br/>";
    echo "{$a} like Computer technology!<br/>";
    echo "Hacker ",$a," 爱好者<br><br>";  //不是拼接字符串而是三个参数

    //拼接字符串特别注意 "." 不能直接连接数值,但可以连接存放数值的变量名
    $num = 1024;
    //echo "这是一个拼接的数字：".1024;  会产生错误
    echo "这是一个拼接的数字：".$num."<br/>";

?>