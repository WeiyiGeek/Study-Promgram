package com.weiyigeek.exception;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Demo6_Example {

	public static void main(String[] args) {
		// 案例1.键盘输入一个int类型的整数进行输出其二进制表现形式;
		System.out.println("/***\n*** 二进制转换异常处理案例 ***\n***/");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个整数: ");

		while(true) {
			String line = sc.nextLine();
			try {
				int num = Integer.parseInt(line);	
				System.out.println(line+ "(Binary) = " +Integer.toBinaryString(num));
			} catch(Exception e) {
				try {
					new BigInteger(line);  //采用了小数和非常字符的异常;
					System.out.println("输入错误,录入的是一个过大的整数,请重新输入:");
				} catch (Exception e2) {
					//下面这里值得学习：
					try {
						new BigDecimal(line);
						System.out.println("输入错误,录入的是一个小数,请重新输入:");
					} catch (Exception e3) {
						System.out.println("输入错误,您录入的是非法字符,请重新输入一个整数:");
					}
				} 
				
			}	
		}
	}
}
