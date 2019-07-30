<?php
//一维数组 - 索引
$arr = ["Weiyi","Geek","Like","Computer",1024];
foreach($arr as $value){
    echo "{$value} _ ";
}
echo "<br><br/>";

//一维数组 - 关联数组
$arr = array("one"=>"aa", "bb", "three"=>"cc", "dd", 9=>"ee", "ff", "four"=>"ggg", "hh");
foreach($arr as $kk => $vv) {
    echo "{$kk} ==> {$vv} <br>";
}


//二维数组 - 关联索引
$doubleArr = [
    "test"=>"www.qq.com",
    "text"=>1024,
    array("Weiyi","Geek","Like","Computer",1024),
    array("name"=>"Weiyi","job"=>"Geek","love"=>"Like","devices"=>"Computer",1024),
    ["Weiyi","Geek","Like","Computer",1024],
    ["name"=>"Weiyi","job"=>"Geek","love"=>"Like","devices"=>"Computer",1024],
];

echo "<table border='1' width='600' align='center'>";
echo "<caption><h1>This is a Tables person information</h1><caption>";
echo "<tr bgcolor='#ddd'><th>Name</th><th>Job</th><th>Like</th><th>devices</th><th>NUM</th></tr>";
foreach($doubleArr as  $value){  //相当于 doubleArr[0~3] 二维数组的大组
    if(is_array($value)){ //判断是不是数组
        echo "<tr>";
        foreach ($value as $key => $kvalue) {  //相当于doubleArr[0~3][0~5] (非常重要) 二维数组的小组
            echo "<td>".$key."=>".$kvalue."</td>";
        }
        echo "</tr>";
    }else{
        echo "<tr><td colspan='5' bgcolor='#DDF'>".$value."</tr></td>";
    }
  
}
echo "</table><br/>";
?>
<?php
    //三维数组 - 关联索引
     $wage = array(   //将三个部门的工资表格存储在三维数组$wage中
            "市场部" => array(array(1, "高某", "市场部经理", 5000.00),  
                              array(2, "洛某", "职员", 3000.00), 
                              array(3, "峰某", "职员", 2400.00)
                            ),

            "产品部" => array(array(1, "李某", "产品部经理", 6000.00),
                              array(2, "周某", "职员", 4000.00), 
                              array(3, "吴某", "职员", 3200.00)
                            ),

            "财务部" => array(array(1, "郑某", "财务部经理", 4500.00),
                              array(2, "王某", "职员", 2000.00), 
                              array(3, "冯某", "职员", 1500.00)
                            )
           );

    //使用三层foreach语句嵌套遍历三维数组,输出三个表格
    foreach( $wage as $sector => $table ) {  //最外层foreach语句遍历出三个表格，遍历出键和值
         echo '<table border="1" width="600" align="center">';
         echo '<caption><h2> '.$sector.'10月份工资表 </h2></caption>';  

         echo '<tr bgcolor="#dddddd"><th>编号</th><th>姓名</th><th>职务</th><th>工资</th></tr>';
         foreach( $table as $row ) {                 //中层foreach语句遍历出每个表格中的行
              echo '<tr>';
              foreach($row as $col) {                 //内层foreach语句遍历出每条记录中的列值
                  echo '<td> '.$col.' </td>';         
               }
               echo '</tr>';
          }
          echo '</table><br>';
      }
?>