package com.weiyigeek.bigInteger;

import java.math.BigInteger;

public class Demo1_BigInteger {

	public static void main(String[] args) {
		//ʾ��1.����long����ַ���ת����Ϊ�ɱ����������
		String val = new String("3141592600000000000");
		BigInteger bi = new BigInteger(val);
		System.out.println(bi);
		
		//ʾ��2.����������(ע���������ֵ������Զֵ�ϸı�)
		BigInteger bi1 = new BigInteger("256");
		BigInteger bi2 = new BigInteger("2");
		BigInteger[] bi3 = bi1.divideAndRemainder(bi2);
		System.out.println("add = " + bi1.add(bi2));  //��
		System.out.println("subtract = " + bi1.subtract(bi2)); //��
		System.out.println("multiply = " + bi1.multiply(bi2)); //��
		System.out.println("divide = " + bi1.divide(bi2));  //��
		System.out.println("div = " + bi3[0] + ", Remainder = " + bi3[1]);
	}
}
