<?php
    date_default_timezone_set("ETC/GMT-8");  //设置时区，中国大陆采用东八区的时间
    echo "当前时间 : ".date("Y-m-d H:i:s",time())."<br/>"; //通过date()函数获取当前时间，并输出

    $currentHour = date("H"); //获取当前小时
    if($currentHour < 6){    //下面这种从小到大的判断 (很值得学习,至少写写代码,不用进行判断逻辑语句范围 0 < $currentHour < 6)
        echo "Baby,凌晨好！";
    }elseif($currentHour < 9){
        echo "Nanla,早上好！";
    }elseif($currentHour < 12){  
        echo "maya,上午好！";
    }elseif($currentHour < 14){
        echo "bails,这是休息时间！";
    }elseif($currentHour < 17){
        echo "hellos.下午上班时间！";
    }elseif($currentHour < 19 ){
        echo "ε＝ε＝ε＝(#>д<)ﾉ,下班啦！！";
    }elseif($currentHour < 22){
        echo "彬彬,晚安哟！！";
    }else{
        echo "你正在梦乡里面！！！！";
    }

?>