//采用ES6规范
const os = require('os')  //nodejs API
console.log(os.hostname)  //DESKTOP-OVF3TEN


//第三方模块使用
// const request = require('request')
// request({
//     url:'https://api.douban.com/v2/movie/top250',
//     json: true
// },(error,Response,body)=>{
//     console.log(JSON.stringify(body, null, 2))  //空白替换 / 2 表示缩进
// })


//自定义模块
const Demo = require('./src/greeting.js')
Demo()  //Hello ~


