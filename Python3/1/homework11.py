#!/usr/bin/python3
#编写一个函数 findstr()，该函数统计一个长度为 2 的子字符串在另一个字符串中出现的次数。
# 例如：假定输入的字符串为“You cannot improve your past, but you can improve your future. Once time is wasted, life is wasted.”，
# 子字符串为“im”，函数执行后打印“子字母串在目标字符串中共出现 3 次”。

def findstr1():
    string = "You cannot improve your past, but you can improve your future. Once time is wasted, life is wasted."
    temp = input("请输入字符串：")
    if temp.isspace() or len(temp) <= 2:
        temp = string
    temp1 = input("输入查找的字符串(两个以上)：")

    while len(temp1) < 2:
        temp1 = input("查找字符长度有误,请重新输入：")

    print(temp.count(temp1))

findstr1()