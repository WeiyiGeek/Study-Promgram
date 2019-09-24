package com.weiyi.set;

import java.util.TreeSet;

public class TreeSet_demo {
	public static void main(String[] args) {
		//示例1.TreeSet集合基本使用
		TreeSet<Integer> ts = new TreeSet<>(); //创建TreeSet对象去重和排序
		ts.add(3);
		ts.add(1);
		ts.add(1);
		ts.add(2);
		ts.add(2);
		ts.add(2);
		ts.add(2);
	
		System.out.println(ts);  //输出元素
	}
}
