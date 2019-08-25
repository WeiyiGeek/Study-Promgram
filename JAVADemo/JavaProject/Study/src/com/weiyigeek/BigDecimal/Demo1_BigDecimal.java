package com.weiyigeek.BigDecimal;

import java.math.BigDecimal;

public class Demo1_BigDecimal {
	public static void main(String[] args) {
		//示例1.BigDecimal 精确计算的几种方法
		BigDecimal bd1 = new BigDecimal(2.0);  //方式1 传入double类型参数
		BigDecimal bd2 = new BigDecimal(1.1);
		System.out.println("Demo1 - 开发中不推荐此种方式  2.0 - 1.1 = " + bd1.subtract(bd2));

		BigDecimal bd3 = new BigDecimal("2.0"); //方式2 传入字符串的方式
		BigDecimal bd4 = new BigDecimal("1.1");
		System.out.println("Demo2 - 通过构造中传入字符串的方式 开发时候推荐  2.0 - 1.1 = " +bd3.subtract(bd4));
		
		BigDecimal bd5 = BigDecimal.valueOf(2.0); //方式3
		BigDecimal bd6 = BigDecimal.valueOf(1.1);
		System.out.println("Demo3 - 在开发中也是推荐的 2.0 - 1.1 = " + bd5.subtract(bd6));
		System.out.println(bd5.add(bd6));
		System.out.println(bd5.multiply(bd6));
		System.out.println(bd5.divide(bd6,1));  //注意除法 有其他参数
	}
}
