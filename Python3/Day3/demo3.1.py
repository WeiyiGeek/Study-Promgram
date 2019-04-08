#!/usr/bin/python
#功能：实现脚本编程cmd参数输入
# import sys

# #/***方法1 sys 模块方式**/#
# print('参数个数为',len(sys.argv),'个参数')
# print('列表参数列表',str(sys.argv),"\n计算结果：",end="")
# add = 0
# for value in sys.argv:
#     if value == sys.argv[0]:
#         pass
#     else:
#         add += int(value)
# print(add)

#方法2：
import sys, getopt
def main(argv):
   inputfile = ''
   outputfile = ''
   try:
      opts, args = getopt.getopt(argv,"hi:o:",["ifile=","ofile="])
   except getopt.GetoptError:
      print ('test.py -i <inputfile> -o <outputfile>')
      sys.exit(2)
   for opt, arg in opts:
      if opt == '-h':
         print ('test.py -i <inputfile> -o <outputfile>')
         sys.exit()
      elif opt in ("-i", "--ifile"):
         inputfile = arg
      elif opt in ("-o", "--ofile"):
         outputfile = arg
   print ('输入的文件为：', inputfile)
   print ('输出的文件为：', outputfile)

if __name__ == "__main__":
   main(sys.argv[1:])