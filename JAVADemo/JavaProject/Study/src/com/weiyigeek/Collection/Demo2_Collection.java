package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;

import com.weiyi.Collection.Students;

public class Demo2_Collection {

	public static void main(String[] args) {
		//示例1：集合遍历之集合转数组遍历
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		Object[] arr = c.toArray(); //集合之数组遍历
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		System.out.println("\n##########分割线上##########");
		//示例2.集合转换成为数组
		Collection c1 = new ArrayList();
		c1.add(new Students("赵老师",24));
		c1.add(new Students("经老师",23));
		c1.add(new Students("渣渣辉",25));
		c1.add(new Students("刘师傅",26));
		Object[] arr1 = c1.toArray();  //将集合转换成数组
		for (int i = 0; i < arr1.length; i++) {
			Students s = (Students)arr1[i];  //向下转型
			System.out.println(s.getName() + "  " + s.getAge());
		}
		
		
		//示例3.自带All()功能测试方法
		Collection c2 = new ArrayList();
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		
		Collection c3 = new ArrayList();
		c3.add("1");
		c3.add("2");
		c3.add("3");
		c3.add("4");
		c3.add("a");

		System.out.println("##########分割线###########");
		c2.add(c3);    //将c3看成一个对象添加到c1中 [1,2,3,4]
		System.out.println(c2);
		c2.addAll(c3); //将c3中的每一个元素添加到c1中
		System.out.println(c2);
		
		boolean b = c2.removeAll(c3);  //将c2中的c3元素进行删除 (需要注意删除是交集)
		System.out.println("需要注意删除是交集");
		System.out.println(c2);
		
		boolean b1 = c2.containsAll(c3); //判断调用集合是否包含传入的集合
		System.out.println("c2是否包含c3 : " + b1);
		
		//取交集如果调用的集合改变就返回true,否则返回false;
		boolean b2 = c2.retainAll(c3); //取交集
		System.out.println(b2);
		System.out.println(c2);
	}
}
