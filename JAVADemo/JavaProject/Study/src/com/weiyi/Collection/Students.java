package com.weiyi.Collection;
//创建一个学生类
public class Students {
	private String name;
	private int age;
	//创建空参和有参
	public Students() {}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//创建get/setter 方法
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
