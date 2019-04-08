#!/usr/bin/python3
#功能：数据序列化(二进制)

import pickle
import os

value = dict.fromkeys((1,2,3,5,6),'pickle')
print(value)
def pkldown(filename):
    if os.path.exists(filename):
        print("文件已经存在正在打开",end="")
        f = open(filename,'wb')
    else:
        f = open(filename,'wb')

    pickle.dump(value,f)
    f.close()

def pklget(filename):
    f = open(filename,'rb')
    getv = pickle.load(f)
    f.close()
    print(" %s " %getv)

pkldown('test.pkl')
pklget('test.pkl')
