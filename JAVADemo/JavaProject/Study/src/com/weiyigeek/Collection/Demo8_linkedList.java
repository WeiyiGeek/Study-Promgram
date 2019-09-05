package com.weiyigeek.Collection;

import java.util.LinkedList;

public class Demo8_linkedList {

	public static void main(String[] args) {
		//示例1.集合常用方法展示
		LinkedList list = new LinkedList(); //创建Linked对象
		list.add("1");
		list.addFirst("0");
		list.addLast("2");
		
		System.out.println("获取集合中第一个元素："+list.getFirst());
		System.out.println("获取集合中最后一个元素："+list.getLast());
		System.out.println("返回删除的第一个元素："+list.removeFirst());
		System.out.println("返回删除的最后一个元素："+list.removeLast());
		System.out.println("利用索引获取元素 (原理值得学习): "+list.get(0));
	
		//示例2.采用LinkedList模拟栈结构
		LinkedStack stack = new LinkedStack();
		stack.in("a"); //进栈
		stack.in("b");
		stack.in("c");
		stack.in("d");
		//循环弹栈
		while(!stack.isEmpty()) {
			System.out.println(stack.out());
		}
		
		//示例3.实现堆即先进先出采用addFrist();以及RemoveFrist（）即可
		
	}
}

//创建一个类将Linked中的方法封装  
class LinkedStack {
	private LinkedList lt = new LinkedList();
	
	/**模拟栈先进先出**/
	public void in(Object obj) {
		lt.addLast(obj);  //向末尾添加方法
	}
	public Object out() {
		return lt.removeLast();  //向末尾删除方法
	}
	
	//判断是否为空
	public boolean isEmpty() {
		return lt.isEmpty();
	}
}
