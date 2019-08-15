class Demo_InnerClass {
    public static void main(String[] args)
    {
      //示例1.外部类要访问内部类必须是 外部类.内部类 来创建对象
      Outer.Inner demo = new Outer().new Inner(); //内部类对象 (关键点)
      demo.method();  //调用内部类方法
    }
  }
  
  //关键点：创建内部类
  class Outer {
    //内部类可以看做外部类的成员
    private int number=1024;
    class Inner {
      public void method(){
        System.out.println("内部类: 类中类!\n"+"内部类可以访问外部类的私有成员number:"+number);
      }
    }
  }