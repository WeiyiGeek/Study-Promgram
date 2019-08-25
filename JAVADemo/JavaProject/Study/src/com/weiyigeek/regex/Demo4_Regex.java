package com.weiyigeek.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo4_Regex {

	public static void main(String[] args) {
		//示例1.Pattern类的简单实用
		Pattern p = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE); //获取正则表达式不区分大小写 (方式1)
		Matcher m = p.matcher("AABBB"); //获取适配器
		boolean b1 = m.matches();  //判断是否能进行匹配
		boolean b2 = Pattern.compile("[a-z]+").matcher("AABBB").matches(); //方法2 链式匹配
		System.out.println("方式1 的结果 : " + b1);
		System.out.println("方式2 的结果 : " + b2);
		
		//示例2.Pattern和Matcher的结合使用进行 手机号正则匹配
		String s = "我的手机号是:18983441325, 曾经用过18487258412, 还用过18883420241";
		Matcher m1 = Pattern.compile("1[456789]\\d{9}").matcher(s);
		//注意要先找再获取注意这里的find获取了一个便会从下一个位置进行查找
		System.out.println("提取到的电话号码:");
		while(m1.find())
			System.out.println(m1.group());
	}
}
