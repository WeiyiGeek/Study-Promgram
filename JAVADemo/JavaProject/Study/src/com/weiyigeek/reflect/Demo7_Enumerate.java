package com.weiyigeek.reflect;
public class Demo7_Enumerate {
	public static void main(String[] args) {
		//实例1.枚举得使用
		Demo7_Week mon = Demo7_Week.Mon;
		Demo7_Week tue = Demo7_Week.Tue;
		Demo7_Week wed = Demo7_Week.Wen;
		System.out.println("方式1:");
		System.out.println(mon);
		
		//实例2.枚举有参
		Demo7_Week Thu = Demo7_Week.Thu;
		Demo7_Week Fri = Demo7_Week.Fri;
		Demo7_Week Sat = Demo7_Week.Sat;
		System.out.println("方式2：");
		System.out.println(Thu.getWeek());
		
		//实例3.枚举得内部匿名类
		Demo7_Week1 sun = Demo7_Week1.Sun; //编译看左边，运行看右边
		System.out.println("方式3:");
		sun.show();
	}
}
