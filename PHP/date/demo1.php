<?php
/***
 *  获取时间戳 1970-01-01 到现在的秒数 
 *  2014-02-14 11：11：11
 *  02/14/2014 11:11:11
 */


//当前时间戳
echo "Unix时间戳：".time();

$t = time()-60*60*24*7;
echo "<br/>7前天二十四小时得时间戳：".$t."<br/>";

//取得一个日期的 Unix 时间戳 2017/3/29 1:20:58
echo mktime(1,20,58,3,29,2017)."<br/>";

//返当前得时间戳
echo strtotime("now")."<br/>";
echo strtotime("2018-12-11 2:15:29")."<br/>";


//设置时间返回时间戳 （年月日 时-分-秒）
echo date("Y-m-d h:i:s",$t)."<br/>";

echo date("Y-m-d", strtotime("now"))."<br/>";                   //输出： 2018-11-12
echo date("Y-m-d", strtotime("8 may 2018"))."<br/>";       //输出： 2018-05-08
echo date("Y-m-d", strtotime("+1 day"))."<br/>";               //输出： 2018-11-13
echo date("Y-m-d", strtotime("next monday"))."<br/>";        //输出： 2018-11-19 (下周星期一 - 时间)


//生存时间
$cs = strtotime("1996-01-01 15:00:00");
echo "我生存的天数：".floor((time() - $cs)/(60*60*24))."天";


?>