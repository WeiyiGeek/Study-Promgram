package com.weiyigeek.reflect;
import com.weiyi.Collection.Students;
public class Demo1_Reflect {
	public static void main(String[] args) throws Exception {
		//1.获取Class文件对象的三种红方式
		Class clazz1 = Class.forName("com.weiyi.Collection.Students"); //方式1
		Class clazz2 = Students.class; //方式2
		
		Students clazz = new Students();
		Class clazz3 = clazz.getClass(); //方式3
		
		//判断获取的三种方式的class对象是否相同(都是想相同的只不过处于三种不同的阶段)
		System.out.println(clazz1 == clazz2);  //true
		System.out.println(clazz3 == clazz2);  //true
	}
}
