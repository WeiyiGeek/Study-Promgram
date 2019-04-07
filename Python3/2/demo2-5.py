#!/usr/bin/python3
#代码功能：全局与局部变量Variable

#msg 变量定义在 if 语句块中，但外部还是可以访问的
if True:
    msg = "I am from Weiyigeek"
print("\nmsg 变量定义在 if 语句块中，但外部还是可以访问的:",msg)

def discount(price,rate):
    final_price = price * rate   #局部变量
   # print("这里试图打印全局变量old_price的值(回报错):",old_price)
    local_price = 100    #定义在函数中,则它就是局部变量,外部不能访问
    print("局部变量local_price :",local_price)
    old_price = 50
    print("函数内修改后old_price的值是1 :",old_price)
    return final_price

old_price = float(input('请输入原价：'))
rate = float(input('请输入则扣率: '))
new_price = discount(old_price,rate)
print('函数外修改后的old_price的值是2 :',old_price)
print('打折后的价格 :',new_price)




