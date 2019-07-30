<?php
    /****
     * @function : 自定义一个函数名称为person,用于打印一个的属性
     * @param string $name  姓名-字符串 
     * @param int $age      年龄-整型
     * @param string $sex   性别-字符(常规用bool)
     * @param string $city  城市-默认参数重庆市
     * @param int $post_office 邮编-默认参数100086
     *
     *  @return string person()  //返回一个人的信息字符串
     */


     function person($name, $age, $sex, $city = "重庆", $post_office = "100086")
     {
         return $name."---".$age."---".$sex."---".$city."---".$post_office;
     }

    //使用默认参数
     echo "我的个人信息 ：".person("WeiyiGeek",18,"男")."<br>";

    //不使用默认参数则覆盖
     echo "我朋友信息 ：".person("Carry_You",18,"女","北京市",132465)."<br>";