class abstractDemo1 {
// 抽象类进行练习
// * 具体事物：猫，狗
// * 共性：姓名，年龄，吃饭
// * 猫的特性:抓老鼠
// * 狗的特性:看家
    public static void main(String[] args) {
        Cat c = new Cat("1", 8);
        Dog d = new Dog("1", 12);
        // System.out.println("Cat 姓名："+ c.getName() +" 年龄："+c.getAge());
        // c.eat();
        // c.ability();
    
        // System.out.println("Dog 姓名："+ d.getName() +" 年龄："+d.getAge());
        // d.eat();
        // d.ability();

    }
}

//定义一个抽象类
abstract class Animal {
    private Sting name;
    private int age;
    public Animal(){};      //空参构造函数
    public Animal(String name,int age){      //有参构造函数
        this.name = name;
        this.age = age;
    }

    // //设置姓名
    // public void setName(String name){
    //     this.name = name;
    // }
    // //获取姓名
    // public String getName(){
    //     return name;
    // }
    // //设置年龄
    // public void setAge(int age) {
    //     this.age = age;
    // }
    // //获取年龄
    // public int getAge() {
    //     return age;
    // }
    // //public abstract void cat();
}


class Cat extends Animal { 
    public Cat() {}; //空参
    public Cat(String name, int age) {
        super(name, age); //由于是私有成员变量,需要将更改传入super父类那里;
    }
    // public void eat(){
    //     System.out.println("Cat eat Fishc!!");
    // }
    // public void ability(){
    //     System.out.println("Catch MOUSE!");
    // }
}

class Dog extends Animal {
    public Dog(){}; //空参
    public Dog(String name, int age) { //有参
        //由于是私有成员变量,需要将更改传入super父类那里;
        super(name,age);
    }
    // public void eat(){
    //     System.out.println("Cat eat Bone!!");
    // }
    // public void ability(){
    //     System.out.println("Catch House!");
    // }
}
