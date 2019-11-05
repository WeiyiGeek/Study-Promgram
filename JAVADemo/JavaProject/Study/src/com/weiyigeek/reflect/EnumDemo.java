package com.weiyigeek.reflect;
public class EnumDemo {
	public static void main(String[] args) {
		//实例1.常规枚举
		Week1 w = Week1.Mon;
		System.out.println("方法1:");
		System.out.println(w);
		
		//实例2.有参数枚举
		Week1 w1 = Week1.Wed;
		System.out.println("方法2:");
		System.out.println(w1.getWeek());
		
		//实例3：抽象的枚举类
		Week2 w2 = Week2.MON;
		System.out.println("方法3:");
		w2.show();

	}
}
