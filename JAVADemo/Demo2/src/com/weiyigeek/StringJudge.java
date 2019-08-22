package com.weiyigeek;
public class StringJudge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//示例1.判断是否为空以及内容是否相同区分大小
		String s1 = "";
		String s2 = "abc";
		String s3 = "ABC";
		System.out.println("isEmpty: " + s1.isEmpty());           //是为空返回TRUE
		System.out.println("equals: " + s2.equals(s3));          //返回FALSE由于区分大小写
		System.out.println("equalsIgnoreCase: " + s2.equalsIgnoreCase(s3)); //返回TRUE由于不区分大小写
		
		//示例2.判断字符串中是否包含另一个字符串以及匹配开头可结尾
		String s4 = "ABC is capital,then lowercase is abc";
		System.out.println("contains: " + s4.contains(s2)); // 返回为true由于S4确实包含s2字符串
		System.out.println("startsWith: " + s4.startsWith(s3)); //返回为True由于s3字符串是s4字符串的开头
		System.out.println("endsWith: " + s4.endsWith(s2)); //返回为TRUE由于s2字符串是s4字符的结尾
	}
}
