<?php
/***
 * 这个类是一个圆形类，这个安装shaoe这个抽象类去写
 * 是抽象类的扩展
 */

class Circle extends Shape{
    private $radius;

    function __construct($arr = array()){
        if(!empty($arr)){
            $this->radius = $arr['radius'];
        }
        $this->name="圆形";
    }

    function area(){
        return M_PI*pow($this->radius,2);
    }
    
    function zhou(){
        return 2*M_PI*$this->radius;
    }

    function view(){
        $form = '<form action="index.php?action=circle" method="post" >';
        $form .= $this->name."的半径：<input type='number' name='radius' value=".$_POST['radius']." /><br>";
        $form .= '<input type="submit" name="dosubmit" value="计算"/><br>';
        echo $form;
    }

    function yan($arr){
        $flag = true;
        if($arr['radius'] <= 0)
        {
            echo $this->radius."的半径不能小于等于0<br>";
            $flag = false;
        }
        return $flag;
    }

}
?>