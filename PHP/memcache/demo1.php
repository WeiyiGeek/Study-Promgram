<?php
/**
 * php 连接 memcache 实例
 */

 $mem = new Memcache; //申请memcache对象
 $mem->connect('127.0.0.1',11211) or die("连接memcache服务器失败"); //连接memcache服务器
 echo "服务器状态：".$mem->getServerStatus('127.0.0.1', 11211)."<br>";
 echo "服务器版本：".$mem->getVersion();
 echo "<p>stats info:</p><pre>";
 print_r($mem->getStats());
 //可以存入一个类
 class value{
     public $a = 1;
     public $b = 2;
     public $c = 3;
 }
 //设置添加键值对
 $mem->add('one','hello world , Memcache!',MEMCACHE_COMPRESSED,time()+60*60*24*31);  //项memcache 服务器总添加一条数据
 $mem->add('two',array('w','e','i','y','i'),MEMCACHE_COMPRESSED,0);  //传入数组会自动序列化
 $mem->add('there',new value(),MEMCACHE_COMPRESSED,100);  //存入对象
 $mem->add('four',1024,MEMCACHE_COMPRESSED,300);    //存入数字
 $mem->set('one','hello world',MEMCACHE_COMPRESSED,0);  //更改键值对

 //获取键值对
 print_r($mem->get(array('one','two','there','four')));
 echo "</pre>";

 //删除键值对
 $mem->delete("one",20);  //十秒后删除one键值对
 $mem->flush();    //清空所有键值对

 $mem->close();  //关闭连接

?>