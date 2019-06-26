/***
 * 多态体现案例：
 */
class Demo1_Polymorphic {
    public static void main(String[] args)
    {
        //示例1.Cat类实例化
        Cat c = new Cat();
        c.eat();

        //示例2.父类引用指向子类对象
        Animal a = new Cat(); //代表了是动物里面的猫
        a.eat();


        //示例3.多态的伪装
        Animal wz = new Cat(); //它是动物但它实际是猫 使用动物类结构来声明 new cat 类
        System.out.println("" + wz.name); //显示它的大类
        wz.action(); //实际是猫在做的事情
        //如果下面调用wz.play就会报错由于父类中没有定义该play的成员方法
        //wz.play(); // //如果要正确执行就需要后面遇到的 [ 向上转型和向下转型 方法]
    }
}

class Animal {
    String  name = "大类-猫科";
    public void eat() {
        System.out.println("动物正在吃饭!");
    }
    public void action() {
        System.out.println("动物正在做自己该做的事情!");
    }
}

class Cat extends Animal {
    String name = "小类-猫儿";
    public void eat(){
        System.out.println("猫儿吃鱼!");
    }
    public void action(){
        System.out.println("猫儿正在勤劳的抓老鼠！");
    }
    public void play(){
        System.out.println("猫儿玩耍中.....");
    }
}