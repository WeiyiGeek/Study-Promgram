#!/usr/bin/python3
#文件操作

filename = input("请输入一个文件名：")
f = open(filename,'x',encoding='utf-8')
list1 = []
print(r'"请输入内容,单独输入\'：w\'保存："')
while True:
    value = input()
    if  value != ":w":
        list1.append(value+"\n")
    else:
        # for each in list1:
        f.writelines(list1)
    
        f.close()  #关闭文件
        break
    