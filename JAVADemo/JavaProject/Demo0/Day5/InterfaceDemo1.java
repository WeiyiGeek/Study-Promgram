/**
 * # @File : InterfaceDemo1.java
 * # @CreateTime : 2019/7/26 9:58
 * # @Author : WeiyiGeek
 * # @Function :实现Interface接口学习与利用
 **/

public class InterfaceDemo1 {
    public static void main(String[] args){
        //1.接口不能被实例化,与调用抽象方法是一致的没有任何意义
        // Inter i = new Inter()

        //2.接口采用多态的方式进行调用
        //(1) 普通类
        Inter i = new Demo();  //父类引用指向子类对象
        i.print();

        //(2) 接口子类抽象类->多态调用
        Inter j = new sub();
        j.print();

        //3.接口中的成员变量
        String num1 = String.valueOf(i.num1);
        String num2 = String.valueOf(Inter.num2);
        System.out.println(num1 + num2); //静态成员方法可以直接采用 类名.属性 进行调用
        System.out.print(i.num1+" VS "+Inter.num2); //静态成员方法可以直接采用 类名.属性 进行调用

    }
}

//接口定义
interface Inter {
    //接口中成员变量(是常量并且是静态的并公共的)，默认修饰符：public static final
    int num1 = 1024;   //效果同下
    public static final int num2 = 1024;  //推荐方式

    //接口中方法都是抽象的,不能定义非抽象方法，以及没有构造方法
    public abstract void print();
}

//接口实现 - 具体类(普通类)
class Demo implements Inter {
    //构造方法
    public Demo() {
        super();  //默认是继承Object类即：Class Demo extends Object implements Inter
    }
    //重写抽象方法
    public void print(){
        System.out.println("[1].接口子类-普通类-抽象方法被调用");
    }
}

//接口实现 - 抽象类
abstract class Demo1 implements Inter {
    public abstract void print();  //无任何意义
}
class sub extends Demo1 {
    public void print(){
        System.out.println("[2.]接口子类-抽象类-多态方式-抽象方法被调用");
    }
}
