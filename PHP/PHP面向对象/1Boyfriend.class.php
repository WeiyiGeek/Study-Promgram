<?php
    /***
     *  对象女朋友
     *  属性： 性别, 年龄, 身高, 眼睛;
     *  行为:  做饭 , 做家务;
     *  注意：在类的成员的属性前面一定要又一个修饰词,如果不知道使用什么的修饰词（var（过时） / public(常规)）
     **/
    //创建一个BoyFirend的类型

    class BoyFriend {
        //变量(成员属性) 
        var $name = "zhaobinbin";
        public $age = 23;
        public $sex = "Gril";
        public $height = "165cm";
        public $eye = "big";

        //函数(成员方法)
        public function cookFun($rou, $cai){
            return "做饭功能";
        }

        public function actionFun(){
            return "做家务功能";
        }

    }

     //new 关键字 ->  通过类创建对象
     $obj1 = new BoyFriend;
     $obj1->name = "PHP";  //可修改对象里面的属性
     $obj1->age = 100;  //可修改对象里面的属性
     echo "Obj1 Name : ".$obj1->name."<br>";
     echo "Obj1 Age : ".$obj1->age."<br><br>";

     $obj2 = new BoyFriend();
     //访问属性
     echo "Obj2 Name : ".$obj2->name."<br>";
     echo "Obj2 sex : ".$obj2->sex."<br>";
     echo "Obj2 AGE : ".$obj2->age."<br><br>";

     //访问方法
    echo $obj1->cookFun("肉丝","白菜")."<br>";
    echo $obj2->actionFun();

?>