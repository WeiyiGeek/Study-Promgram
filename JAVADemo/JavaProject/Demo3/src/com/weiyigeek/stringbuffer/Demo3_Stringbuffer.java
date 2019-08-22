package com.weiyigeek.stringbuffer;

import java.util.Scanner;

public class Demo3_Stringbuffer {
	public static void main(String[] args) {
		//实例1. 利用StringBuffer将数组转换成为字符串; "[1,2,3]"形式
		int[] arr = {1,2,3};
		System.out.println(arrayToString(arr));
		
		
		//实例2.键盘录入反转
		Scanner sc = new Scanner(System.in);  //创建一个键盘录入对象
		System.out.print("请输入一串字符: ");
		String line = sc.nextLine();  //将键盘录入的字符串存储到line中
		StringBuffer sb = reverseStr(line);
		System.out.println("缓存区的内容反转  : " + sb);

		//实例3.反转字符串数组并输出特定格式
		String[] arr1 = {"Study","Java","Programming"};
		System.out.println(changeStrReverse(arr1));
		
	}

	//实例1.抽取方法
	private static String arrayToString(int[] arr) {
		StringBuffer sb1 = new StringBuffer();  //创建缓冲区对象(节省内存-不需要重复的申请对象提高效率)
		sb1.append("[");
		for(int i = 0; i < arr.length; i++)  //遍历数组
		{
			if( i == arr.length-1 ){
				sb1.append(arr[i]).append("]");  //[推荐形式]
			}else {
				sb1.append(arr[i] + ",");  //只有这种形式不推荐(底层还是new string然后toString()),所以还是建议采用append的方法
			}
		}
		return sb1.toString();
	}
	
	//实例2.抽取方法
	public static StringBuffer reverseStr(String line) {
		StringBuffer sb = new StringBuffer(line); //重点,将输入的字符串放入缓存区之中
		sb.reverse(); //注意操作是sb对象本身
		return sb;
	}
	
	//实例3. 抽取方法 (这里返回方法采用StringBuffer减少一次String对象申请)
	private static StringBuffer changeStrReverse(String[] arr1) {
		StringBuffer sb2 = new StringBuffer();
		sb2.append("{");
		for (int i = 0; i < arr1.length; i++) {
			if( i == arr1.length - 1)
			{
				sb2.append(reverseStr(arr1[i])).append("}");
			}else {
				sb2.append(reverseStr(arr1[i])).append(",");
			}
		}
		return sb2;
	}

}
