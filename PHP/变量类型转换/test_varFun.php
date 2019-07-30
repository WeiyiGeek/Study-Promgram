<?php
    $boole = True;
    if(is_bool($boole)){
        echo "<b style='color:green'>Boolean类型</b><br>";
    }else{
        echo "<b style='color:red'>非Boolean类型</b>";
    }

    $int = "1024 hello World PHP!";
    if(is_numeric($int)){
        echo "<b style='color:green'>数字和数字字符串类型</b>";
    }else{
        echo "<b style='color:red'>非数字和数字字符串类型</b>";
    }

?>