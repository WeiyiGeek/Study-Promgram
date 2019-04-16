#!/usr/bin/python
def test():
    """Stupid test timeit module function"""
    L = [i for i in range(1000)]

if __name__ == '__main__':
    import timeit   #导入模块
    t = timeit.Timer()
    try:
        print("执行时间：",end=" ")
        print(timeit.timeit(stmt="test()", setup="from __main__ import test",number=100))
    except Exception:
        print('异常抛出：')
        t.print_exc()


