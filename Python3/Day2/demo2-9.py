#!/usr/bin/python3
#功能：文件系统

file = open('.//python.txt',mode='r+',encoding='utf-8')  #文件读取
print(file)
print(file.readlines())   #返回一个列表,文件指针指向末尾.
print("文件指针位置：",file.tell())


#修改文件指针指向初始位置
file.seek(0,0)
#文件读取
print("文件读取",file.read())

#用于截断文件并返回截断的字节长度,从第10个字节以后的内容全部删除了
file.seek(10)
file.truncate() 
file.seek(0,0)
print("读取行: %s" % (file.readlines()))

#关闭文件
file.close()

f = open("test.txt",'w+',encoding='utf-8')   
f.write("这是一个文件写入,为了不乱码需要指定utf-8编码")
f.writelines("文件写如一行字符串")
f.close()



