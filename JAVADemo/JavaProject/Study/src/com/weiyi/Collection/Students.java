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
}
