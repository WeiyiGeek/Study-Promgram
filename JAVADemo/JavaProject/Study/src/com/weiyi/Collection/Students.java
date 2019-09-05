package com.weiyi.Collection;
//����һ��ѧ����
public class Students {
	private String name;
	private int age;
	//�����ղκ��в�
	public Students() {}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//����get/setter ����
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
	
	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		//����ת��
		Students stu = (Students)obj; 
		return this.name.equals(stu.name) && this.age == stu.age;
	}
	
}
