package com.weiyigeek.reflect;

//ö��Enumerate ��
public class Demo7_Week {
	//����1���޲�
	public static final Demo7_Week Mon = new Demo7_Week();
	public static final Demo7_Week Tue = new Demo7_Week();
	public static final Demo7_Week Wen = new Demo7_Week();
	private Demo7_Week() {};  //˽�й��첻�������ഴ���������
	
	
	//����2���в�
	public static final Demo7_Week Thu = new Demo7_Week("������");
	public static final Demo7_Week Fri= new Demo7_Week("������");
	public static final Demo7_Week Sat= new Demo7_Week("������");
	private String week;
	private Demo7_Week(String w) {
		this.week = w;  //˽�й��첻�������ഴ���������
	}
	public String getWeek() {
		return week;
	}
}
