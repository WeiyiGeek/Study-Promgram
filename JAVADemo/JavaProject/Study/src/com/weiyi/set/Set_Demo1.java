/**
* @Filename: Set_Demo1.java
 * @Author: WeiyiGeek
 * @Function: Set集合学习 
 * @CreateTime: 下午7:38:16
 */
package com.weiyi.set;

import java.util.HashSet;
import com.weiyi.Collection.Students;

public class Set_Demo1 {

	public static void main(String[] args) {
		//1.Set集合的特点：
		//无索引、不可重复、无序(存取可能顺序不一致)
		System.out.println("#########示例1#############");
		demo();
		
		//2.存储自定义对象保证元素唯一性
		System.out.println("\n\n@@@@@@@@@@示例2@@@@@@@@@@");
		demo1();
	}

	public static void demo1() {
		HashSet<Students> st = new HashSet<>();
		st.add(new Students("张三",35));
		st.add(new Students("李连杰",32));
		st.add(new Students("王富贵",35));
		st.add(new Students("李三丰",32));
		st.add(new Students("张三",35));
		//查看集合中存放元素的个数(由于开始我们还未作重复过滤的时候size()输出为5)
		System.out.println(st.size());   //4
		System.out.println(st);  //由于重写HashCode()和euquals()方法使其自定义类对象的元素保持不重复
	}

	public static void demo() {
		HashSet<String> hs = new HashSet<String>(); //创建HashSet对象;
		boolean b1 = hs.add("a");   //当向set集合中存储重复元素的时候返回false;
		boolean b2 = hs.add("a"); 
		hs.add("b");
		hs.add("d");
		hs.add("c");
		System.out.println(hs); //HashSet继承体系中重写了toString方法,且输出元素不重复和无序
		System.out.println(b1 + " - " + b2);
		for (String string : hs) {  //只要能用迭代器迭代的就可以使用增强for循环遍历
			System.out.print(string + " ");
		}

	}
}

