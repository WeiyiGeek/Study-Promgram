<?php
//演示页面
include_once("memcache.php");

$_SESSION['TEST'] = 'TEST';
$_SESSION['AGE'] = 138;
echo "<pre>";
print_r($_SESSION);
echo "<pre><a href='logout.php'>exit</a><br>";