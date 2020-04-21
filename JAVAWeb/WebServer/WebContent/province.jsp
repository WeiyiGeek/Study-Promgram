<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>省市联动-解析XML实现</title>
<!-- Jquery 引入外部 JS -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
//jQuery
$(function(){
   //1.省份元素
   $("#province").change(function() {
      //2.选择的值进行请求该省份的城市数据
      var pid = $(this).val();
      $.post("CityServlet",{pid:pid} ,function(data,status){
        $("#msg").html("<pre>"+data+"</pre>");
		$("#city").html("<option value=''>-请选择-"); //先清空以前的值
		//遍历:从data数据里面找出所有的city,每次遍历就执行一次function方法;
	    $(data).each(function(index,c){
	        console.log("Index:"+index+", id:" + c.id + ", name" + c.cname);
			$("#city").append("<option value='"+c.id+"' >"+c.cname)
	    });
	},"json");
   });
    
});
</script>

省份: <select name="province" id ="province">
		<option value="" >-请选择 -
		<option value="1" >北京
		<option value="2" >上海
		<option value="3" >重庆
		<option value="4" >四川
		<option value="5" >西藏
	</select> &nbsp;
城市: 
	<select name="city" id="city">
		<option value="" >-请选择 -
	</select>
	
<div id="msg">
POST
</div>

</body>
</body>
</html>