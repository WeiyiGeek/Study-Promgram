package com.weiyigeek.stringbuffer;

public class Demo1_StringBufeer {

	public static void main(String[] args) {
		//ʾ��1.StringBuffer�����ֹ��췽��
		StringBuffer sb1 = new StringBuffer();
		System.out.println("�ղι��� ���۳��� : "+sb1.capacity() +", ʵ�ʳ��� : "+sb1.length());
		
		StringBuffer sb2 = new StringBuffer(10);  //����һ����������ʼ��
		System.out.println("�вι��� ���۳��� : "+sb2.capacity() +", ʵ�ʳ��� : "+sb2.length());
		
		StringBuffer sb3 = new StringBuffer("Java");
		System.out.println("�вι��� ���۳��� : "+sb3.capacity() +", ʵ�ʳ��� : "+sb3.length()); //capacity() = ��ʼ��(16) + �ַ�������(4) 
		
		
		//ʾ��2.StringBuffer�������ַ���
		StringBuffer sb4 = new StringBuffer();  
		StringBuffer sb5 = sb4.append(true);
		StringBuffer sb6 = sb4.append("WeiyiGeek");
		//����Ķ��������ʵָ��ͬһ������,���Ҹ�������д��toString����
		System.out.println("append����   ���۳��� : "+sb5.capacity() +", ʵ�ʳ��� : "+sb5.length() + ", ֵΪ " + sb5.toString()); //capacity() = ��ʼ��(16) + �ַ�������(4) 
		System.out.println("append����   ���۳��� : "+sb6.capacity() +", ʵ�ʳ��� : "+sb6.length() + ", ֵΪ " + sb6.toString()); //capacity() = ��ʼ��(16) + �ַ�������(4) 

		
		//ʾ��3.StringBuffer��ָ��λ������ַ�Ԫ��
		StringBuffer sb7 = new StringBuffer("Iloveprogramming!"); //ע�����ﻺ������ʼ���� 16 + 17���ַ� = 33
		sb7.insert(5, "java"); //�����Ǵ�0��ʼ����ָ��λ������ַ���Ԫ��,���û��ָ��λ�õ�������ᱨ����Խ���쳣;
		System.out.println("insert����  ���۳��� : "+sb7.capacity() +", ʵ�ʳ��� : "+sb7.length() + ", ֵΪ " + sb7.toString()); //capacity() = ��ʼ��(16) + �ַ�������(4) 

		
		//ʾ��4.StringBufferɾ������
		sb7.deleteCharAt(16); //ɾ��sb7�ַ����е�һ��m
		System.out.println("deleteCharAt �� �� : " + sb7);
		sb7.delete(0, 5); //ɾ���ַ�Ilove��ɾ��ʱ���ǰ���ͷ��������β0~5
		System.out.println("delete ���� : " + sb7);
		sb7.delete(0,sb7.length()); //��ջ�����
		System.out.println("delete ����   ���۳��� : "+sb7.capacity() +", ʵ�ʳ��� : "+sb7.length() + ", ֵΪ ��" + sb7.toString()); //capacity() = ��ʼ��(16) + �ַ�������(4) 

		sb7 = new StringBuffer(); //��Ҫ��,ԭ���ı�������˷��ڴ�
		System.out.println("[���Ƽ����ַ�ʽ��ջ�����]���۳��� : "+sb7.capacity() +", ʵ�ʳ��� : "+sb7.length());

		
		//ʾ��5.StringBuffer���滻�뷴ת����
		StringBuffer sb8 = new StringBuffer("My Name is Weiyi");
		sb8.replace(sb8.length()-5, sb8.length(), "Geek");
		System.out.println("replace ����: " + sb8.toString());
		System.out.println("reverse ����: " + sb8.reverse());

		//ʵ��6.StringBuffer�ַ�����ȡ������
		StringBuffer sb9 = new StringBuffer("I'am weiyigeek!");
		String subdemo1 = sb9.substring(5);  //��ȡ�ӵ������ַ���ĩβ
		String subdemo2 = sb9.substring(5,10); //��ȡ�ӵ�6���ַ���ʼ��ȡֱ����ʮ���ַ�����;
		System.out.println("SubDemo1 = " + subdemo1 + ", SubDemo2 = " + subdemo2);
	}
}