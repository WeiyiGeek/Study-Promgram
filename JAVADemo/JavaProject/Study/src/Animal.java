//Animal.java ������
public abstract class Animal {
	//����/����̳з���
	public abstract void eat();
}

//���� Dog.java
class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("���й�ͷ!");
	}
}

//è�� Cat.java
class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("è�����!");
	}
}
