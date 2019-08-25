package com.weiyigeek.math;

public class Demo1_Math {

	public static void main(String[] args) {
		//示例1.常量值
		System.out.println("自然对数  : " + Math.E);
		System.out.println("圆周率 : "  + Math.PI);
		
		//示例2.常用方法
		System.out.println(" -2 的绝对值 : " + Math.abs(-2));
		System.out.println(" -2 .0的绝对值 : " + Math.abs(-2.0));
		
		System.out.println("向上取整" + Math.ceil(12.3));
		System.out.println("向上取整" + Math.ceil(12.99));

		System.out.println("向下取整" + Math.floor(12.3));
		System.out.println("向上取整" + Math.floor(12.99));
		
		System.out.println("四舍五入 " + Math.round(12.30));
		System.out.println("四舍五入 " + Math.round(12.50));
		
		System.out.println("5 8 最大值 = " + Math.max(5, 8));
		System.out.println("5 8 最大值 = " + Math.min(5, 8));

		System.out.println("2^16 = " + Math.pow(2,16));
		
		System.out.println("随机数 = " + Math.random());
	}
}
