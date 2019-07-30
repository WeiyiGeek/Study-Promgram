/*//XMLHttpRequest 对象
var xmlrequest;
if(window.XMLHttpRequest){
  xmlrequest=new XMLHttpRequest();  //CREATE NEW object
}else {
  xmlrequest=new ActvieXObject("Microsoft.XMLHTTP");
}


//XMLHttpRequest 请求
xmlrequest.open("GET","get.php",true);
xmlrequest.send();

xmlrequest.open("POST","get.php",true);
xmlrequest.setRequestHeader("Content-type","appliaction/x-www-form-urlencoded");
xmlrequest.send("name=Weigeek&age=18");

*/

function submitFun(){
  //XMLHttpRequest 响应
  var url=document.getElementsByName('urltest')[0].value;
  var result=document.getElementsByClassName('testdiv')[0];
  var request = new XMLHttpRequest();
      request.open('GET', url, true);
      request.send();
  //触发状态改变的事件 onreadystatechange
      request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
          result.innerHTML=request.responseText;
        }
      }
}
