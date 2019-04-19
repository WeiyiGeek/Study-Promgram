import a

def y():
    print('y')

#使用 if __name__ == "__main__" 来确保 Python 不要在导入的过程中调用不该调用的函数
if __name__ == "__main__":
    a.x()