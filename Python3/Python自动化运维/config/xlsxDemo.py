#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : xlsxDemo.py
# @CreateTime : 2019/7/25 15:37
# @Author : WeiyiGeek
# @Function : 
# @Software: PyCharm

import xlwt
def main():
    workbook = xlwt.Workbook(encoding='utf-8')  #创建workbook
    worksheet = workbook.add_sheet('sheet名称')  #创建workbook

    #从0开始插入
    worksheet.write(0, 0, 'Hello')  # write_string()
    worksheet.write(1, 0, 'World')  # write_string()
    worksheet.write(2, 0, 2)  # write_number()
    worksheet.write(3, 0, 3.00001)  # write_number()
    worksheet.write(4, 0, '=SIN(PI()/4)')  # write_formula()
    worksheet.write(5, 0, '')  # write_blank()
    worksheet.write(6, 0, None)  # write_blank()

    linenum = 7
    #采用二维数组确定为主,往单元格内写入内容
    worksheet.write(linenum, 0, "ID")
    worksheet.write(linenum, 1, "根域名")
    worksheet.write(linenum, 2, "绑定邮箱")
    worksheet.write(linenum, 3, "DNS服务器1")
    worksheet.write(linenum, 4, "DNS服务器2")
    worksheet.write(linenum, 5, "状态")

    #保存excel文档
    workbook.save('Excel_Workbook.xls')

    print("写入完成！")

if __name__ == '__main__':
    main()