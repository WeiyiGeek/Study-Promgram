
#!/usr/bin/python3
#python3使用csv模块读写csv文件

import csv

#案例1：输出数据写入CSV文件
data = [
    ("Mike", "male", 24),
    ("Lee", "male", 26),
    ("Joy", "female", 22)
]

# data1 = [[x] for x in range(10) if x % 2 == 0]
data2 = ['测试','w','我是中文']  #字符间以,分割

#打开文件并设置模式用with打开可以不用去特意关闭file了
#Python3.4以后的新方式，解决空行问题
with open('demo.csv','w+',newline='',encoding='utf-8') as csvfile:
    # dialect为打开csv文件的方式，默认是excel，delimiter="\t"参数指写入的时候的分隔符
    csvwriter = csv.writer(csvfile,dialect=("excel"))
    for each in data:
        print(">>>",each)
        csvwriter.writerow(each)

    csvwriter.writerow(data2)  #'测试','w','我是中文' 追加一行


#案例2：打开csv文件读取数据
with open('demo.csv','r+',encoding='utf-8') as f:
    res = csv.reader(f)
    for x in res:
        print(x[0])