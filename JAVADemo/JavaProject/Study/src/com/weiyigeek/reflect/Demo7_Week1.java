//方法3: 枚举得第三种形式比较难
package com.weiyigeek.reflect;

//由于是抽象类所以采用内部匿名类
public abstract class Demo7_Week1 {
	//父类引用指向子类对象 （创建该类得子类对象）
	public static final Demo7_Week1 Sun = new Demo7_Week1("星期天") {
		public void show() {
			System.out.println("星期天");
		}
	};	
	private String week;
	public Demo7_Week1(String w) {
		this.week = w;
	}

	//我们说过抽象方法必须在抽象类中
	public abstract void show();
}
