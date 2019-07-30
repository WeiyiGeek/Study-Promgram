'use strict';

function addTest(){
  var a=2;
  var b=a++;
  console.log("a="+a+"  b="+b);
  var x=2,y;
  var y=++x;
  console.log("x="+x+"  y="+y);
};

function deCrement(){
  var a=2;
  var b=a--;
  console.log("a="+a+"   b="+b);

  var x=2;
  var y=--x;
  console.log("x="+x+"   y="+y);
};

function assignment(){

    var a = 8;
    var b = 6;
    console.log(a *= b);


    a = 8;
    b = 5;
    console.log(a %= b);

    a = 8;
    b = 5;
    console.log(a /= b);
}

function StrJoint(){
  var str = "Weiyi",str1 = "Geek",str2 = "Wrok:white Cap";
  console.log(str += str1);
  console.log(str+"\t"+str2);
}


function condition(){
  var age = prompt("请输入你的年龄:",18);
  var a = "成年",b = "未成年";
  var c = (age < 18)? b:a;
  console.log("你是："+c+"人");
}


function logic(){
  var a=2,b=3,x=6,y=7;
  console.log((a > b) || (x < y));
  console.log((a < 7) && (x < y));
  console.log(!(3 -2));

}

function BinOper(){
  var c = 5 & 1;   // 0101 & 0001 = 0001(1)
  console.log("& 位运算："+c);

  var c = 5 | 1;  // 0101 | 0001 = 0101(5)
  console.log("| 位运算："+c);

  // ~(0101) = 1[决定符号(1为-、0为+)]010= 101 + 001 (6)   =>> -6
  //补码=反码+1
  console.log("~ 取反位运算："+~5);

  var c = 5 ^ 1; //0101 ^ 0001 = 0100 (4)
  var c = 4 ^ 2; //0100 ^ 0010  = 0110 (6)
  var c = 5 ^ 2; //0101 ^ 0010 = 111 (7)异或 就是0/1就为1,，如果1/1或者0/0都为0
  console.log("^ 异或位运算："+c);

  var c = 2 << 2; //2 * (2^2)
  console.log("<< 左移位运算:"+c);

  var c = 8 >> 2; //8 / (2^2)
  console.log(">> 右移位运算:"+c);
}
