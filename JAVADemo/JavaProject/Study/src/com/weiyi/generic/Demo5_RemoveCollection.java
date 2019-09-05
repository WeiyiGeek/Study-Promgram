package com.weiyi.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.weiyi.Collection.Students;

public class Demo5_RemoveCollection {
	public static void main(String[] args) {
		//实例1.三种迭代方法是否能进行删除
		ArrayList<String> list = new ArrayList<String>();
		list.add("a"); 
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("WeiyiGeek");


		//(1)如果要删除的元素是挨着的,普通循环只能对其index索引减减<-重点
		for (int i = 0; i < list.size(); i++) {
			if("a".equals(list.get(i)))
				list.remove(i--); //注意这里是先赋值,再减减
		}
		
		//(2)迭代器删除
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			if("b".equals(it.next()))
				//注意这里不能使用集合的删除方法会导致并发修改异常(迭代过程中进行了修改),因为迭代过程中如果集合被修改,便会导致迭代修改异常
				it.remove();
		}
		
		//宁一种方式 与上面的区别就是 不能重复使用迭代器it1
		for(Iterator<String> it1 = list.iterator(); it.hasNext();)
		{
			if("c".equals(it1.next()))
				it1.remove();
		}
		
		
		//(3)增强for循环不能删除只可以遍历
		for(String param: list){
			if("c".equals(param))
				//list.remove(param);
				System.out.println(param);
		
			System.out.println("外层 : " +  param);
		}
		System.out.println(list);		
	}
}
