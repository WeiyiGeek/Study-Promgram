<?php

    class action{
        //私有的访问修饰符 （只能类里面自我调用,外部不能调用整改）
        private $name1 = "张";
        private $name2 = "伟";
        private $num = 1022; 

        function __construct($name1, $name2, $num){
            echo "1.对象使用开始<br/>";
            $this->getNum($num);

            echo "预先 ：{$this->name1} {$this->name2} {$this->num}<br><br>";
            $this->name1 = $name1; //通过初始化 修改私有的访问修饰符
            $this->name2 = $name2;
            
        }

        //只能通过这个公开的访问修饰符方式来 调用使用私有的访问修饰符定义的方法或者属性
        public function run(){
            $this->left();
            $this->right();
            $this->go();
        }
        //封装性 （方法）-> 下面的函数将不被外部访问
        private function left(){
            echo "LEFT ";
        }
        private function right(){
            echo "RIGHT ";
        }
        private function go(){
            echo "GO ";
        }

        //封装性 （属性）
        function getNum($num){
            if(!($num >= 1024 && $num <= 2048)){
                return 0;
            }
            $this->num = $num;
        }

        function __destruct(){
            echo "<br><br>修改后 ：{$this->name1} {$this->name2} {$this->num}";
            echo "<br>3.对象使用结束<br>";
        }
    }

    $obj = new action("柳","维",2000);
    $obj->run();         //起保护方法的作者
    $obj->getNum(2048);  //起保护属性的作用

?>