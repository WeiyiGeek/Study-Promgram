package com.weiyigeek.Collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Demo8_Properties {
	public static void main(String[] args) throws IOException {
		// 示例1.Properties集合使用虽然是双列集合但是没有泛型
		demo1();
		
		// 示例2.Properties的load()和store()功能
		/***
		 * config.properties
		 * name=weiyigeek
		 * age=23
		 * qq=123456
		 */
		Properties prop = new Properties();
		System.out.println("\n load方法读取文件 ; ");
		System.out.println("读取之前:" + prop);
		prop.load(new FileInputStream("d:\\config.properties"));
		System.out.println("读取之后:" + prop);
		
		prop.setProperty("add", "JavaPram");
		prop.setProperty("qq", "88888888");  //修改文件中的qq键的值
		System.out.println("\n store方法存储文件 ; ");
		prop.store(new FileOutputStream("d:\\config.properties"), "[2019年10月11日 17点57分]  插入和修改值");  //第二个参数是注释Unicode编码
		
		System.out.println("修改之后:" + prop);
	}

	public static void demo1() {
		Properties pr = new Properties();
		pr.put("Key", 1024);
		pr.put("Name", "WeiyiGeek");
		pr.setProperty("Age", "13"); //设置属性值(两个值必须是String);
		System.out.println(pr);  //打印键和值
		
		// 打印所有的键值(采用枚举)
		Enumeration<String> key = (Enumeration<String>) pr.propertyNames(); //获取所有键的名称
		while(key.hasMoreElements())
		{
			String name = key.nextElement();
			System.out.println(name + " = " + pr.getProperty(name));
		}
	}	
}

//执行结果
//{Name=WeiyiGeek, Key=1024, Age=13}
//Key = null
//Name = WeiyiGeek
//Age = 13
//
// load方法读取文件 ; 
//读取之前:{}
//读取之后:{age=23, qq=123456789, name=weiyigeek}
//
// store方法存储文件 ; 
//修改之后:{age=23, qq=88888888, name=weiyigeek, add=JavaPram}

