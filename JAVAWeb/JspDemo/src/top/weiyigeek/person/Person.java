package top.weiyigeek.person;

public class Person {
	//����
	String name = null;
	int age = 0;
	
	//���췽��
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//get��Set����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
