package com.weiyigeek.reflect;
public class EnumDemo {
	public static void main(String[] args) {
		//ʵ��1.����ö��
		Week1 w = Week1.Mon;
		System.out.println("����1:");
		System.out.println(w);
		
		//ʵ��2.�в���ö��
		Week1 w1 = Week1.Wed;
		System.out.println("����2:");
		System.out.println(w1.getWeek());
		
		//ʵ��3�������ö����
		Week2 w2 = Week2.MON;
		System.out.println("����3:");
		w2.show();

	}
}
