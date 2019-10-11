package com.weiyigeek.ioadvance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Demo4_ObjectIO {

	public static void main(String[] args) throws  IOException, ClassNotFoundException {
		// 示例1.实现对象的序列化和反序列化
		demo1();
	
		
		// 示例2:优化对象的序列化和反序列化
		demo2();

	}


	public static void demo1() throws IOException, FileNotFoundException, ClassNotFoundException {
		System.out.println("#示例1.实现对象的序列化和反序列化");
		// (1)实例化对象
		Personer p1 = new Personer("Java",23);
		Personer p2 = new Personer("C",40);
		
		// (2)创建对象输出流将对象序列化写出到对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\object.txt"));
		
		// (3)将实例化对象经过序列化写入到object.txt中
		oos.writeObject(p1);
		oos.writeObject(p2);
		
		// (4)关闭操作对象输出流
		oos.close();
		
		// (5)创建操作对象输入流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\object.txt"));
		
		// (6)饭序列号读取对象(注意这里没执行一次readObject便是读取一个对象,但是如果读到末尾还在读会出现EOFException异常);
		// 记住需要向下转型（需要添加类不存在的异常）
		Personer fp1 = (Personer) ois.readObject();
		Personer fp2 = (Personer) ois.readObject();
		
		System.out.println("fp1 = " + fp1);
		System.out.println("fp2 = " + fp2);
		
		// (7)关闭操作对象输入流
		ois.close();
	}

	public static void demo2() throws IOException, FileNotFoundException, ClassNotFoundException {
		System.out.println("示例2:优化对象的序列化和反序列化");
		// 采用集合方式存储对象然后经过对象输出流的writeObject一次将对象写成
		Personer p1 = new Personer("张三",15);
		Personer p2 = new Personer("李四",16);
		Personer p3 = new Personer("王五",17);
		Personer p4 = new Personer("雅虎",65);

		ArrayList<Personer> list = new ArrayList<Personer>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		//创建操作输出流并关联object.txt文件
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\object.txt"));
		oos.writeObject(list); //将集合对象一次性写入
		oos.close();
		
		//反序列化读取
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\object.txt"));
		//建立一个arraylist集合接收存储的对象
		//泛型在运行期会被擦除,索引运行期相当于没有泛型
		@SuppressWarnings("unchecked")
		ArrayList<Personer> res = (ArrayList<Personer>) ois.readObject(); //将集合对象一次读取
		//遍历输出反序列对象
		for (Personer person : res) {
			System.out.println(person);
		}
		ois.close();
	}
}

//序列化对象声明定义
class Personer implements Serializable {
	private String name;
	private int age;
	public Personer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Personer [name=" + name + ", age=" + age + "]";
	}
}