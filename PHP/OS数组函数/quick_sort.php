<?php
    /**二分法之快速排序 --> 分治 思想 递归**/

    $arr = [8,9,7,1,3,2,6,4,5,0];

    function quicksort($ar){
        //判断是不是数组或者为空都返回
        if(!(is_array($ar)) || empty($ar)){
            return $ar;
        }

        //判断里面的元素是不是只有一个
        $len = count($ar); //获取数组的长度
        if($len <= 1){

            return $ar;
        }

        //二分法快速排序算法开始
        $key[0] = $ar[0]; 
        $left = array(); //空数组对象
        $right = array();
    
        for($i = 1; $i < $len; $i++){  //注意这里由于key占用了ar[0]所以从1开始
            if($key[0] >= $ar[$i]){
                $left[] = $ar[$i];   //这里值得学习
            }else{
                $right[] = $ar[$i];
            }
        }

    
        echo "left：";
        print_r($left);
        echo "<br>";

        echo "right：";
        print_r($right);
        echo "<br><br>";
        $left = quicksort($left); //采用递归的思想
        $right = quicksort($right); //采用递归的思想


        //最后返回拼接的数组
        return array_merge($left,$key,$right);
    }


    $arrr =  quicksort($arr);
    echo "<pre>排序后的数组：<br>";
    print_r($arrr);
    echo "</pre>";

