//ע�⣺ͬһ·���µİ����õ���
public class Demo5_SimpleFactory {
	//��1��ʵ��1.���Լ򵥹�������ģʽ
	//public static Dog createDog() {return new Dog();}
	//public static Cat createCat() {return new Cat();}
	public static void main(String[] args) {
//		Factory f1 = new Factory();  //������������ģʽ����
//		Dog d = (Dog)f1.createanimal("Dog"); //����ת��
//		d.eat();
//		
//		Cat c = (Cat)f1.createanimal("Cat"); //����ת��
//		c.eat();
		
		//ʵ�ֹ�/è�������ģʽ���ǳ�ֵ��ѧϰ��
		DogFactory df = new DogFactory();
		Dog d = (Dog)df.createAnimal();
		d.eat();
		
		CatFactory cf = new CatFactory();
		Cat c = (Cat)cf.createAnimal();
		c.eat();
	}
}
