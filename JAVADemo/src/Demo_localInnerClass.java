/**
 * # @File : Demo_localInnerClass.java
 * # @CreateTime : 2019/8/16 15:47
 * # @Author : WeiyiGeek
 * # @Function :局部内部类访问局部变量的问题
 **/

//#####局部内部类访问局部变量的问题#####
class Demo_localInnerClass {
    public static void main(String[] args)
    {
        Outer o = new Outer();
        o.method();
    }
}

//外部类
class Outer {
    //公共的成员方法
    public void method() {
        final int number = 1024;
        //外部类中的成员方法声明的类,我们叫做局部内部类;
        class Inner {
            public void print(){
                System.out.println("局部内部类(调用方法中的成员变量必须加上final使之成为常量)："+number);
            }
        }
        //局部内部类的调用必须在同一个成员方法中实例化
        Inner i = new Inner();//局部内部类,只能在其所在的方法中访问;
        i.print();
    }
}