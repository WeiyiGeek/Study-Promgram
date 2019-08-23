package com.weiyigeek.integer;

import java.util.Arrays;

public class Demo2_Integer {

	public static void main(String[] args) {
		//ʵ��1.Integer��Ĺ��췽���Լ�����
		System.out.println("int ����  Max : " + Integer.MAX_VALUE);
		System.out.println("int ����  Min : " + Integer.MIN_VALUE);
		
		Integer it1 = new Integer(100);
		Integer it2 = new Integer("100"); //�����ַ���ת����Ϊ����
		Integer it3 = new Integer('a');   //ע�⣺������Խ������ַ�ת������Ӧ��ʮ����ֵ(�����ַ����ǲ��еı���"abc")
		System.out.println(it1);
		System.out.println(it2);
		System.out.println(it3);

		//ʵ��2.Integer���һЩ����(ʵ��ʮ����ת����������)
		int src = 255;
		System.out.println(src + " -> Binary : " + Integer.toBinaryString(src)); //������
		System.out.println(src + " -> Octal : " + Integer.toOctalString(src));  //�˽���
		System.out.println(src + " -> Hex : " + Integer.toHexString(src));     //ʮ������
		
		
		//ʵ��3.int��String֮����໥ת��
		//����ת���ַ�������
		int num = 1024;
		
		String s1 = num + "";  //method1 (�Ƽ�)
		
		String s2 = String.valueOf(num); //method2 (�Ƽ�)
		
		Integer num2 = new Integer(num);
		String s3 = num2.toString();
		
		String s4 = Integer.toString(1024);
		System.out.println("����int ת�� �ַ��� �� ��̬���� ��" + s1 + ", " + s2 + ", " + s3 + ", " + s4);
		
		//�ַ���ת������
		String s5 = "1024";
		Integer num3 = new Integer(s5);
		int num4 = num3.intValue();
		
		int num5 = Integer.parseInt(s5); // �Ƽ�����
		System.out.println("�ַ���ת����Ϊ����:");
		System.out.print(num4);
		System.out.println(num5);
		
		
		//ʵ��3.ParseXXX�ķ���,���Խ��������ַ���������ʽת����Ϊ������������;
		Boolean b = Boolean.parseBoolean("true");
		System.out.println(b);
		
		//������ �Զ�װ����������
		int number1 = 1024;
		int number2 = 1024;
		Integer int1 = new Integer(number1);
		Integer int2 = new Integer(number2);
		System.out.println(int1 == int2);       //�����ַ֮��ıȽ�
		System.out.println(int1.equals(int2));  //����֮��ıȽ�
		System.out.println("#-----------------------------------------#");
		
		Integer int3 = new Integer(512);
		Integer int4 = new Integer(512);
		System.out.println(int3 == int4);
		System.out.println(int3.equals(int4));
		System.out.println("#-----------------------------------------#");
		
		//���������(���ȡֵ��Χ��bytes�� -127 ~ 128����ֱ�Ӵӳ�����ȡ)
		Integer int5 = 97;
		Integer int6 = 97;
		System.out.println(int5 == int6);
		System.out.println(int5.equals(int6));
		System.out.println("#-----------------------------------------#");

		Integer int7 = 197;
		Integer int8 = 197;
		System.out.println(int7 == int8);
		System.out.println(int7.equals(int8));
		System.out.println("#-----------------------------------------#");
		
	}
}
