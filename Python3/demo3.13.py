#!/usr/bin/python
#Desc：魔术方法反运算

#案例1：反运算符
class Newint(int):
    def __radd__(self, value): #反运算+
        return int.__sub__(value,self)  #方法1：执行为减，value self 顺序会影响到 谁是减数 / 被减数

    def __rsub__(self, value):  #反运算
        return super().__add__(value)  #方法2：执行为减 

    def __rmul__(self, value):
        return super().__truediv__(value)

a = Newint(5)
b = Newint(3)
print(a + b)  # 由于对象 a 可以支持 + / - , 所以不会触发反运算
print(a - b)  

# 由于 1 是非对象 则采用 b 的处理方法
print("1 + b =",1 + b)  #  1 - 3 => -2 由于改变了value,self顺序
print("1 - b =",1 - b)  # 触发反运算 =>  3 + 1 = 4 
print("1 * b =",5 * b)  # 触发反运算 => 3 / 5 = 0.6


#案例2：一元运算符
class OneInt(int):
    def __pos__(self):  #定义负号行为 -x
        return super().__pos__()  # -(self)

a = OneInt(-1)
print("-(a) =",-a) # -(-1)
