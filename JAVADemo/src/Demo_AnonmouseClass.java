/**
 * # @File : Demo_AnonmouseClass.java
 * # @CreateTime : 2019/8/16 16:50
 * # @Author : WeiyiGeek
 * # @Function : 匿名内部类在开发中的应用
 **/
class Demo_AnonmouseClass {
    public static void main(String[] args){
        //实例1.调用PersonDemo中的method方法
        PersonDemo pd = new PersonDemo();
        pd.method(new Student());

        //实例2.匿名内部类实现参数传递
        pd.method(new Person(){
            public void show() {
                System.out.println("匿名内部类的调用!");
            }
        });
    }
}

//抽象类(abstract)或者接口(interface)都可以;
abstract class Person {
    public abstract void show();
}
//有名称的类
class PersonDemo {
    public void method(Person p)  //Person p = new Student
    {
        p.show();
    }
}
//继承重写
class Student extends Person {
    public void show(){
        System.out.println("有名称的类");
        System.out.println("有名称的类型调用!");
    }
}