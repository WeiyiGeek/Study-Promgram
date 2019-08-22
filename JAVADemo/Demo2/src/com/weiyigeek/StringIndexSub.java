package com.weiyigeek;

public class StringIndexSub {
	public static void main(String[] args) {
		//示例1.字符串长度length()其实是获取每一个字符的个数，不管中英文
		String s1 = "WeiyiGeek";
		String s2 = "我是一名java开发者";
		System.out.println("English Text is "+s1+", Length = " +s1.length());
		System.out.println("Chinese Text is "+s2+", Length = " +s2.length());
		
		
		//示例2.获取指定索引的字符或者记录字符出现的索引(+ 如果不加""默认是将字符解码成为ascii序号并进行相加)
		System.out.println(s1.charAt(0)+""+s1.charAt(1)+""+s1.charAt(2)+""+s1.charAt(3)+""+s1.charAt(4));
		System.out.println("Index : " + s2.indexOf('j'));   //参数接收的是int类型，传递char类型会自动提升；
		System.out.println("Index : " + s2.indexOf("java")); //如果不存在则返回 -1
		System.out.println("Index : " + s2.indexOf("开发者",5)+"\n"); //指定位置开始从前向后找
		
		System.out.println("lastIndex : " + s2.lastIndexOf('j')); //从后向前找第一次出现的字符串
		System.out.println("lastIndex : " + s1.lastIndexOf("e", 7)); //从指定位置向前找(注意这里是指定的位置任然是从字符开头到结尾数)
		System.out.println("lastIndex : " + s2.lastIndexOf("java",4)+"\n"); //从第4个位置进行查找匹配
		
		//示例3.指定截取字符串
		System.out.println("My Name is " + s1.substring(0, 5) + ", I am is " + s1.substring(5)); //指定位置截取到末尾
		//关键点：注意字符串有些方法会在字符串上进行操作,有的不在字符串本身进行操作(substring)不会改变源字符串;
		
		//示例4.字符串的遍历，通过for循环获取到字符串中每个字符的索引;
		String Demo = "Hacker";
		for(int i = 0; i < Demo.length(); i++)
		{
			System.out.println(Demo.charAt(i));
		}
		
		//实际案例
		countNumber();
	}
	
	//统计字符串中大小写，字符串字符以及数字字符出现此时
	public static void countNumber() {
		String s = "abcdefABCDE123456!@#$%%^";
		int cap = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if( c >= 'a' && c <= 'z'){
				small++;
			}else if(c >= 'A' && c <= 'Z'){
				cap++;
			}else if(c >= '0' && c <= '9'){
				num++;
			}else {
				other++;
			}
		}
		System.out.println("大写字母个数: " + cap + ", 小写字母个数: " + small + ", 数字个数: " + num + ", 其他字符数量" + other);
	}
}
