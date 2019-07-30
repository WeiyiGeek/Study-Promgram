<?php
    header("Content-Type: application/json;charset=utf-8");
    $jsonp = $_GET["callback"];
    if ($jsonp != "") {
      echo $jsonp . '({"success":false,"msg":"参数错误"})';
    }
?>
