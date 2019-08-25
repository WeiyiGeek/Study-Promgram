package com.weiyigeek.regex;

import java.util.Arrays;

public class Demo2_Regex {
	public static void main(String[] args) {
		//ʾ��1.�ַ���
		System.out.println("��ʾ1��" + "a".matches("[a-zA-Z]"));
		System.out.println("��ʾ2��" + "p".matches("[a-c[o-z]]")); //����
		System.out.println("��ʾ3��" + "d".matches("[a-z && [def]]")); //����
		System.out.println("��ʾ4��" + "abcdABCD".matches("[a-z && [^cd]]")); //����
		System.out.println("��ʾ5��" + "c".matches("[a-z && [^c-z]]")); //����
		
		//ʾ��2.�κ��ַ�
		System.out.println("ʾ��1 = " + "r".matches("."));  
		System.out.println("ʾ��2 = " + "e".matches("\\S")); //ע����˫б��
		System.out.println("ʾ��3 = " + "g".matches("\\s")); //ע����˫б��
		System.out.println("ʾ��4 = " + "0".matches("\\d"));
		System.out.println("ʾ��5 = " + "e".matches("\\w"));
		System.out.println("ʾ��6 = " + " ".matches("\\W"));

		//ʾ��3.greedy������
		System.out.println("����1 - " + "a".matches("[abc]?"));
		System.out.println("����2 - " + "".matches("[abc]?"));     //Ϊ��
		System.out.println("����3 - " + "r".matches("[abc]+"));
		System.out.println("����4 - " + "abcabc".matches("[abc]*"));
		System.out.println("����5 - " + "abc".matches("[abc]{0,3}"));

		//ʾ��1.�ַ����ָ����������ʽ
		strSpilt("I.LOVE.JAVA");
		strSpiltInteger("91 48 75 76 82 10"); //�ַ����ָ�ҽ��бȽ�����
		
		
		//ʾ��2.������ʽ���滻����(�������滻��)
		System.out.println("�ַ��������滻 : " + "We1iyi12Geek556".replaceAll("\\d",""));
		
	}

	private static void strSpilt(String str) {
		String[] arr0 = str.split("\\.");  //�ؼ��� 1
		String[] arr1 = str.split("[.]");  //�ؼ��� 2
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("###########################");
	}
	
	private static void strSpiltInteger(String st) {
		/**
		   *  ������
		 * 1.���ַ���ת�����ַ�������
		 * 2.���ַ���ת����Ϊ���ֲ��Ҵ洢��һ���ȳ��ȵ�int������
		 * 3.����
		 * 4.�������Ľṹ�ֱ�����ƴ�ӳ�Ϊһ���ַ���;
		 * */
		String[] sArr = st.split(" ");
		int[] iArr = new int[sArr.length]; //����һ���������鳤��Ϊ�ַ������鳤��
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = Integer.valueOf(sArr[i]);  //���ַ���ת����Ϊ����
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
