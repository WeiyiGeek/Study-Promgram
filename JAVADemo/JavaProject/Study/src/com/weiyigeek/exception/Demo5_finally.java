package com.weiyigeek.exception;

public class Demo5_finally {
	public static void main(String[] args) {
		System.out.println(extracted());
	}

	public static String extracted() {
		int x = 10;
		try {
			x = 20;
			System.out.println(1/0);
			return "try代码块中必须要有return语句: " + x;
		} catch (Exception e) {
			x = 30;
			return "catch代码块中也必须要有return语句:" + x; //相当于占用了一个坑里面只能存30(在finally完成后继续输出);
		} finally {
			x = 40; // 注意点:finally代码块(作用是释放资源)中一定不能存在return语句否则会将覆盖try或者catch中的return语句
		}
	}
}
