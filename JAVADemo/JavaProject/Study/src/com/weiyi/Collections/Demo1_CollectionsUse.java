package com.weiyi.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1_CollectionsUse {

	public static void main(String[] args) {
		//1.Collections工具类的基础使用
		ArrayList<String> list = new ArrayList<String>();
		list.add("c");
		list.add("d");
		list.add("a");
		list.add("b");
		list.add("A");

		System.out.println("ArrayList 怎么存就会怎么取 : "  + list);
		Collections.sort(list);
		System.out.println("经过Collections工具类排序后的结构: " + list); //String 默认安装acsii表排序
		
		int index = Collections.binarySearch(list, "a");
		System.out.println("查找到的结果的索引：" + index);
		System.out.println("查找到的结果的索引：" + Collections.binarySearch(list, "B")); // -(插入点1)-1=-2

		System.out.println("根据默认排序结果获取集合中最大值："+Collections.max(list));
		System.out.println("根据默认排序结果获取集合中最小值："+Collections.min(list));
		
		//反转
		Collections.reverse(list);
		System.out.println("反转输出结果(从大到小): " + list);
		//随机排序
		Collections.shuffle(list);
		System.out.println("每次都随机的输出:" + list);
		
	}

}
