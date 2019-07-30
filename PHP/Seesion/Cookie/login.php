<?php
/** cookie 设置 */
date_default_timezone_set("PRC"); //注意时区问题
echo date("Y-m-d H:s:i",time())."<br>";
if(empty($_COOKIE))
{
    //只要使用setCookie()这个函数就可以将一个或多个变量放到客户端cookie中
    setcookie("user","admin",time()+60*60,"/","127.0.0.1",0,true); //设置cookie生效时间为1个小时，当前路径 / ，域名为当前机器，不必须使用https，httponly
    setcookie("pass",md5("123456"),time()+60*60);  //实际开发不建议这样写
    //还能存入数组到cookie中
    setcookie("info[age]",20,time()+60*60);
    setcookie("info[email]","test@test.com",time()+60*60);
    setCookie("arr[0]", 'aaaa', time()+60*60);    //关联与索引都能实现
	setCookie("arr[1]", "bbbb", time()+60*60);
    echo "Cookie 已设置!";
}
else
{
    echo "Cookie 已存在!<br><pre>";
    //所有客户端访问时自动将所有这个网站的cookie都代过来(全局数组)$_COOKIE
    print_r($_COOKIE);
    echo '</pre>首页:<input type="button" value="首页"  onclick="location.href=\'index.php\'"/>';

}
?>
