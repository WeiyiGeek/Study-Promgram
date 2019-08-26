package com.weiyigeek.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Demo5_ListIterator {

	public static void main(String[] args) {
		//方式1：
		List list = new ArrayList();
		list.add("Weiyi");
		list.add("world");
		list.add("Geek");
		
		//采用：常规Iterator迭代器
		Iterator it = list.iterator();
		boolean flag = false;
		while(it.hasNext())
		{
			String str = (String)it.next();
			if(str.equals("world")) {
			//list.add("JavaEE") //这里会抛出ConcurrentModificationException并发修改异常
			//迭代器遍历集合修改集合,异常由于迭代器已经知道集合的个数,然而在迭代的时候又添加了集合元素所以导致异常
			//所以采用此种方法
				flag = true;
				break;
			}
		}
		if(flag) {
			list.add("JavaEE");
		}
		System.out.println("方法1:" + list);
		
		
		//方式2：
		//* a:迭代器迭代元素，迭代器修改元素(ListIterator的特有功能add)
		//* b:集合遍历元素，集合修改元素
		ListIterator lit = list.listIterator();		//如果想在遍历的过程中添加元素,可以用ListIterator中的add方法
		while(lit.hasNext()) {
			String str = (String)lit.next();
			if(str.equals("world")) {
				//它会立即在找到world后面进行添加javaee
				lit.add("javaee");	//关键点 lit的 ListIterator在迭代的过程中添加元素对象;
			}
		}
		System.out.println("方式2:"+list);
	}
}
