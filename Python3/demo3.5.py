#!/usr/bin/python3
#实例化对象和类型

#案例1：单继承示例
#父类
class Person:
    name = ''     #定义基本属性
    __UID = 0     #私有属性
    #魔术方法
    def __init__(self, *args):
        self.name = args[0]
        self.__UID = args[1]
    #类方法
    def speak(self):
        print("%s 的身份证号为 %d" %(self.name,self.__UID))

#子类
class Student(Person):
    grade = ''
    def __init__(self, *args):
        #调用父类的构造函数
        Person.__init__(self,args[0],args[1])
        self.grade = args[2]
    #填写覆盖父类的speak方法
    def speak(self):
        print("姓名： %s , 年级：%s ,身份证号%d 由于是父类的私有变量不能这样调用 self._Person__UID " %(self.name,self.grade,Person._Person__UID))  

xs = Student('WeiyiGEEK',512301031998010937,'2018级')
xs.speak()
