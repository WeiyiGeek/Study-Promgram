#!/usr/bin/python3
#递归求出最大公约数

def gcd(x,y):
    if y:
        return gcd(y, x % y)  #精辟呀
    else:
        return x

print(gcd(112,106))