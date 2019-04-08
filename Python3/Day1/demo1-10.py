#!/usr/bin/python3
#coding:utf-8
#功能:分支与循环
#-----------if 语句-----------------
guess = 8
temp = int(input("请输入一个1-10数值:"))
if guess == temp:
    print("恭喜您,输入的数值刚好")
elif guess > temp:
    print("太遗憾了,输入的数值小于它")
else:
    print("太遗憾了,输入的数值大于它")

x,y = 1,3
print("#三元运算符 ：",end="")
print( x if x > 3 else y )


#------------while 语句---------------
# Fibonacci series: 斐波纳契数列 （两个元素的总和确定了下一个数）
a,b = 0,1
while b < 10:
    print(b,end=",")
    a,b = b, a+b
print("\n\n")   


#------------for 语句---------------
for i in "python":
	print(i,end="|")  #依次打印字母并以 | 分割
print()   

sites = ["baidu","Google","Runoob","taobao"]
for i in sites:
    print(i,end=",")       #打印出列表的值
print()   

for i in range(len(sites)):  #或列表的长度 4 生成(0 - 3);
    print(i,sites[i],len(sites[i]))  #索引,列表中以索引下标的元素,元素的长度

print()   
#查询是否为质数 2 - 10 那些是质数
for x in range(2,10):
    for y in range(2,x):
        if x % y == 0:
            print(x,'等于',y , '*', x // y)
            break
    else:
        #循环中找到元素,它在穷尽列表(以for循环)或条件变为 false (以while循环)导致循环终止时被执行,但循环被break终止时不执行。 
        print(x,'是质数')
