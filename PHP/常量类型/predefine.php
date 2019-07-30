<?php
    //预定义常量,可以参考PHP manual document函数里面的基本都有预定义常量
    echo M_PI.'<br/>';
    echo M_LN10.'<br/>';

    //魔术常量,值不确定,随着环境变化而变化。
    echo __LINE__."行 ".__FILE__.'<br/>';
    echo "目录：".__dir__;
?>