/**
 * @Filename: Demo.java
 * @Author: WeiyiGeek
 * @Function: 
 * @CreateTime: обнГ9:47:13
 */
package com.weiyigeek.demo;

import java.util.Scanner;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Whami");
		Scanner sc = new Scanner(System.in);

		int num = 1;
		int num1 = 12;
		int sum = addwhoami(num, num1);
	}

	private static int addwhoami(int num, int num1) {
		return num + num1;
	}

}
