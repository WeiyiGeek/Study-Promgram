package com.weiyigeek.reflect;
public class Demo7_Enumerate {
	public static void main(String[] args) {
		//ʵ��1.ö�ٵ�ʹ��
		Demo7_Week mon = Demo7_Week.Mon;
		Demo7_Week tue = Demo7_Week.Tue;
		Demo7_Week wed = Demo7_Week.Wen;
		System.out.println("��ʽ1:");
		System.out.println(mon);
		
		//ʵ��2.ö���в�
		Demo7_Week Thu = Demo7_Week.Thu;
		Demo7_Week Fri = Demo7_Week.Fri;
		Demo7_Week Sat = Demo7_Week.Sat;
		System.out.println("��ʽ2��");
		System.out.println(Thu.getWeek());
		
		//ʵ��3.ö�ٵ��ڲ�������
		Demo7_Week1 sun = Demo7_Week1.Sun; //���뿴��ߣ����п��ұ�
		System.out.println("��ʽ3:");
		sun.show();
	}
}
