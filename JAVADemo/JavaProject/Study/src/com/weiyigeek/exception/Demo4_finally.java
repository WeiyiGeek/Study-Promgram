package com.weiyigeek.exception;

public class Demo4_finally {
	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("除数不能为Zero");
			return; //相当于是方法的最后一口气,在他将死之前会看看有木有finally帮其完成遗愿；如果有就将finally执行后再彻底返回;
			// System.exit(0);  //表示退出JVM虚拟机
		} finally {
			System.out.println("在return返回前执行了,而如果在System.exit(0)后面则不会执行finally");
		}
	}
}
