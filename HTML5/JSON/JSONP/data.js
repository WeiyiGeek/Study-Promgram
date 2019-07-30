var json = '{"name":"演示网站","site":"http://baidu.com"}';  //js对象字符串
document.write(json);
var jobj = JSON.parse(json);  //将js字符串转换成为 json
call_json(jobj);
