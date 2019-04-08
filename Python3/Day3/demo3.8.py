#!/usr/bin/python3
#功能：模拟Stack（栈）

class Stack:
    def __init__(self,start = []):
        self.stack = []
        for i in start:
            self.push(i)  #压栈
    #判断当前栈是否为空（返回 True 或 False）
    def isEmpty(self):
        return not self.stack

    #往栈的顶部压入一个数据项
    def push(self,obj):
        self.stack.append(obj)

    #从栈顶弹出一个数据项（并在栈中删除）
    def pop(self):
        if not self.stack:
            print('警告, Stack 已空！')
        else:
            self.stack.pop()  #弹栈

    #显示当前栈顶的一个数据项
    def top(self):
        if not self.stack:
            print('警告, Stack 已空！')
        else:
            return self.stack[-1]  #显示栈顶

    #显示当前栈底的一个数据项
    def bottom(self):
        if not self.stack:
            print('警告, Stack 已空！')
        else:
            return self.stack[0]

demo = Stack([1,2,3,4,5])
print(demo.top(),demo.bottom())  #显示栈顶/栈底