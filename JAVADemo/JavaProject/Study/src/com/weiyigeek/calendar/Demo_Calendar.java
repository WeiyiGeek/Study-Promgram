package com.weiyigeek.calendar;
import java.util.Calendar;
import java.util.Scanner;
public class Demo_Calendar {

	public static void main(String[] args) {
		// ʵ��1.Calendarʹ��
		Calendar c = Calendar.getInstance();
		System.out.println("��ǰ��ϸʱ�� �� " + c);
		//��ȡָ������������
		System.out.println(c.get(Calendar.YEAR));  //�ֶξ�̬��Ա��
		System.out.println(c.get(Calendar.MONTH)+1); //�ֶλ�ȡ����Ҫ�Ǵ��꿪ʼ (ע���Ǵ�0��ʼ��)
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); //���еĵĵڼ���
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //���еڼ��� �����ǵ�һ��,���������һ��
		
		//ʵ��2.��ȡ��ǰ���ڼ�
		System.out.println(getWeek(c.get(Calendar.DAY_OF_WEEK)));
		
		//ʵ��3.����ǰ���в�0
		System.out.println("��ǰ���е����� : " + getDay(c.get(Calendar.DAY_OF_MONTH)));
		
		//ʵ��4.���÷���
		Calendar c1 = Calendar.getInstance(); //��������ָ���������
		c1.add(Calendar.YEAR, -1);          //��ǰ���-1; ���ǿ��Զ��ֶν�����ǰ����������  2018
		c1.set(Calendar.DAY_OF_MONTH,29); // ���õ�ǰ���е�����Ϊ29��
		System.out.println(c1.get(Calendar.YEAR) + "��" + (c1.get(Calendar.MONTH)+1) +"��" +c1.get(Calendar.DAY_OF_MONTH)+"��");
		
		//ʵ��5.ƽ�������ж�
		System.out.print("������һ������ж������껹��ƽ��: ");
		Scanner sc = new Scanner(System.in);
		String year = sc.nextLine();
		int y = Integer.parseInt(year);  //�������ַ���ת����Ϊ����
		Calendar c2 = Calendar.getInstance();
		c2.set(y, 2, 1); //������3��1��
		c2.add(Calendar.DAY_OF_MONTH, -1);
		String flag = (c2.get(Calendar.DAY_OF_MONTH) == 29) ? "����":"ƽ��";
		System.out.println(year+"����"+flag);
	}

	private static String getWeek(int i) {
		String[] week = {"","������","����һ","���ڶ�","������","������","������","������"}; //ע������week[0] Ϊ��
		return week[i];
	}
	
	private static String getDay(int i) {
		return i > 9 ? "" + i:"0" + i;   //����λ����0
	}
}
