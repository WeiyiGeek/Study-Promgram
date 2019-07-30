'use strict';

function confirmTest(){
  var message = confirm('Do you Like Javascritp?');
  if(message == true){
  	console.log('是的，我很喜欢Javascript！');
  }else{
  	console.log('我一点也不喜欢Javascript！');
  }
}

function promptTest(){
  var score = prompt('请输入你的成绩:',100);
  if (score >= 60) {
    console.log("你的成绩为 "+score+" 分,已达到及格线！");
  } else {
    console.log("对不起,你的成绩为 "+score+" 分,未达到及格线!");
  }
}

function displayDate(){
  document.getElementById('demo').innerHTML=Date();
}

function textLength(){
  var string = prompt('请输入串字符',);
  console.log("字符长度为："+string.length);
}

function newTest(){
  var x = "John";
  var y = new String("John");
  var z = new Array('test','weiye');
  document.getElementById('newT').innerHTML="x的typeof："+typeof x+"<br/>y的typeof："+typeof y;
  console.log(typeof z+"\nz[0]="+z[0]+"\nz[1]="+z[1]);
}
