//注意：同一路径下的包不用导入
public class Demo5_SimpleFactory {
	//（1）实例1.测试简单工厂方法模式
	//public static Dog createDog() {return new Dog();}
	//public static Cat createCat() {return new Cat();}
	public static void main(String[] args) {
//		Factory f1 = new Factory();  //创建工厂方法模式对象
//		Dog d = (Dog)f1.createanimal("Dog"); //向下转型
//		d.eat();
//		
//		Cat c = (Cat)f1.createanimal("Cat"); //向下转型
//		c.eat();
		
		//实现狗/猫工厂设计模式（非常值得学习）
		DogFactory df = new DogFactory();
		Dog d = (Dog)df.createAnimal();
		d.eat();
		
		CatFactory cf = new CatFactory();
		Cat c = (Cat)cf.createAnimal();
		c.eat();
	}
}
