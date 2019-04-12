//hello.js文件就是一个模块，模块的名字就是文件名
'use strict';
var s = 'Hello';
function greet(name) {
    console.log(s + ', ' + name + '!');
}
module.exports = greet;  //直接暴露方法名 (注意这点)