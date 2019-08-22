package com.weiyigeek.stringbuffer;

public class Demo1_StringBufeer {

	public static void main(String[] args) {
		//示例1.StringBuffer的三种构造方法
		StringBuffer sb1 = new StringBuffer();
		System.out.println("空参构造 理论长度 : "+sb1.capacity() +", 实际长度 : "+sb1.length());
		
		StringBuffer sb2 = new StringBuffer(10);  //设置一个缓冲区初始量
		System.out.println("有参构造 理论长度 : "+sb2.capacity() +", 实际长度 : "+sb2.length());
		
		StringBuffer sb3 = new StringBuffer("Java");
		System.out.println("有参构造 理论长度 : "+sb3.capacity() +", 实际长度 : "+sb3.length()); //capacity() = 初始量(16) + 字符串长度(4) 
		
		
		//示例2.StringBuffer的增加字符串
		StringBuffer sb4 = new StringBuffer();  
		StringBuffer sb5 = sb4.append(true);
		StringBuffer sb6 = sb4.append("WeiyiGeek");
		//后面的多个引用其实指向同一个对象,并且该类中重写了toString方法
		System.out.println("append方法   理论长度 : "+sb5.capacity() +", 实际长度 : "+sb5.length() + ", 值为 " + sb5.toString()); //capacity() = 初始量(16) + 字符串长度(4) 
		System.out.println("append方法   理论长度 : "+sb6.capacity() +", 实际长度 : "+sb6.length() + ", 值为 " + sb6.toString()); //capacity() = 初始量(16) + 字符串长度(4) 

		
		//示例3.StringBuffer的指定位置添加字符元素
		StringBuffer sb7 = new StringBuffer("Iloveprogramming!"); //注意这里缓冲区初始量是 16 + 17个字符 = 33
		sb7.insert(5, "java"); //索引是从0开始，在指定位置添加字符串元素,如果没有指定位置的索引便会报索引越界异常;
		System.out.println("insert方法  理论长度 : "+sb7.capacity() +", 实际长度 : "+sb7.length() + ", 值为 " + sb7.toString()); //capacity() = 初始量(16) + 字符串长度(4) 

		
		//示例4.StringBuffer删除功能
		sb7.deleteCharAt(16); //删除sb7字符串中的一个m
		System.out.println("deleteCharAt 方 法 : " + sb7);
		sb7.delete(0, 5); //删除字符Ilove，删除时候是包含头但不包含尾0~5
		System.out.println("delete 方法 : " + sb7);
		sb7.delete(0,sb7.length()); //清空缓存区
		System.out.println("delete 方法   理论长度 : "+sb7.capacity() +", 实际长度 : "+sb7.length() + ", 值为 空" + sb7.toString()); //capacity() = 初始量(16) + 字符串长度(4) 

		sb7 = new StringBuffer(); //不要用,原来的变成垃圾浪费内存
		System.out.println("[不推荐这种方式清空缓冲区]理论长度 : "+sb7.capacity() +", 实际长度 : "+sb7.length());

		
		//示例5.StringBuffer的替换与反转功能
		StringBuffer sb8 = new StringBuffer("My Name is Weiyi");
		sb8.replace(sb8.length()-5, sb8.length(), "Geek");
		System.out.println("replace 方法: " + sb8.toString());
		System.out.println("reverse 方法: " + sb8.reverse());

		//实例6.StringBuffer字符串截取功能呢
		StringBuffer sb9 = new StringBuffer("I'am weiyigeek!");
		String subdemo1 = sb9.substring(5);  //截取从第六个字符到末尾
		String subdemo2 = sb9.substring(5,10); //截取从第6个字符开始截取直到底十的字符结束;
		System.out.println("SubDemo1 = " + subdemo1 + ", SubDemo2 = " + subdemo2);
	}
}