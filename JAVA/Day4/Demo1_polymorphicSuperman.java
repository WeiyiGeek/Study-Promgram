/**
 * 演示：多态中向上转型和向下转型
 *  */
class Demo1_polymorphicSuperman {
    public static void main(String[] args) {
        //##示例1.##
        Person p = new Superman();   //这是向上转型 （重点）
        System.out.println(p.name);
        p.测试(); //编译看左边(父类方法),运行看右边(子类方法)
        Superman su = (Superman)p;  //这是向下转型 （就可以使用子类的静态方法和成员变量）
        System.out.println(su.name);
        su.测试(); //执行子类方法
        su.fly();  //执行子类方法


        //##示例2.###
        //Animal a = new Cat(); //开发的是很少在创建对象的时候用父类引用指向子类对象,直接创建子类对象更方便,可以使用子类中的特有属性和行为
        method(new Cat());
		method(new Dog());
    }

    //如果把狗强转成猫就会出现类型转换异常,ClassCastException
    public static void method(Animal a) {	//采用父类当作当作参数的时候用多态最好,因为扩展性强
        //上下都是关键点
		if (a instanceof Cat) {
			Cat c = (Cat)a;  //强制转换（多态的向下转换）
			c.eat();
			c.catchMouse();
		}else if (a instanceof Dog) {
			Dog d = (Dog)a;
			d.eat();
			d.lookHome();
		}else {
			a.eat();
		}
	}
}

class Person {
    String name = "Person";
    public void 测试() { System.out.println("person人类测试！");}
}
class Superman extends Person {
    String name = "Superman";
    public void 测试() { System.out.println("Superman超人测试！");}
    public void fly() { System.out.println("去救人！");}
}

class Animal {
    public void eat() {System.out.println("动物吃饭");}
}
class Cat extends Animal {
	public void eat() {System.out.println("猫吃鱼");}
	public void catchMouse() {System.out.println("抓老鼠");}
}
class Dog extends Animal {
	public void eat() {System.out.println("狗吃肉");}
	public void lookHome() {System.out.println("看家");}
}
