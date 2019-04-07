#!/usr/bin/python3
#coding:utf-8
#原理：文件系统

#/****案例1：文件内容遍历***/
file = open('python.txt','r+',encoding='utf-8')
#不建议使用下面的方式进行输出文件中的内容;
# file.seek(0,0)
# lines = list(file)
# for eachline in lines:
#     print(eachline,end="")

# print("\n")

print("文件描述符为: %d" %file.fileno())
print("是否连接到一个终端设备",file.isatty())

#替代的方法直接采用文件对象方式（推荐）
file.seek(0,0)
for eachline in file:
    print(eachline,end="")
file.close()


#/**** 案例2:文件内容分割  ***/
# def save_file(boy,girl,count):
#     file_name_boy = 'boy_'+str(count)+'.txt'
#     file_name_girl = 'girl_'+str(count)+'.txt'

#     afile = open(file_name_boy,'w',encoding='utf-8')
#     bfile = open(file_name_girl,'w',encoding='utf-8')

#     afile.writelines(girl)
#     bfile.writelines(boy)

#     afile.close()
#     bfile.close()


# def split_file(filename):
#     f = open(filename,'r',encoding='utf-8')
#     Aauthor = []
#     Bauthor = []
#     count = 1
#     for lines in f:
#         if lines[:6] != '======':
#             (role,spoken) = lines.split(':')
#             if role == 'A':
#                 Aauthor.append(spoken) #列表添加
#             elif role == 'B':
#                 Bauthor.append(spoken)
#         else:
#             save_file(Bauthor,Aauthor,count)
#             #重新将A/B置为空列表
#             Aauthor = []
#             Bauthor = []
#             count += 1

#     save_file(Bauthor,Aauthor,count)
#     f.close()

# split_file('demo2-10.txt')