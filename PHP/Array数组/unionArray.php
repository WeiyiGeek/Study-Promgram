<?php

//二维输出的输出采用 list() each() while 联合遍历数组
$group = [
    "name"=>"第三组",
    "price"=>888,
    ["name"=>"zs", "age"=>20, "sex"=>"男", "email"=>"aaa@bbb.com"], 
    ["name"=>"ls", "age"=>21, "sex"=>"女", "email"=>"bbb@bbb.com"], 
    ["name"=>"ds", "age"=>25, "sex"=>"女", "email"=>"bbb@bbb.com"], 
    ["name"=>"js", "age"=>21, "sex"=>"女", "email"=>"bbb@bbb.com"], 
    ["name"=>"ws", "age"=>27, "sex"=>"女", "email"=>"bbb@bbb.com"]
];

echo '<table border="1" width="800" align="center">';
echo '<caption><h1> 联合遍历数组案例 </h1></caption>';
echo '<tr bgcolor="#DDD"><th> NAME </th><th> AGE </th><th> SEX </th><th> EMAIL </th></tr>';
while(list($key,$row) = each($group)){
    echo '<tr>';
    if(is_array($row)){
        while(list(,$col) = each($row)){
            echo '<td>'.$col.'</td>';
        }
    }else{
        echo '<td colspan="4">'.$key." => ".$row."</td>";
    }
    echo '</tr>';
}
echo '</table>';

   //声明一个一维的关联数组$contact
   $contact = array("ID" => 1,
   "姓名" => "高某",
   "公司" => "A公司",
   "地址" => "北京市",
   "电话" => "(010)98765432",
   "EMAIL" => "gao@brophp.com" 
);

//以HTML列表的方式输出数组中每个元素的信息
echo '<dl>一个联系人信息：';
while( list($key, $value) = each($contact) ){ //将foreach语句改写成while、list()和each()组合
echo "<dd> $key : $value </dd>";          //输出每个元素的键/值对
}
echo '</dl>';