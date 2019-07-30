<?php
/**
    parse_str ( string $encoded_string [, array &$result ] )进行url解析分成各个部分返回数组
    parse_url(string $url [, int $component = -1 ]) URL解析与将字符串解析成多个变量，返回数组
    string http_build_query ( mixed $query_data [, string $numeric_prefix [, string $arg_separator [, int $enc_type = PHP_QUERY_RFC1738 ]]] ) 
    //使用给出的关联（或下标）数组生成一个经过 URL-encode 的请求字符串。

 */
$url = "https://baijiahao.baidu.com/index.php?id=1620808880846125050&wfr=spider&for=pc";
$arrurl = parse_url($url); 
parse_str($arrurl['query'],$arr);  //解析请求参数利用key-value数组
echo $arrurl['query'];    //输出请求参数的url

echo "<pre>";
    print_r($arrurl);
    print_r($arr);
echo "</pre>";

$url = $arrurl['path']."?".http_build_query($arr);
echo "{$url}<br>";
echo "URLCODE():".urlencode($url);

?>