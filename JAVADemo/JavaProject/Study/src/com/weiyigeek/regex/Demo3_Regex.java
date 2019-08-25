package com.weiyigeek.regex;
public class Demo3_Regex {
	public static void main(String[] args) {
		//示例1.分组的使用(正则叠词) 开开心心,快快乐乐
		System.out.println("示例1-1 : " + "开开心心".matches("(.)\\1(.)\\2"));
		System.out.println("示例1-2 : " + "开心开心".matches("(..)\\1"));
		
		//示例2.切割需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
		String str = new String("sdqqfgkkkhjppppkl");
		String[] Arr = str.split("(.)\\1+");
		for (int i = 0; i < Arr.length; i++) {
			System.out.println(Arr[i]);
		}
		
		//示例3.替换需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程将字符串还原成:“我要学编程”。
		String s1 = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
		String res = s1.replaceAll("\\.", "").replaceAll("(.)\\1\\1", "");  //方式1
		String res1 = s1.replaceAll("\\.", "").replaceAll("(.)\\1+", "$1");  //方式2 (这里采用$1代替捕获的值得学习)
		System.out.println(res + "\n" + res1);
	}
}
