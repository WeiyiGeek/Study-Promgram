/**
 * @Filename: Demo2.java
 * @Author: WeiyiGeek
 * @Function: ̽��alt+shift+s ��ݿ���
 * @CreateTime: ����11:54:02
 */
package com.weiyigeek.demo;

public class Demo2 {
	private String name;
	private int age;
	
	public Demo2() {
		super();
		
	}

	public Demo2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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


//class Person {
//	private String name;
//	private int age;
//	
//	//source ->Generate Constructors from Superclass  && ��ݼ���alt + shift + s + c
//	public Person() {
//		super();
//	}
//	
//	//source ->Generate Constructor using field && ��ݼ���alt + shift + s + o
//	public Person(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}
//
//	//source ->Generate gettter and setters&& ��ݼ���alt + shift + s + r
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//}
