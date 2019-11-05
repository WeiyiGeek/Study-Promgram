//模板方法设计模式:
package com.weiyigeek.reflect;
public class Demo6_Template {
	public static void main(String[] args) {
		Temp tmp = new Temp();
		System.out.println("花费时间为: " + tmp.getRunTime());
	}
}

//建立一个抽象类
abstract class GetRunTime {
	//拥有抽象方法(abstract)本身必须是抽象类,为了防止类方法被重新加上一个final进行修饰,子类可以直接调用父类方法;
	public final long getRunTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}
	public abstract void code();
}


//创建一个类并继承该抽象类
class Temp extends GetRunTime {
	@Override
	public void code() {
		for(int i = 0; i < 10000; i++)
			System.out.println(i);
	}
}
