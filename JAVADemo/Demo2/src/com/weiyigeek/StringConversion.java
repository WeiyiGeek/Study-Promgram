package com.weiyigeek;
public class StringConversion {
	public static void main(String[] args) {
		//示例1.探究字符串默认转换的码表，编码把我们看的懂转换为计算机看的懂的;
		demo1();
		
		//示例2.将字符串转换成为字符数组
		demo2();
		
		//示例3.将valueof任意类型的数据转换成为字符串
		char[] arr4 = {'a','b','c'};  //底层都是采用 new String() 构造方法来进行的
		String s = String.valueOf(arr4);
		System.out.println("\n" + s + ", 整形转换成为字符串 : " + String.valueOf(1024));
		
		//示例4.字符串的大小写转换并且进行拼接
		String lower = "abcd";
		String upper = "ABCD";
		System.out.println("Lower -> Upper :" + lower.toUpperCase());
		System.out.println("Upper -> Lower  :" + upper.toLowerCase());
		
		System.out.println("字符串拼接1：" + lower + upper);  //任意字符串拼接
		System.out.println("字符串拼接2：" + lower.concat(upper)); //只能字符串类型进行拼接

		//示例5.非常值得学习 把一串字符串首字母转成大写,其余为小写。(只考虑英文大小写字母字符)
		String ori = "iLOveStudyJavaPrograminG";
		String dst = ori.substring(0, 1).toUpperCase().concat(ori.substring(1).toLowerCase()); //链式编程
		System.out.println("示例5：" + dst);
		
	}

	public static void demo2() {
		String s3 = "This";
		char[] arr = s3.toCharArray();
		System.out.println("\n字符串转换成为字符数组 ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void demo1() {
		String s1 = "abc";
		String s2 = "你好,JAVA";
		
		System.out.println("英文字符：" + s1);
		byte[] arr1 = s1.getBytes();
		byte[] arr2 = s2.getBytes();
		for(int i = 0; i < arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println("\n中文字符：" + s2);
		//gbk码表表示 一个中文代表两个字节 ,gbk码表特点中文的第一个字节肯定是负数
		for(int i = 0; i < arr2.length; i++)
		{
			System.out.print(arr2[i] + " ");
		}
		//注意这里是统计的数组个数所以是length (特殊中文字符串)
		System.out.println("\n特殊中文字符：琲");
		byte[] arr3 = "琲".getBytes();
		for( int i = 0; i < arr3.length; i++)
		{
			System.out.print(arr3[i] + " ");
		}
	}

}
