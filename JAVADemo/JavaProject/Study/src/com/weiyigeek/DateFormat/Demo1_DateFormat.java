package com.weiyigeek.DateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1_DateFormat {

	public static void main(String[] args) throws ParseException {
		//ʾ��1
		//DateFormat df = new DateFormat(); //ע�� �� DateFormat�ǳ����಻����ʵ����
		//̬��������֮һ��
		DateFormat df1 = DateFormat.getDateInstance();//Ĭ�ϸ�ʽYYYY/MM/dd �൱�ڸ�������ָ���������,�ұߵķ�������һ������
		System.out.println("ʾ��1 " + df1.format(new Date())); 
		DateFormat df2 = new SimpleDateFormat(); //Ч��ͬ��
		
		
		//ʾ��2
		Date d = new Date();  //ʱ�����
		SimpleDateFormat sdf = new SimpleDateFormat(); //�������ڸ�ʽ������
		System.out.println("��ǰʱ��Ĭ�ϸ�ʽ��:  " + sdf.format(d)); //������ת���ַ���
		//�Զ��������ʽ
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy �� MM �� dd �� HH:mm:ss");
		System.out.println("��ǰʱ���Զ����ʽ��:  " + sdf1.format(d));
		
		
		//ʾ��3
		String str = "2019 �� 08 �� 25 �� 22:09:25"; //��ʱ���ַ���ת�������ڶ���
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy �� MM �� dd �� HH:mm:ss");
		Date d1 = sdf2.parse(str);
		System.out.println("ת����� : " + d1);
		
		
		//ʾ��4:���յ�ǰʱ�������˶�����
		String birthDay = "1995��01��10��";
		String currentDay = "2019��08��25��";
		//�������ڸ�ʽ������
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy��mm��dd��");
		//�������ַ���ת����Ϊ���ڶ���
		Date bir = sdf3.parse(birthDay);
		Date cur = sdf3.parse(currentDay);
		//ͨ�����ڶ����ȡʱ�����ֵ
		long res = cur.getTime() - bir.getTime();
		//֮������ֵ����1��ĺ���ֵ 1000 / 3600 / 24
		System.out.println("���Ѿ������� " + (res / 1000 / 3600 / 24) + " ��");
	}
}
