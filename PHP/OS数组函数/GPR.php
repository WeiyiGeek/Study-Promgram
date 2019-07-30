<?php
echo "<pre>";
    echo "GET : ";
    var_dump($_GET);
    echo '<br>'."POST : ";
    var_dump($_POST);
    echo '<br>'."REQUEST : ";
    var_dump($_REQUEST);
echo "</pre>";


    /* 不能用全局变量作为函数的形参 */
    //function demo($_GET['name'], $_GET['age']){
    //    echo "{$_GET['name']} -- {$_GET['age']} ";
    // }

    //新特性
    /*
    <h1>Method 2 </h1>
    <form action="GPR.php?arr[]=zhangsan&arr[]=10" method="post"> 
        <input type="text" name="name[]">
        <br> 
        <input type="text" name="name[]">
        <br>
        <input type="submit" name="sub" value="提交">
    <form>
    */
?>