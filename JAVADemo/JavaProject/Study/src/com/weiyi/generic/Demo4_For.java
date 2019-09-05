package com.weiyi.generic;

import java.util.ArrayList;

import com.weiyi.Collection.Students;

public class Demo4_For {

	public static void main(String[] args) {
		//实例1.增强for遍历数组
		int[] arr = {11,22,33,44,55};
		//foreach 迭代(值得学习)
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//实例2.增强for遍历集合存储元素
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for (String param : list) {
			System.out.print(param+" ");
		}
		System.out.println();

		
		//实例3.ArrayList存储字符串和自定义对象并遍历增强for版
		ArrayList<Students> list1  = new ArrayList<Students>();
		list1.add(new Students("渣渣哥", 27));
		list1.add(new Students("刘师傅", 26));
		list1.add(new Students("帐老师", 27));
		
		for (Students param : list1) {
			System.out.println(param);  //这里是由于重写了toString的效果
		}
	}
}
