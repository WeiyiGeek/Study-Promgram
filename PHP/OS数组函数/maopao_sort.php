<?php
    //冒泡排序 之 php
    $arr1 = [0,11,2,32,4,52,16,78,8,9];
    echo "排序前的数组：";
    print_r($arr1);
//注意如果这里对进行&地址赋就是在原数组上排序,否则就是在新建立数组中排序需要return返回;
 function maopao_sort(&$arr){
    $arrLen = count($arr);
    //外层循环
    for($i = 0; $i < $arrLen - 1; $i++){
        //内层循环
        for($j = 0; $j < $arrLen - $i - 1; $j++){
            if($arr[$j] > $arr[$j+1]){
                $temp = $arr[$j];
                $arr[$j] = $arr[$j+1];
                $arr[$j+1] = $temp;
            }
        }
    }
    //return $arr;
 }   
   
    echo '<br>';
    echo "<pre>排序完成后的结果";
    maopao_sort($arr1); //我们支持采用在原数组上排序  
    print_r($arr1);  //输出我们的原数组
    echo "</pre>";
