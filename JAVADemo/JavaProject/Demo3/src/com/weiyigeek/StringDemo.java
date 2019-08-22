package com.weiyigeek;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#示例1.字符串是不可更改的,除了 字符串缓冲区支持可变字符串
		String str = "abcdefg"; //字符串对象
		System.out.println(str);  //输出字符串
		System.out.println(str.toString()); //String类重写了toString方法返回的是该对象本身;
		
		//#示例2.字符串是常量一旦被赋值将不能被改变
		str = "重新赋值,原来的字符串就变成垃圾等待被回收!";
		System.out.println(str);
		
		//#示例3.String类的构造方法
		byte[] arr1 = {48, 65, 97};
		String s1 = new String(arr1); //通过使用平台的默认字符集解码指定的字节数组来构造新的 String
		System.out.println(s1);
		
		byte[] arr2 = {97,98,99,100,101,102};
		String s2 = new String(arr2,2,3); //从arr2数组中第三个元素开始解码转换3个
		System.out.println(s2);
		
		char[] arr3 = {'a','b','c','d','e'}; //字符数组转换成为字符串
		String s3 = new String(arr3);
		System.out.println(s3);
	
		String s4 = new String(arr3,2,2); //字符数组从指定位置开始转多少个
		System.out.println(s4);
		
		String s5 = new String("WeiyiGeek");
		System.out.println(s5);
		
		//示例3.面试题
		extracted();
		stackFinal();
	    diffrenent();
	}



	//常量池中没有这个字符串对象就创建,如果有就直接引用即可(相同地址)
	private static void extracted() {
		String a1 = "abc";
		String b1 = "abc";
		System.out.println("方式1："+(a1 == b1));   //我们前面知道 == 号默认比较的是对象地址,这里由于字符串是常量实际a1与b1指向同一个;
		System.out.println("方式2："+b1.equals(a1));
	}

	//常量池中的地址与堆内存中的地址是不一样的;
	private static void stackFinal() {
		String s1 = new String("abc");	 //记录的是堆内存的地址值		
		String s2 = "abc";               //记录是常量池中的地址值
		System.out.println(s1 == s2);    // == 比较的是地址
		System.out.println(s1.equals(s2));  //比较的是字符串
	}
	
	//字符串串联符号+以及将其他对象转换为字符串
	private static void diffrenent() {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c"; //经过StringBuffer 再使用toString转换成String ; 所以地址是不同的
		System.out.println("方式1：" + (s3 == s2));  
		System.out.println("方式2：" + s3.equals(s2));
	}
}
