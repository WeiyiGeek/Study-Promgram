//�������������Factory.java
public class Factory {
	//��ʽ1:
	//public static Dog createDog() {return new Dog();}
	//public static Cat createCat() {return new Cat();}
	
	//����2:
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
