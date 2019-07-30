<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>自定义错误级别</title>
</head>
<body>
<p style="color:red">Custome Error Report</p>
    <?php
        /**自定义错误级别 */
        $msge = "";
        //值得学习:
        function error_level($level,$msg,$file,$line){
            global $msge;
            $err_type = "";  //存放错误信息
            $err = FALSE;
            switch ($level) {
                case E_NOTICE:
                case E_USER_NOTICE:
                    $err_type = "NOTICE";
                    $err = TRUE;
                    break;
                case E_WARNING:
                case E_USER_WARNING:
                    $err_type = "Waning";
                    break;

                case E_ERROR;  //无效的对应handler（）
                case E_USER_ERROR;
                    $err_type = "ERROR";
                    break;
                default:
                    $err_type = "Unknown";
                    break;
            }

            //直接打印错误信息，也可以写文件或数据库
             //printf ("<font color='#FF0000'><b>%s</b></font>: %s in <b>%s</b> on line <b>%d</b><br>\n", $err_type, $msg, $file, $line);
           $msge .= "<font color='#FF0000'><b>$err_type</b>  - </font>: $msg  -- in <b>$file</b> on line <b>$line</b><br>";


            //若出现非错误则跳转到友好错误提示页面
            if(TRUE === $err) {
              echo '<script>alert("页面存在提示");</script>';
            }
        }

        error_reporting(0);         //屏蔽程序中的错误
        /**这个才是关键点，把错误的处理交给error_handler()*/
        set_error_handler("error_level");

        /*“注意(notice)”的报告，不会阻止脚本的执行，并且可能不一定是一个问题 */
        getType($var);             //调用函数时提供的参数变量没有在之前声明
        echo "<p>Notice</p>";

        /*“警告(warning)”的报告，指示一个问题，但是不会阻止脚本的执行 */
        getType();                      //调用函数时没有提供必要的参数
        echo "<p>Warning</p>";
        
        /* 用户错误提示 */
        if(3/0){
         trigger_error('Trigger_error 自定义Message', E_USER_ERROR); //自定义一个错误
        }
        /** 打印出自定义错误*/
        echo $msge;

        /*“错误(error)”的报告，它会终止程序，脚本不会再向下执行 */
        get_Type();                     //调用一个没有被定义的函数
        echo "<p>Error</p>";
    ?>

</body>
</html>