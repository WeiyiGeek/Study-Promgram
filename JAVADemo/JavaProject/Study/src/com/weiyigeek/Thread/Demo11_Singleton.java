package com.weiyigeek.Thread;

public class Demo11_Singleton {

	public static void main(String[] args) {
		// 实现单例设计模式的几种方法
		// 1.饿汉式
		Singleton s1 = Singleton.getInstance(); 
		Singleton s2 = Singleton.getInstance();
		if(s1 == s2) {
			s1.print();
		}
		
		// 2.懒汉式
		Singleton1 sl1 = Singleton1.getInstance(); 
		Singleton1 sl2 = Singleton1.getInstance();
		if(sl1 == sl2) {
			sl1.print();
		}
		
		// 3.无名式
		Singleton2 slt1 = Singleton2.s;
		Singleton2 slt2 = Singleton2.s;
		System.out.println(slt1 == slt2);
	}
}

//方式1:饿汉式开发建议使用这种方式。
class Singleton {
	//1,私有构造函数
	private Singleton(){}
	//2,创建本类对象
	private static Singleton s = new Singleton();
	//3,对外提供公共的访问方法
	public static Singleton getInstance() {
		return s;
	}
	public static void print() {
		System.out.println("方法1");
	}
}


//方式2:懒汉式面试时候建议使用
class Singleton1 {
	//1,私有构造函数
	private Singleton1() {};
	//2,创建本类对象（但不对其进行赋值）
	private static Singleton1 s;
	//3,对外提供公共的访问方法
	public static Singleton1 getInstance() {
		if(s == null)
			//线程1,线程2（多线程的时候会导致安全问题，所以面试的时候不建议使用）
			s = new Singleton1();
		return s;
	}
	public static void print() {
		System.out.println("方式2");
	}
}


//方式3：暂无名称
class Singleton2 {
	//第一步.都是构造私有函数
	private Singleton2() {};
	//第二步.集其精华之所在
	public static final Singleton2 s = new Singleton2();
}