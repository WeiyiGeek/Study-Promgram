class abstractDemo {
    public static void main(String[] args)
    {
    //1.Animal是抽象的不能进行实例化,所有会报错;
       //Animal a = new Animal(); //Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
    //2.但是可以通过多态来,将 父类引用指向子类对象 
        Animal c = new Cat();
        c.eat();
    //3.抽象类的特点
        c.print();
// 【多态重写】Cat eat Fishc!
// 【抽象类中可以有 非抽象成员方法 】
}
}

abstract class Animal {    //抽象类
    int num1 = 10;         //抽象类中成员变量可以是变量也可以是常量
    final int num2 = 20;    //为了给子类初始化
    public void demo(){};
    public void print(){
        System.out.println("【抽象类中可以有 非抽象成员方法 】");
    }
    public abstract void eat();  //抽象方法
}
//多态重写抽象类里的抽象方法
class Cat extends Animal {
    public void eat(){
        System.out.println("【多态重写】Cat eat Fishc!");
    }
}

abstract class CCat extends Animal {
    public void eat1 () {  
        System.out.println("【抽象类子类】 mutil Cat eat Fishc!");
    }
}
