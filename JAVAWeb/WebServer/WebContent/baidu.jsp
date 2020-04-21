<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>极客搜索</title>
<!-- Jquery 引入外部 JS -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
//Jquery使用方式之一
$(function(){
    $("#key").keyup(function(){
       $.post("SearchServlet",{words:$(this).val()},function(data,status){
           $("#result").show();
           $("#result").html(data);
       });
    });
});

//设置搜索关键字为查询得关键字
function setting(x){
    $("#key").val(x.innerText);
}

</script>
<div class="main" align="center">
	<h3>极客搜索</h3> <br>
	<input type="text" placeholder="搜索您想要的"  id="key" name="key" style="width:600px;height:25px"/> &nbsp; &nbsp;
	<input type="submit" value="极客搜索"/>
	<br>
	<div id="result" align="left" style="position:relative;left: -56px;border:1px solid black;display: none;width:600px;"></div>
</div>
</body>
</html>