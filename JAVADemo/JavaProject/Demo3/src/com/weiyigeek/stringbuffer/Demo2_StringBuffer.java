package com.weiyigeek.stringbuffer;
public class Demo2_StringBuffer {
	public static void main(String[] args) {
		//实例1.StringBuffer类与String类相互转换
		//String -> StringBuffer对象 : 通过构造方法 或者 append() 方法;
		StringBuffer sb1 = new StringBuffer("initialize 初始化"); //通过String对象转换成为StringBuffer对象;
		StringBuffer sb2 = new StringBuffer();
		sb2.append("initialize append");
		System.out.println("方法1 : " + sb1);
		System.out.println("方法2 : " + sb2);

		//StringBuferr -> String : 通过构造方法 或者 toString() 方法 或者 subString(0, length)
		String s1 = new String(sb1);
		String s2 = sb1.toString();
		String s3 = sb1.substring(0, 10);
		System.out.println("方法1 = " + s1);
		System.out.println("方法2 = " + s2);
		System.out.println("方法3 = " + s3);
		
		
		//实例2.String和Stringbuffer分别作为参数传递问题
		String s4 = "String parma";
		System.out.println("源字符串 : " + s4);
		changeStr(s4);  //一弹栈就内部的s4就变成了垃圾，也由于String一旦初始化将不会被改变
		System.out.println("changeStr 方法外: " + s4);
		
		StringBuffer sb3 = new StringBuffer();  //两个引用指向同一个对象;
		sb3.append("append 1");
		System.out.println("第一次引用 : " + sb3);
		changeStrBuf(sb3);
		System.out.println("第二次引用(经过changeStrBuf) : " + sb3);
		
	}

	private static void changeStrBuf(StringBuffer sb3) {
		sb3.append(",append 2");
	}

	private static void changeStr(String s4) {
		s4 += "add";
		System.out.println("changeStr 方法内 :  " + s4);
	}

}
