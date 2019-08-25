package com.weiyigeek.regex;

import java.util.Arrays;

public class Demo2_Regex {
	public static void main(String[] args) {
		//示例1.字符组
		System.out.println("演示1：" + "a".matches("[a-zA-Z]"));
		System.out.println("演示2：" + "p".matches("[a-c[o-z]]")); //并集
		System.out.println("演示3：" + "d".matches("[a-z && [def]]")); //交集
		System.out.println("演示4：" + "abcdABCD".matches("[a-z && [^cd]]")); //补集
		System.out.println("演示5：" + "c".matches("[a-z && [^c-z]]")); //补集
		
		//示例2.任何字符
		System.out.println("示例1 = " + "r".matches("."));  
		System.out.println("示例2 = " + "e".matches("\\S")); //注意是双斜线
		System.out.println("示例3 = " + "g".matches("\\s")); //注意是双斜线
		System.out.println("示例4 = " + "0".matches("\\d"));
		System.out.println("示例5 = " + "e".matches("\\w"));
		System.out.println("示例6 = " + " ".matches("\\W"));

		//示例3.greedy数量词
		System.out.println("案例1 - " + "a".matches("[abc]?"));
		System.out.println("案例2 - " + "".matches("[abc]?"));     //为空
		System.out.println("案例3 - " + "r".matches("[abc]+"));
		System.out.println("案例4 - " + "abcabc".matches("[abc]*"));
		System.out.println("案例5 - " + "abc".matches("[abc]{0,3}"));

		//示例1.字符串分割采用正则表达式
		strSpilt("I.LOVE.JAVA");
		strSpiltInteger("91 48 75 76 82 10"); //字符串分割并且进行比较排序
		
		
		//示例2.正则表达式的替换功能(将数字替换掉)
		System.out.println("字符串正则替换 : " + "We1iyi12Geek556".replaceAll("\\d",""));
		
	}

	private static void strSpilt(String str) {
		String[] arr0 = str.split("\\.");  //关键点 1
		String[] arr1 = str.split("[.]");  //关键点 2
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("###########################");
	}
	
	private static void strSpiltInteger(String st) {
		/**
		   *  分析：
		 * 1.将字符串转换成字符串数组
		 * 2.将字符串转换成为数字并且存储在一个等长度的int数组中
		 * 3.排序
		 * 4.将排序后的结构钢遍历并拼接成为一个字符串;
		 * */
		String[] sArr = st.split(" ");
		int[] iArr = new int[sArr.length]; //建立一个整形数组长度为字符串数组长度
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = Integer.valueOf(sArr[i]);  //将字符串转换成为数字
		}
		
		Arrays.sort(iArr);
		
		StringBuilder res = new StringBuilder();
		res.append("[ ");
		for (int i = 0; i < iArr.length; i++) {
			if( i == iArr.length - 1)
			{
				res.append(iArr[i] + " ]");
			}else{
				res.append(iArr[i] + " ");
			}
		}
		System.out.println(res);
	}
}
