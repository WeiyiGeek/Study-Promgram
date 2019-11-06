package com.weiyigeek.reflect;
public class Demo9_JDK8Speciality {
	public static void main(String[] args) {
		//JDK 8 新特性
		Demo d = new Demo();
		d.print();

		Inter.method();  //静态方法直接调用
		
		d.run();
	}
}

interface Inter {
	//非静态的一般方法必须采用Default方法进行修饰，否则报错;
	public default void print() {
		System.out.println("Hello World!");
	}
	
	//静态方法可以直接采用接口名称调用
	public static void method() {
		System.out.println("Static Method");
	}
}


class Demo implements Inter {
	//局部内部类，采用局部变量时在1.7以前必须添加上final修饰，但是在1.8以后就不用了;
	public void run() {
		int flag = 1024; //局部变量
		class Inner {
			public void num() {
				System.out.println("flag = " + flag);
			}
		}
		Inner i = new Inner();
		i.num();
	}
}
