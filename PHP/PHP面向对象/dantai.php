<?php
/**
 *  1. 如果想让一个类,只能有一个对象,就要先让这个类,不能创建对象,将构造方法 private 关键字;
 *   2. 可以在类的内存使用一个静态方法，来创建对象;
 */

 class DB{
    private static $obj = null;
    static function createDb(){
         //如果第一次调用时,没有对象则创建, 以后调用时,直接使用第一次创建的对象
         if(is_null(self::$obj)){
            self::$obj = new self;   //self 代表自己的类
            //self::$obj = new DB;   //同样也可以
            echo "ok";
            return self::$obj;
        }else{
            echo "<p style='color:red'>申请对象失败！</p>";
        }
    } 
    public function query($sql){
        echo "sql标准查询语句 : <p>{$sql}</p>";
    }
}

$db = DB::createDb();  //只在第一次建立对象
$db->query('select * from mysql.user');

$dbconnet1 = DB::createDb();
?>