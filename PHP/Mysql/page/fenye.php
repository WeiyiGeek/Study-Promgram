<?php
/***  分页demo **/
    header("Content-Type:text/html;charset=utf8");
    include_once("page.class.php");

    $dpage = new Page(98,10);
    echo $dpage->rpage(0,1,2,3,4,5,6);

?>