/**
 * 榨汁机Juicer示例：采用反射Class.forName()配置文件读取
 * Fruit 水果接口
 * Apple 、 Orange 、 Banana
 * squeeze 榨汁
 */
package com.weiyigeek.reflect;

import java.io.BufferedReader;
import java.io.FileReader;

public class Demo2_ReflectForName {
	public static void main(String[] args) throws Exception {
		Juicer j = new Juicer(); //相当于购买榨汁机
		//采用反射进行配置文件读取config.properties
		BufferedReader br = new BufferedReader(new FileReader("config.properties")); //配置文件中读取class对象
		
		//苹果 /橘子 (非常值得学习)
		String line;
		while((line = br.readLine()) != null) {
			Class clazz2 = Class.forName(line);   //读取一行 => 包.类名 要使用其他的时候直接更改名称即可
			Fruit o= (Fruit) clazz2.newInstance(); //向上转型 父类引用指向子类对象(创建一个新的对象)，水果的引用指向评估 j.run(f);
			j.run(o);
		}
	}
}

//水果接口
interface Fruit {
	public void squeeze();
}
//苹果汁
class Apple implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("这是一杯 苹果 汁");
	}
}
//橘子汁
class Orange implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("这是一杯 橘子 汁");
	}
	
}
//香蕉汁
class Banana implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("这是一杯 香蕉 汁");
	}
}

//榨汁机类
class Juicer {
	public void run(Fruit a){
		a.squeeze();
	}
}
