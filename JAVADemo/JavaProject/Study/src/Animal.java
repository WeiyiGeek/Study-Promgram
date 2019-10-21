//Animal.java 抽象类
public abstract class Animal {
	//狗类/狗类继承方法
	public abstract void eat();
}

//狗类 Dog.java
class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("狗啃骨头!");
	}
}

//猫类 Cat.java
class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("猫吃鱼儿!");
	}
}
