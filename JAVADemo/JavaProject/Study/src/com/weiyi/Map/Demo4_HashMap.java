package com.weiyi.Map;

import java.util.HashMap;

public class Demo4_HashMap {

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
	}

}
