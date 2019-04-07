#!/usr/bin/python3
#功能：函数参数

#/*不可变对象**/
def ChangeInt(a):
    a = 10
    print("(不可变)函数内：",a) #结果是 10

b = 2
ChangeInt(b)
print("(不可变)函数外：",b,end="\n\n") #结果是 2

#/*可变对象**/
def changeme(mylist):
    mylist.append([1,2,3,4])  #这时候传入列表已经被改变了
    print("(可变)函数内取值 :",mylist)  
    return
mlist = [6,6,6]
changeme(mlist)
print("(可变)函数外取值 :",mlist)  #列表已改变

#!/*** 可变参数(*) 与 关键字参数 **/
def test(*params,exp="weiyi"):
    print("参数长度 :",len(params)," 第二个参数：",params[1],"Name :",exp)
    for var in params:
        print(var,end=",")
    return 0

test(1,"爱您",1024,1,exp='weiyigeek')

#!/*** 可变参数(**) **/
def printmm(arg1,**vardict):
    '函数文档：形式参数为字典类型'
    print("\n\n输出 arg1：",arg1)
    print("输出 vardict 字典 :",vardict)

printmm('test',a=1,b=2,c=3)

#!/*** 单个星号的使用 **/
def star(a,b,*,c):
    print("a :",a ," b:",b ,' c:', c)

star(1,2,c=1024)  #c必须进行指定关键字传入值，否则会报错