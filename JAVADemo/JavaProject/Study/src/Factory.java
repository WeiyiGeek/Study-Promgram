//工厂方法设计类Factory.java
public class Factory {
	//方式1:
	//public static Dog createDog() {return new Dog();}
	//public static Cat createCat() {return new Cat();}
	
	//方法2:
	public static Animal createanimal(String animalname)
	{
		if("Dog".equals(animalname)){
			return new Dog();
		}else if("Cat".equals(animalname)){
			return new Cat();
		}else {
			return null;
		}
	}
}
