#!/usr/bin/python3
#鸭子类型案例了解

class Duck:
    def quack(self): 
        print("Duck 类 呱呱呱！")
    def feathers(self): 
        print("Duck 类  这个鸭子拥有灰白灰白的羽毛。")

class Person:
    def quack(self):
        print("Person 类 你才是鸭子你们全家人是鸭子！")
    def feathers(self): 
        print("Person 类  这个人穿着一件鸭绒大衣。")

def in_the_forest(duck):
    duck.quack()
    duck.feathers()

#入口
def game():
    '''Duck Typing 类型测试'''
    donald = Duck()
    john = Person()
    in_the_forest(donald)  #实际动态调用了Duck类定义的方法
    in_the_forest(john)

print("###########",game.__doc__,"#################")
game()

########### Duck Typing 类型测试 #################
# Duck 类 呱呱呱！
# Duck 类  这个鸭子拥有灰白灰白的羽毛。
# Person 类 你才是鸭子你们全家人是鸭子！
# Person 类  这个人穿着一件鸭绒大衣。