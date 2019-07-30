<?php
/**
 * php 的 memcache 分布式 案例
 */

//1.对象申请
$mem = new Memcache;

//添加memcache服务器资源池
$mem->addServer("127.0.0.1",11213) or die("连接失败 11213 端口");
$mem->addServer("127.0.0.1",11211) or die("连接失败 11211 端口");
//判断是否在线（服务正常与否）
if($mem->getServerStatus("127.0.0.1",11213)){
    echo "Server1 服务器在线<br>";
}else{
    echo "服务器不在线<br>";
}

if($mem->getServerStatus("127.0.0.1",11211)){
    echo "Server2 服务器在线<br>";
}else{
    echo "服务器不在线<br>";
}

//添加数据
$mem->add("user","admin",MEMCACHE_COMPRESSED,0);
$mem->add("pass","admin",MEMCACHE_COMPRESSED,0);
$mem->add("age",24,MEMCACHE_COMPRESSED,0);
$mem->add("address","重庆市",MEMCACHE_COMPRESSED,0);
$date ="";
// memcache 与 mysql 数据进行转存
$sql = "select id,user,age from demo order by id";
$key = md5($sql);  //直接采用sql值作为键名 （为了程序的健壮性还需要进行md5转换长度都一样了）
$date = $mem->get($key);
echo $key;
//判断memcache中是否存在数据 如果用数据就从内容中返回数据， 如果没有才连接数据库，执行SQL语句
if(empty($date))
{
    //0.pdo对象申请
    try{
        $link = new PDO("mysql:host=localhost;dbname=demo",'root','123456',array(PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION));
    }catch(PDOException $e){
        echo "数据库连接失败".$e->getMessage();
        exit;
    }
    echo "数据库连接成功<br>";
    $stmt = $link->prepare($sql);
    $stmt->execute();
    $date = $stmt->fetchAll(PDO::FETCH_ASSOC);
    $mem->set($key,$date,MEMCACHE_COMPRESSED,60);  //60秒一更新
    echo "这是第一次访问从数据库获取的数据并放到了内存中!<br>";
}
echo "<pre>";
print_r($date);
echo "</pre>";

//2.释放对象
$mem->close();
?>
