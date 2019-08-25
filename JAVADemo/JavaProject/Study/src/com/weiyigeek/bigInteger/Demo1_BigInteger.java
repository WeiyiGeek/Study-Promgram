package com.weiyigeek.bigInteger;

import java.math.BigInteger;

public class Demo1_BigInteger {

	public static void main(String[] args) {
		//示例1.将比long大的字符串转换成为可被计算的整形
		String val = new String("3141592600000000000");
		BigInteger bi = new BigInteger(val);
		System.out.println(bi);
		
		//示例2.大整数计算(注意会生成新值不会再远值上改变)
		BigInteger bi1 = new BigInteger("256");
		BigInteger bi2 = new BigInteger("2");
		BigInteger[] bi3 = bi1.divideAndRemainder(bi2);
		System.out.println("add = " + bi1.add(bi2));  //加
		System.out.println("subtract = " + bi1.subtract(bi2)); //减
		System.out.println("multiply = " + bi1.multiply(bi2)); //乘
		System.out.println("divide = " + bi1.divide(bi2));  //除
		System.out.println("div = " + bi3[0] + ", Remainder = " + bi3[1]);
	}
}
