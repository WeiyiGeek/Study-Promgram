<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>错误报告测试页面</title>
</head>
<body>
<p style="color:red">Error Report</p>
    <?php
        /**动态修改php.ini文件 */
        //ini_set("display_errors","On"); //显示所有错误信息
        //ini_set("error_reporting","E_ALL & ~E_DEPRECATED & ~E_STRICT");  //不会显示所有的错误信息

        /** 动态设置错误报告级别,默认都是显示全部的错误报告 */
        //error_reporting(error_reporting=E_ALL & ~E_DEPRECATED & ~E_STRICT); 
        error_reporting(E_ALL & ~E_NOTICE);   //不显示注意错误错误级别,其他都显示

        /*“注意(notice)”的报告，不会阻止脚本的执行，并且可能不一定是一个问题 */
        getType( $var );             //调用函数时提供的参数变量没有在之前声明
        echo "<p>Notice</p>";

        /*“警告(warning)”的报告，指示一个问题，但是不会阻止脚本的执行 */
        getType();                      //调用函数时没有提供必要的参数
        echo "<p>Warning</p>";
        
        /*“错误(error)”的报告，它会终止程序，脚本不会再向下执行 */
        get_Type();                     //调用一个没有被定义的函数
        echo "<p>Error</p>";
    ?>
</body>
</html>