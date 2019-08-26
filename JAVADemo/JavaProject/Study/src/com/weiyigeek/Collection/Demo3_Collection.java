package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import com.weiyi.Collection.Students;

@SuppressWarnings("rawtypes")

public class Demo3_Collection {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//示例1.对集合中的元素进行迭代遍历
		Collection c = new ArrayList();
		c.add("Weiyi");
		c.add("Geek");
		c.add("1024");
		c.add("Java");
		Iterator it = c.iterator(); //获取迭代器
		boolean bl = it.hasNext(); //判断集合中是否有元素,有则返回true;
		Object obj = it.next();  //指针会记录当前位置向后移位;
		System.out.print(bl + " ");
		System.out.println(obj); //输入集合中第一个元素
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		

		//示例2.通过while循环来迭代集合数组
		Collection c1 = new ArrayList();
		c1.add(new Students("张伟", 15)); //父类引用指向子类对象
		c1.add(new Students("张杰", 29)); //Object obj = new Student
		c1.add(new Students("张根硕", 35));
		c1.add(new Students("大张伟", 25));
		Iterator it1 = c1.iterator();
		//Collection存储自定义对象并用迭代器遍历
		while(it1.hasNext())
		{
			Students s = (Students)it1.next(); //向下转型 强转
			System.out.println(s.getName() + " " + s.getAge());
		}
	}
}
