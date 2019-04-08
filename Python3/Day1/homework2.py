#!/usr/bin/python3
#功能：课后作业04

count = input("请输入显示*号的个数:")
count = int(count)
while count:
    print(' ' * (count - 1),'*' * count)
    count = count - 1
else:
    print("打印结束")

