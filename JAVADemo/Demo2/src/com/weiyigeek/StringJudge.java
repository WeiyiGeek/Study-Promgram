package com.weiyigeek;
public class StringJudge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʾ��1.�ж��Ƿ�Ϊ���Լ������Ƿ���ͬ���ִ�С
		String s1 = "";
		String s2 = "abc";
		String s3 = "ABC";
		System.out.println("isEmpty: " + s1.isEmpty());           //��Ϊ�շ���TRUE
		System.out.println("equals: " + s2.equals(s3));          //����FALSE�������ִ�Сд
		System.out.println("equalsIgnoreCase: " + s2.equalsIgnoreCase(s3)); //����TRUE���ڲ����ִ�Сд
		
		//ʾ��2.�ж��ַ������Ƿ������һ���ַ����Լ�ƥ�俪ͷ�ɽ�β
		String s4 = "ABC is capital,then lowercase is abc";
		System.out.println("contains: " + s4.contains(s2)); // ����Ϊtrue����S4ȷʵ����s2�ַ���
		System.out.println("startsWith: " + s4.startsWith(s3)); //����ΪTrue����s3�ַ�����s4�ַ����Ŀ�ͷ
		System.out.println("endsWith: " + s4.endsWith(s2)); //����ΪTRUE����s2�ַ�����s4�ַ��Ľ�β
	}
}
