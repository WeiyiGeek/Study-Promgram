package com.weiyigeek;

public class StringReplace {

	public static void main(String[] args) {
		//示例1.字符串替换replace
		String s = "I love Java Programing!";
		String s1 = s.replace("o", "A");  
		String s2 = s.replace("Java", "PHP");    //如果没有找到替换字符则保留原字符串不改变;
		System.out.println("o -> A : " + s1);
		System.out.println("Java -> PHP : " + s2);
		
		//示例2.除去字符串两边的空格
		String s3 = "  Weiyi Geek  ";
		String s4 = s3.trim();
		System.out.println("两边 blank space 去除 : " + s4);
		
		
		//示例3.比较两个字符串实际将ascii码进行比较相减，如果第一个字符相减为0则,第二个字符进行相减操作直到字符串末尾;
		String s5 = "abc";
		String s6 = "bcd";
		int num = s5.compareTo(s6);  //是按照码表值进行比较
		System.out.println("s5 < s6 = " + num); // 97(a) - 98(b) = -1 
		//不区分大写比较
		int num2 = "weiyigeek".compareToIgnoreCase("WeiyiGeek");
		System.out.println("CompareToIgnoreCase 不区分大小写: " + num2);
		//java默认是utf-8码表
		int num1 = "唯".compareTo("一");
		System.out.println('唯'+0);
		System.out.println('一'+0);
		System.out.println("unicode(唯) - unicode(一) = " + num1);
		
	}

}
