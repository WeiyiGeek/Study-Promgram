def c2f(cel):
    '''摄氏度转华氏度'''
    fah = cel * 1.8 + 32
    return fah

def f2c(fah):
    '''华氏度转摄氏度'''   
    cel = (fah - 32) / 1.8
    return cel

def test():
    print("测试 0 C = 0.2f F", c2f(0))
    print("测试 0 F = 0.2f C", c2f(0))


#让Python知道是运行还是导入到模块

if __name__ == '__main__':  #只有在自身模块文件内才执行test()
    print("__name__ 在主程序中显示的是该模块名称, 如果在定义声明文件中执行则显示main : ",__name__)   #在本程序中显示的是main
    test() 