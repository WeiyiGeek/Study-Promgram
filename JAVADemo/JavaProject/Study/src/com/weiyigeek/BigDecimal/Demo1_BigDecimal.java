package com.weiyigeek.BigDecimal;

import java.math.BigDecimal;

public class Demo1_BigDecimal {
	public static void main(String[] args) {
		//ʾ��1.BigDecimal ��ȷ����ļ��ַ���
		BigDecimal bd1 = new BigDecimal(2.0);  //��ʽ1 ����double���Ͳ���
		BigDecimal bd2 = new BigDecimal(1.1);
		System.out.println("Demo1 - �����в��Ƽ����ַ�ʽ  2.0 - 1.1 = " + bd1.subtract(bd2));

		BigDecimal bd3 = new BigDecimal("2.0"); //��ʽ2 �����ַ����ķ�ʽ
		BigDecimal bd4 = new BigDecimal("1.1");
		System.out.println("Demo2 - ͨ�������д����ַ����ķ�ʽ ����ʱ���Ƽ�  2.0 - 1.1 = " +bd3.subtract(bd4));
		
		BigDecimal bd5 = BigDecimal.valueOf(2.0); //��ʽ3
		BigDecimal bd6 = BigDecimal.valueOf(1.1);
		System.out.println("Demo3 - �ڿ�����Ҳ���Ƽ��� 2.0 - 1.1 = " + bd5.subtract(bd6));
		System.out.println(bd5.add(bd6));
		System.out.println(bd5.multiply(bd6));
		System.out.println(bd5.divide(bd6,1));  //ע����� ����������
	}
}
