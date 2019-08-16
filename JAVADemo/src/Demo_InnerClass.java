class Demo_InnerClass {
  public static void main(String[] args)
  {
    //示例1.外部类要访问内部类必须是 外部类.内部类 来创建对象 (内部类极其访问特点)
    Outer.Inner demo = new Outer().new Inner(); //内部类对象 (关键点)
    demo.method();  //调用内部类方法

    //实例2.其他类无法访问外部类中私有成员内部类
    //Outer.PriInner demo1 = new Outer().new PriInner();   //会报错


    //实例3.可以采用Outer类中的公用方法，调用其私有内部类中的方法;
    Outer demo2 = new Outer();
    demo2.print();


    //实例4.实例化外部类中的静态成员内部类
    Outer.StaInner demo3 = new Outer.StaInner(); //关键点
    demo3.method();
  }
}

//关键点：创建内部类
class Outer {
  //内部类可以看做外部类的成员
  private int number=1024;
  //(1)内部类的 公共(默认)
  class Inner {
    public void method(){
      System.out.println("内部类: 类中类!\n"+"内部类可以访问外部类的私有成员number:"+number);
    }
  }

  //(2)内部类的 私有
  private class PriInner{
    public void method(){
      System.out.println("私有内部类的公共方法\n"+"外部类是无法访问的,除非为本类公共方法调用！");
    }
  }
  //本类的公共方法
  public void print(){
    System.out.println("进入 - 本类中的公共方法 - 调用私有的内部类里面的方法");
    PriInner i = new PriInner();
    i.method();
  }


  //############ 分割 #############
  //(3)静态内部类
  static class StaInner {
    public void method(){
      System.out.println("静态内部类: 以进入内部类之中");
    }
  }
}