package com.weiyigeek.Collection;

import java.util.Enumeration;
import java.util.Vector;

public class Demo6_vector {

	public static void main(String[] args) {
		//示例1.Vector的迭代与添加元素
		Vector v = new Vector();
		v.addElement("Weiyi");
		v.addElement("Geek");
		v.addElement("Java");
		Enumeration en = v.elements(); //获取枚举
		while(en.hasMoreElements()) //判断集合中是否有元素
		{
			//迭代获取集合中的元素
			System.out.print(en.nextElement() + " ");
		}
		
		
	}

}
