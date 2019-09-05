package com.weiyigeek.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import com.weiyi.Collection.Students;

public class Demo7_ArrayList {
	public static void main(String[] args) 
	{
	/**
	 * A:案例演示
	   * 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
	   * 思路：创建新集合方式
	 */
		ArrayList newList = new ArrayList();
		newList.add("a");
		newList.add("c");
		newList.add("b");
		newList.add("b");
		newList.add("b");

		ArrayList list = getSingle(newList);
		System.out.println(list);
		
		/**
		B:案例演示
		* 需求：ArrayList去除集合中自定义对象元素的重复值(对象的成员变量值相同)
		* **/
		ArrayList objList = new ArrayList();
		objList.add(new Students("张三",13)); //如果采用Object方式是对比的地址值是不一样的
		objList.add(new Students("张三",13));
		objList.add(new Students("张四",13));
		objList.add(new Students("王三",13));
		ArrayList objres = getSingleObj(objList); //循环方法进行对象去重
		objList.remove(new Students("张三",13));   //底层都是依赖于object的equals方法
		System.out.println(objres);
	}
	
	/*
	    *  参数: 去除重复
	 * 1,返回ArrayList类型类别
	 * 2,参数列表ArrayList
	 * 创建新集合、根据传入的集合获取迭代器
	 * 遍历老集合、通过新集合判断是否包含老集合中的元素,如果不包含就不添加;
	 */
	public static ArrayList getSingle(ArrayList list)  {
		ArrayList newList = new ArrayList();			//创建一个新集合
		Iterator it = list.iterator();					//获取迭代器
		while(it.hasNext()) {							//判断老集合中是否有元素
			String temp = (String)it.next();			//将每一个元素临时记录住
			if(!newList.contains(temp)) {				//如果新集合中不包含该元素
				newList.add(temp);						//将该元素添加到新集合中
			}
		}
		return newList;									//将新集合返回
	}
	
	//可以处理比较对象的类
	private static ArrayList getSingleObj(ArrayList objList) {
		ArrayList newList = new ArrayList();
		Iterator it = objList.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if(!newList.contains(obj))
			{
				newList.add(obj);
			}
		}
		return newList;
	}
}
