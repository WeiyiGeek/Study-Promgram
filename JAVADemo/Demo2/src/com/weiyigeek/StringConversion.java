package com.weiyigeek;
public class StringConversion {
	public static void main(String[] args) {
		//ʾ��1.̽���ַ���Ĭ��ת���������������ǿ��Ķ�ת��Ϊ��������Ķ���;
		demo1();
		
		//ʾ��2.���ַ���ת����Ϊ�ַ�����
		demo2();
		
		//ʾ��3.��valueof�������͵�����ת����Ϊ�ַ���
		char[] arr4 = {'a','b','c'};  //�ײ㶼�ǲ��� new String() ���췽�������е�
		String s = String.valueOf(arr4);
		System.out.println("\n" + s + ", ����ת����Ϊ�ַ��� : " + String.valueOf(1024));
		
		//ʾ��4.�ַ����Ĵ�Сдת�����ҽ���ƴ��
		String lower = "abcd";
		String upper = "ABCD";
		System.out.println("Lower -> Upper :" + lower.toUpperCase());
		System.out.println("Upper -> Lower  :" + upper.toLowerCase());
		
		System.out.println("�ַ���ƴ��1��" + lower + upper);  //�����ַ���ƴ��
		System.out.println("�ַ���ƴ��2��" + lower.concat(upper)); //ֻ���ַ������ͽ���ƴ��

		//ʾ��5.�ǳ�ֵ��ѧϰ ��һ���ַ�������ĸת�ɴ�д,����ΪСд��(ֻ����Ӣ�Ĵ�Сд��ĸ�ַ�)
		String ori = "iLOveStudyJavaPrograminG";
		String dst = ori.substring(0, 1).toUpperCase().concat(ori.substring(1).toLowerCase()); //��ʽ���
		System.out.println("ʾ��5��" + dst);
		
	}

	public static void demo2() {
		String s3 = "This";
		char[] arr = s3.toCharArray();
		System.out.println("\n�ַ���ת����Ϊ�ַ����� ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void demo1() {
		String s1 = "abc";
		String s2 = "���,JAVA";
		
		System.out.println("Ӣ���ַ���" + s1);
		byte[] arr1 = s1.getBytes();
		byte[] arr2 = s2.getBytes();
		for(int i = 0; i < arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println("\n�����ַ���" + s2);
		//gbk����ʾ һ�����Ĵ��������ֽ� ,gbk����ص����ĵĵ�һ���ֽڿ϶��Ǹ���
		for(int i = 0; i < arr2.length; i++)
		{
			System.out.print(arr2[i] + " ");
		}
		//ע��������ͳ�Ƶ��������������length (���������ַ���)
		System.out.println("\n���������ַ����i");
		byte[] arr3 = "�i".getBytes();
		for( int i = 0; i < arr3.length; i++)
		{
			System.out.print(arr3[i] + " ");
		}
	}

}
