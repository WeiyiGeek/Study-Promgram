package com.weiyi.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class set_LinkedHashCode {

	public static void main(String[] args) {
		
		//示例1.LinkedHashSet类型初步使用
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("b");
		lhs.add("c");
		lhs.add("d");
		System.out.println("示例1:LinkedHashSet的使用 " + lhs + "\n");
		
		
		//示例2.使用Scanner从键盘读取去掉不同的字符打印出不同的那些字符
		/**
		 * 1.创建Scanner对象
		 * 2.创建HashSet对象将字符存储去掉重复
		 * 3.将字符串转换为字符数据,获取每一个字符存储在HashSet集合之中自动去除重复
		 * 4.遍历HashSet打印每一个字符
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一行字符串: ");
		HashSet<Character> c = new HashSet<Character>();
		String line = sc.nextLine();
		char[] arr = line.toCharArray();
		for (char d : arr) {
			c.add(d);
		}
		//遍历打印每一个字符
		for (Character ch : c) {
			System.out.print(ch);  //打印出是无序的
		}
		
		
		//示例3.List集合与LinkedHashSet集合联合使用案例
		/**
		 *  (1)去除List集合中的重复元素：
		 *  - 创建一个LinkedHashSet集合
		 *  - 将List集合中所有元素添加到LinkedHashSet集合
		 *  - 将List集合中的元素清除
		 *  - 将LinkedHashSet集合中元素加回到List集合之中
		 **/
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("a"); //重复元素
		getSingle(list);
		System.out.println(list);
		
	}
	//这里改成List可以兼容linked
	public static void getSingle(ArrayList<String> list) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.addAll(list); //包括其所有的子类对象(去重了)
		list.clear();
		list.addAll(lhs); //非常值得学习去重后重新放入list集合中
	}
}
