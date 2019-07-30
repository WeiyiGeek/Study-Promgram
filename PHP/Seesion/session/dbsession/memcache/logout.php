<?php

include_once("memcache.php");

//清空session
$_SESSION=array();

//销毁session
session_destroy();

echo "ok";