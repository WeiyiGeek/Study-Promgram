package com.weiyigeek.integer;

import java.util.Arrays;

public class Demo2_Integer {

	public static void main(String[] args) {
		//实例1.Integer类的构造方法以及常量
		System.out.println("int 类型  Max : " + Integer.MAX_VALUE);
		System.out.println("int 类型  Min : " + Integer.MIN_VALUE);
		
		Integer it1 = new Integer(100);
		Integer it2 = new Integer("100"); //数字字符串转换成为整形
		Integer it3 = new Integer('a');   //注意：这里可以将单个字符转成码表对应的十进制值(但是字符串是不行的比如"abc")
		System.out.println(it1);
		System.out.println(it2);
		System.out.println(it3);

		//实例2.Integer类的一些方法(实现十进制转成其他进制)
		int src = 255;
		System.out.println(src + " -> Binary : " + Integer.toBinaryString(src)); //二进制
		System.out.println(src + " -> Octal : " + Integer.toOctalString(src));  //八进制
		System.out.println(src + " -> Hex : " + Integer.toHexString(src));     //十六进制
		
		
		//实例3.int与String之间的相互转换
		//整数转成字符串类型
		int num = 1024;
		
		String s1 = num + "";  //method1 (推荐)
		
		String s2 = String.valueOf(num); //method2 (推荐)
		
		Integer num2 = new Integer(num);
		String s3 = num2.toString();
		
		String s4 = Integer.toString(1024);
		System.out.println("四种int 转成 字符串 的 静态方法 ：" + s1 + ", " + s2 + ", " + s3 + ", " + s4);
		
		//字符串转成整数
		String s5 = "1024";
		Integer num3 = new Integer(s5);
		int num4 = num3.intValue();
		
		int num5 = Integer.parseInt(s5); // 推荐方法
		System.out.println("字符串转换成为整形:");
		System.out.print(num4);
		System.out.println(num5);
		
		
		//实例3.ParseXXX的方法,可以将这七种字符串表现形式转换成为基本数据类型;
		Boolean b = Boolean.parseBoolean("true");
		System.out.println(b);
		
		//面试题 自动装箱拆箱的特性
		int number1 = 1024;
		int number2 = 1024;
		Integer int1 = new Integer(number1);
		Integer int2 = new Integer(number2);
		System.out.println(int1 == int2);       //对象地址之间的比较
		System.out.println(int1.equals(int2));  //对象之间的比较
		System.out.println("#-----------------------------------------#");
		
		Integer int3 = new Integer(512);
		Integer int4 = new Integer(512);
		System.out.println(int3 == int4);
		System.out.println(int3.equals(int4));
		System.out.println("#-----------------------------------------#");
		
		//特殊点来了(如果取值范围在bytes中 -127 ~ 128，将直接从常量中取)
		Integer int5 = 97;
		Integer int6 = 97;
		System.out.println(int5 == int6);
		System.out.println(int5.equals(int6));
		System.out.println("#-----------------------------------------#");

		Integer int7 = 197;
		Integer int8 = 197;
		System.out.println(int7 == int8);
		System.out.println(int7.equals(int8));
		System.out.println("#-----------------------------------------#");
		
	}
}
