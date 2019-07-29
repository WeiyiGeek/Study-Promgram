/**
 * # @File : InterfaceDemo2.java
 * # @CreateTime : 2019/7/26 10:45
 * # @Author : WeiyiGeek
 * # @Function :抽象类与接口区别案例
 **/

public class InterfaceDemo2 {
    public static void main(String[] args) {
        //继承类
        Cat1 c = new Cat1("Love",12);
        c.eat();
        c.play();

        //普通类-继承类与接口
        JumpCat d = new JumpCat("baby", 13);
        d.eat();
        d.play();
    }
}

//父类
abstract class AnimalFather {
    private String name;
    private int age;
    public AnimalFather(String name, int age) {
        this.name = name;
        this.age = age;
    }
   //建立方法方便返回私有成员变量
    public String getName() {
        return this.name;
    }

    //抽象方法
    public abstract void eat();
    public abstract void play();
}

//接口类
interface Jumping {
    public abstract void jump();
}

//继承类 - 实现重写
class Cat1 extends AnimalFather {
    public Cat1(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat() {
        System.out.println(super.getName() + "Cat eat Fishc！");
    }
    @Override
    public void play() {
        System.out.println(super.getName() + "Cat play 毛线");
    }
}

//类继承Cat1又继承接口
class JumpCat extends Cat1 implements Jumping {
    //需要一个有参构造 （注意不要忘记，虽然Cat1类类存在，但是任然需要）
    public JumpCat(String name, int age) {
        super(name, age);
    }
    //重写接口中抽象方法
    public void jump(){
        System.out.println("Cat Jumping！");
    }
}