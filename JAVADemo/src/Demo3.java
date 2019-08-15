//com.main (入口类)
package com.main;
import com.weiyi.Demo1;
import com.weiye.Demo2;
class Demo3 {
  public static void main(String[] args)
  {
    //示例1.不同包下(无关类)不能访问外部包下的除了public修饰的类和方法
    Demo1 demo1 = new Demo1("计算机");
    demo1.getLove();
    //demo1.print()  #将会报错由于不同包下的无关类不能调用外部包里面受保护的类


    //示例2.不同包下(继承子类)可以访问外部包下受保护的类protected
    Demo2 demo2 = new Demo2("运动");
    demo2.method();     //关键点
  }
}