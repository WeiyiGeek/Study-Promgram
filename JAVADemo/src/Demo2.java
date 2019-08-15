package com.weiye;
import com.weiyi.Demo1; //#注意这里需要导包使用
//#继承其他包里面类

public class Demo2 extends Demo1 {
  public Demo2(){}
  public Demo2(String love){
    //引用父类构造方法
    super(love);
  }
  public void method(){
    System.out.println("外部包继承类,访问父类中protected受保护的print方法!");
    print();
  }
}