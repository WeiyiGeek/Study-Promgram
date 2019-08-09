#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : execl.py
# @CreateTime : 2019/8/9 16:25
# @Author : WeiyiGeek
# @Function : 实验xlsxwriter模块的使用
# @Software: PyCharm

#!/usr/bin/env python
# coding=utf-8
import xlsxwriter
import datetime
import random

#创建一个新的Excel文件并添加工作表
workbook = xlsxwriter.Workbook('demo1.xlsx')     #创建工作簿

#创建一个新的工作簿
worksheet1 = workbook.add_worksheet()            #创建工作表 sheet1(默认表名称)
worksheet2 = workbook.add_worksheet('testSheet2') #创建工作表 testsheet2

#在工作表中创建一个新的格式对象来格式化单元格，实现加粗
bold = workbook.add_format({'bold': True})    #方式1
#bold = workbook.add_format();bold.set_bold()  #方式2


#数据写入到工作簿之中,注意：两种方式实际是一种只是别名而已可以采用 A1 和 (0,0) 方式定位
worksheet1.write('A1', 'Hello')        #总表写入简单文本
worksheet1.write_string(0,1, 'World')  #总表写入简单文本字符串类型数据

worksheet1.write('A2', 123.456)        #写入数字类型数据
worksheet1.write_number(1, 1, 123456)    #按照坐标写入

worksheet1.write('A3', None)             #写入空数据类型
worksheet1.write_blank(2,1, '')       #写入空数据类型

worksheet1.write('A4', '=SUM(A1:B2)')       #写入公式型数据
worksheet1.write_formula(3,1, '=SIN(PI()/4)')

worksheet1.write('A5', datetime.datetime.strptime('2019-08-09','%Y-%m-%d'),workbook.add_format({'num_format': 'yyyy-mm-dd'}))       #写入日期型数据
worksheet1.write_datetime(4,1, datetime.datetime.strptime('2019-08-09','%Y-%m-%d'),workbook.add_format({'num_format': 'yyyy-mm-dd'}))

worksheet1.write('A6', True)       #写入逻辑类型数据
worksheet1.write_boolean(5,1, False)

worksheet1.write('A7', 'http://baidu.com')         #写入超链接数据类型
worksheet1.write_url(6,1, 'http://www.python.org')


for i in [1, 2, 3, 4, 5]:
    worksheet2.write('A'+str(i), "重庆"+str(i))
    worksheet2.write('B'+str(i), random.randint(1, 100))



#设置一列或者多列单元属性
worksheet1.set_column(0, 1, 10, bold)   #设定列A到B单元格宽度10像素加粗
worksheet1.set_column('C:D', 20)  # 设置C到D单元格宽度20像素
worksheet1.set_column('E:G', None, None, {'hidden': 1}) #隐藏E到G单元格


#设置一行或者多行单元属性
worksheet1.set_row(0, 30, bold)   #设置都1行单元个高度30像素定义加粗
worksheet1.set_row(1, 30, workbook.add_format({'italic': True,'bold': True}))   #设置都1行单元个高度30像素定义斜体加粗
worksheet1.set_row(2, None, None, {'hidden': 1}) #隐藏第3行


#在第二个单元簿地单元格插入python-logo.png图片超链接为http://python.org
worksheet2.insert_image('A1', 'python-logo.jpg', {'url': 'http://python.org', 'width':'100',' height':'100'})
worksheet2.insert_image('A3', 'python-logo.jpg')   #插入图片


#Char类图表示例
chart = workbook.add_chart({'type': 'column'}) #创建一个column(柱形)图标

#为图表添加数据
chart.add_series({
    'categories': '=testSheet2!$A$1:$A$5',
    'values': '=testSheet2!$B$1:$B5',
    'line': {'color': 'red'},
})



#设置图表X轴显示
chart.set_x_axis({
    'name': 'x轴 描述 name',
    'name_font': {'size': 14, 'bold': True},
    'num_font': {'italic': True},
})

#设置x轴为数据表格式
chart.set_table()

#图表大小
chart.set_size({'width': 720, 'height': 576})
#图表标题
chart.set_title({'name':"Table Title Demo"})

#图表样式
chart.set_style(37)

#插入图表到工作簿中
worksheet2.insert_chart('A27', chart)

workbook.close()    #关闭工作薄orkbook.add_format({'num_format': 'yyyy-mm-dd'})