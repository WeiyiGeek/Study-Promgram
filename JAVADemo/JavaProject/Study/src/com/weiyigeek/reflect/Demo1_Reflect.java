package com.weiyigeek.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.weiyi.Collection.Students;
public class Demo1_Reflect {
	public static void main(String[] args) throws Exception {
		//1.获取Class文件对象的三种红方式
		Class clazz1 = Class.forName("com.weiyi.Collection.Students"); //方式1 获取一个类的字节码文件
		Class clazz2 = Students.class; //方式2
		
		Students clazz = new Students();
		Class clazz3 = clazz.getClass(); //方式3
		
		//判断获取的三种方式的class对象是否相同(都是想相同的只不过处于三种不同的阶段)
		System.out.println(clazz1 == clazz2);  //true
		System.out.println(clazz3 == clazz2);  //true
		
		
		//2.反射获取带参数的构造方法并使用
		//Class clazz4 = Class.forName("com.weiyigeek.Collection.Students"); //[Error]重复加载反射类会报错
		Constructor<Students> cs = clazz1.getConstructor(String.class,int.class); //获取有参构造
		Students s = (Students) cs.newInstance("有参构造",1024);  //重点。利用有参构造创建对象
		System.out.println(s);
		
		
		//3.通过反射获取成员变量并使用
		//公共成员变量的时候
		//Field demo = clazz1.getField("name");
		//demo.set(s, "王三");
		
		//私有成员变量的时候
		Field f = clazz1.getDeclaredField("name"); //暴力获取字段name
		f.setAccessible(true); //去除私有属性
		f.set(s, "Field");
		System.out.println(s);
		
		
		//4.通过反射获取方法
		Method m = clazz1.getMethod("reflectDemo"); //获取类中的方法
		m.invoke(s); //执行无参方法reflectDemo
		Method m1 = clazz1.getMethod("reflectDemo", int.class); //获取有参数方式
		m1.invoke(s, 1024);
		
		
		//5.通过反射越过泛型检测
		//ArrayList <Integer>的一个对象，在这个集合中添加一个字符串数据如何实现的呢?
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		//注意这里由于泛型的特性不能加入字符串 "abc"
		//list.add("abc")
		//但是我们可以通过反射Reflect特性来添加
		Class clazz6 = Class.forName("java.util.ArrayList"); //获取ArrayList字节码对象
		Method m2 = clazz6.getMethod("add",Object.class); //获取add方法
		m2.invoke(list, "abc");
		System.out.println("反射绕过泛型: " + list);
	}
}
