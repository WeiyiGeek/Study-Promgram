package com.weiyigeek;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//示例1：输入格式判断
		System.out.print("请输入一个整数:");
		if (sc.hasNextInt()) {
			System.out.println("整数："+sc.nextInt());
		}else {
			System.out.println("格式错误！");
		}
		
		//示例2.NextInt域nextLine联用的问题
		System.out.print("请输入第二个1数字：");
		int integer = sc.nextInt();
		System.out.println("请输入第二个字符串：");
		String line = sc.nextLine();
		System.out.println("Integer 整数:"+integer+","+line);
		//解决方法1：创建两次对象
		int i = sc.nextInt();
		Scanner lineStr = new Scanner(System.in);
		String line1 = lineStr.nextLine();
		System.out.println("解决方法: 整数="+ i +", 字符串=" + line1);
	}
}
