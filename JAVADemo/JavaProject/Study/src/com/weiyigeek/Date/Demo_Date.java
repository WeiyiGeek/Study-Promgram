package com.weiyigeek.Date;
import java.util.Date;
public class Demo_Date {
	public static void main(String[] args) {
		//ʾ��1.
		Date d1 = new Date(); //û�д������������ǵ�ǰʱ��
		System.out.println("��ǰʱ�� = " + d1);
		Date d2 = new Date(0); //�������1970��1��1�գ�ͨ������ֵ����ʱ�����
		System.out.println("����GMT��ʼʱ�� = " + d2); //��Ҫע��ʱ����Ӱ��
		
		//ʾ��2.
		Date d3 = new Date();
		System.out.println("ͨ��ʱ������ȡ��ǰ����ֵ ��" + d3.getTime());
		System.out.println("ͨ���෽����ȡ��ǰ����ֵ ��" + System.currentTimeMillis());
		
		//ʾ��3.���ú���ֵ�ı�ʱ����� ��1970��һ��һ�տ�ʼ (��ʾ�� d2 ��һ���Ĺ���)
		Date d4 = new Date();
		d4.setTime(1000);
		System.out.println(d4);
	}
}
