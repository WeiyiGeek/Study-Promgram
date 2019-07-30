<?php
/**  清除 cookie 页面 */
if(!empty($_COOKIE))
{
    //删除cookie也是使用setCookie()这个函数, 只要设置时间为以前或现在的时间,让这个变量在客户端过期就可以了， 这个变量客户端就用不了了.
    setcookie("user","",time()-3600,"/"); //注意不同目录建立的需要制定目录清除cookie 坑  
    setcookie("pass","",time()-3600);  
    setcookie("info[age]","",time()-3600);
    setcookie("info[email]","",time()-3600);
    setCookie("arr[0]", "", time()-3600);    //关联与索引 
	setCookie("arr[1]", "", time()-3600);
    echo "Cookie 已清除!";
}
else
{
    echo "Cookie 不存在，无法清除!<br><pre>";
    print_r($_COOKIE);
}

?>

