package com.weiyi.Map;

import java.util.HashMap;
import java.util.Map;

import com.weiyi.Collection.Students;

public class Demo4_HashMap {

	private static final HashMap<Students, String> Students = null;

	public static void main(String[] args) {
		//ʾ��1.ͳ���ַ�����ÿ���ַ����ֵĴ���
		String s = "abadsadasagsdasdc";
		char[] arr = s.toCharArray();
		//������һ��˫�м��ϴ洢�ַ��Լ��ַ����ֵĴ�����һ����������²���HashMap��
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : arr) {
			//��ʽ1
//			if(!hm.containsKey(c)) {
//				hm.put(c, 1);
//			}else {
//				int num = hm.get(c);
//				hm.put(c, hm.get(c) + 1);
//			}
			//��ʽ2���Ƽ���ʽʹ�ÿɼ������ظ�������
			hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
		}
		
		System.out.println("ʾ��1��\n�ַ����е�������ͬ�ַ������� : " + hm);
		
		
		//ʾ��2.����HashMap�ڲ�Ƕ��HashMap
		/***
		 * ���󣺶������ڵ�һ��˫�м��ϣ�����ѧϰ����ֵ��ѧ��������
		 */
		//���嵥���ڵ�˫�м���Ԫ��
		HashMap<Students, String> h1 = new HashMap<Students, String>();
		h1.put(new Students("����", 13),"����");
		h1.put(new Students("����", 53),"����");
		h1.put(new Students("����", 93),"����");

		
		HashMap<Students, String> h2 = new HashMap<Students, String>();
		h2.put(new Students("��ΰ", 98),"����");
		h2.put(new Students("��˹��", 13),"����");
		h2.put(new Students("���E��", 23),"�㽭");
		
		//ע�⣺���濪ʼǶ����
		HashMap<HashMap<Students, String>, String> hhmm = new HashMap<HashMap<Students,String>, String>();
		hhmm.put(h1, "1999��");
		hhmm.put(h2, "2000��");
		
		System.out.println("\nʾ��2:");
		
		//Ƕ���������˫�м���
		for(HashMap<Students, String> c : hhmm.keySet()) {
			String classbj = hhmm.get(c);  //����֮��������HashMap
			for(Students d : c.keySet())   //ע��������Students //��ȡ����������ѧ��������
			{
				String value = c.get(d); 
				System.out.println("����/����:" + d + ",������" + value + ", �༶��" + classbj);
			}
		}
		
		
	}

}
