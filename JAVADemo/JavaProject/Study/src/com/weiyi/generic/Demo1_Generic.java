package com.weiyi.generic;
import java.util.ArrayList;
import java.util.Iterator;

//引用我们students类
import com.weiyi.Collection.Students;

public class Demo1_Generic {
	public static void main(String[] args) {
		//示例0.泛型的使用(字符串类型)
		ArrayList<String> list = new ArrayList<>(); //泛型可以省略不写(1.7的新特性菱形泛型)
		list.add("a");
		list.add("b");
		list.add("c");
		
		Iterator<String> llt = list.iterator();
		while(llt.hasNext()) {
			System.out.println(llt.next());
		}
		
		//示例1.ArrayList存储字符串并遍历泛型版
		ArrayList<Students> lt = new ArrayList<Students>();//关键点1 数据引用类型一定要相同,后面也可以是前引用类型的子类或者父类
		lt.add(new Students("渣渣辉",25));
		lt.add(new Students("掌门人",22));
		lt.add(new Students("柳师傅",21));
		
		Iterator<Students> ltr = lt.iterator(); //关键点2(注意泛型集合是什么类型,迭代器便是什么类型)
		while(ltr.hasNext())
		{
			Students obj = ltr.next(); //这里不用强转
			System.out.println(obj.getName() +" ---- "+ obj.getAge()); //注意这里如果调用一次.next()指向的就是下一个对象
		}
		/***
		 * 执行结果：
		 * 渣渣辉 ---- 25
		 * 掌门人 ---- 22
		 * 柳师傅 ---- 21
		 **/
		
		//示例2.泛型的由来:通过Object转型问题引入
		/* 早期的Object类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。
		 * 也就存在这隐患，所以Java提供了泛型来解决这个安全问题。
		 **/
		Tool t = new Tool(); //创建工具类对象
		t.setObj(new Person("张三",24)); //父类指向子类对象
		
		Worker w = (Worker) t.getObj(); //向下转型
		System.out.println(w); //会出现ClassCastException
		//其实泛型就像是种瓜得瓜种豆得豆一样
		/***执行结果
		 * Exception in thread "main" java.lang.ClassCastException: com.weiyi.generic.Person cannot be cast to com.weiyi.generic.Worker
	at com.weiyi.generic.Demo1_Generic.main(Demo1_Generic.java:47)
		 */
	}
}

//示例2演示
class Tool{
	private Object obj;
	//alt + shift + s + r
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;   //父类引用子类对象
	}
}

//继承类
class Person extends Students {

	public Person() {
		super();
	}
	public Person(String name, int age) {
		super(name, age);
	}
}

class Worker extends Students {

	public Worker() {
		super();
	}

	public Worker(String name, int age) {
		super(name, age);
	}
}