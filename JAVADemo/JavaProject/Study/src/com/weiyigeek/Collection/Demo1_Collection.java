package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;

import com.weiyi.Collection.Students;  //引入学生类

public class Demo1_Collection {
	/**
	 * Student[] arr = new Student[5]; //存储学生对象
		arr[0] = new Student("张三", 23);
		arr[1] = new Student("李四", 24);
		arr[2] = new Student("王五", 25);
		arr[3] = new Student("赵六", 26);
		arr[4] = new Student("马哥", 20);
	 * 
	 */
	public static void main(String[] args) {
		//示例1.基本数据类型数组
		//int[] arr = new int[5];
		
		//示例2.引用数据类型数组
		Students[] arrs = new Students[5];
		arrs[0] = new Students("张三", 23);
		arrs[1] = new Students("李四", 25);
		arrs[2] = new Students("王五", 27);
		
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]); //数组和集合引用数据类型存储都是地址值
		}
		
		//示例3.Collection类的使用 (编译看父类,运行看子类)
		Collection c = new ArrayList(); //父类引用指向子类对象
		//add方法如果是List集合一直都返回True,因为List集合中是可以存储重复元素的;但如果是set集合当存储重复元素的时候就会返回false;
		boolean b1 = c.add("abc");
		boolean b2 = c.add(true); //自动装箱特性new Boolean(true)
		boolean b3 = c.add(100);
		boolean b4 = c.add(10.24);
		boolean b5 = c.add(new Students("张三",23));
		boolean b6 = c.add("abc");  //可以添加重复的元素
		System.out.println(c);  //类似于Python中的集合
		//ArrayList 的父类的父类重写toString方法,所以在打印对象的引用的时候输出的结果不是Object类中的toString方法
		System.out.println(c.toString());  //类似于Python中的集合

		//示例4.其他的方法
		System.out.println("集合元素个数 :" + c.size());//获取集合中元素个数

		c.remove("abc"); //删除元素
		System.out.println("删除指定元素 : "+c);  //类似于Python中的集合

		System.out.println("判断是否包含 " + c.contains(10.24));
	
		c.clear();//清空元素
		System.out.println("清空元素 : " + c);  //类似于Python中的集合
		
		System.out.println("判断是否为空 : " + c.isEmpty()); //判断集合是否为空
	}
}
