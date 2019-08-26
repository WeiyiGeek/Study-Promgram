package com.weiyigeek.Collection;

import java.util.List;
import java.util.ArrayList;
import com.weiyi.Collection.Students;

public class Demo4_List {

	public static void main(String[] args) {
		//1.List集合功能(按照索引插入)
		List l = new ArrayList(); //注意是在java.util.List;
		l.add("Weiyi");
		l.add("Geek");
		l.add("Love");
		l.add("Java");
		l.add(0,"Start"); //头部插入  INDEX <= SIZE 并且 Index >= 0 不会报索引异常
		l.add(5,"END");  //尾部插入
		System.out.println(l);
		
		//示例2.通过索引删除元素并且其返回
		Object demo1 = l.remove(3); //删除Love - 注意:删除的时候不会自动装箱
		System.out.println(l + " 删除的集合元素是 " + demo1);
		
		//示例3.根据索引获取元素
		Object demo2 = l.get(1);
		System.out.println("获取指定的索引的集合元素 ：" + demo2 + l.get(2));
		//通过索引遍历List集合;
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " - ");
		}
		
		//示例4.根据索引进行指定位置元素进行修改
		l.set(3, "Editer");
		System.out.println("\n修改后的集合元素 : " + l);
		
		//综合实例
		//向List集合中存储学生对象然后通过size和get()方法结合遍历
		List list = new ArrayList();
		list.add(new Students("Weiyi",28));
		list.add(new Students("Geek",32));

		for (int i = 0; i < list.size(); i++) {
			//存储自定义对象通过size()和get()方式获取
			Students s = (Students)list.get(i); //向下引用
			System.out.println(i + " - " + s.getName() + " " + s.getAge());
		}
	}
}
