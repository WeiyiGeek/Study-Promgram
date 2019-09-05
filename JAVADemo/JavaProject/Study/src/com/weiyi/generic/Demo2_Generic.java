package com.weiyi.generic;

public class Demo2_Generic {

	public static void main(String[] args) {
		//示例1.泛型类的使用
		Tools<String> tls = new Tools<>();
		tls.show("Hello World!");
		tls.showMethod("Yes");
		tls.showStatic("Generic");
		
		//示例2.接口泛型
		Demo d1 = new Demo();
		d1.show("Interfaces");
		
		Demo1<String> d2 = new Demo1();
		d2.show("Interfaces");
	}
}

//示例1.泛型类(一个字符大写 常用E)
class Tools<Q> {
	private Q obj;  //泛型传入是什么类型就是什么类型

	public Q getObj() {
		return obj;
	}

	public void setObj(Q obj) {
		this.obj = obj;
	}
	
	public void show(Q str) {
		System.out.println("类泛型:"+str);
	}
	
	//示例2.方法泛型最好与类的泛型是一致,如果不一致需要在方法上声明该泛型
	public<T> void showMethod(T t) {
		System.out.println("方法泛型:"+t); 
	}
	
	//示例3.注意:类中静态方法随着类的加载而加载,在加载的时候可能还没出现对象;所以说在静态方法泛型上也必须声明自己的泛型
	public static<W> void showStatic(W w) {
		System.out.println("静态方法泛型:"+w);
	}
	
}


//示例2.泛型接口(一个字符大写 常用E)
interface Inter<T> {
	public void show(T t);
}
//方式1：推荐方式
class Demo implements Inter<String> {
	@Override
	public void show(String t) {
		System.out.println("泛型接口-示例1:"+t);
	}
}
//方式2：没有必要在使用接口的时候指定泛型
class Demo1<T> implements Inter<T>
{
	@Override
	public void show(T t) {
		System.out.println("泛型接口-示例2:"+t);
	}
}
