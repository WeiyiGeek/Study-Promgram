package com.weiyigeek.math;

public class Demo1_Math {

	public static void main(String[] args) {
		//ʾ��1.����ֵ
		System.out.println("��Ȼ����  : " + Math.E);
		System.out.println("Բ���� : "  + Math.PI);
		
		//ʾ��2.���÷���
		System.out.println(" -2 �ľ���ֵ : " + Math.abs(-2));
		System.out.println(" -2 .0�ľ���ֵ : " + Math.abs(-2.0));
		
		System.out.println("����ȡ��" + Math.ceil(12.3));
		System.out.println("����ȡ��" + Math.ceil(12.99));

		System.out.println("����ȡ��" + Math.floor(12.3));
		System.out.println("����ȡ��" + Math.floor(12.99));
		
		System.out.println("�������� " + Math.round(12.30));
		System.out.println("�������� " + Math.round(12.50));
		
		System.out.println("5 8 ���ֵ = " + Math.max(5, 8));
		System.out.println("5 8 ���ֵ = " + Math.min(5, 8));

		System.out.println("2^16 = " + Math.pow(2,16));
		
		System.out.println("����� = " + Math.random());
	}
}
