package com.weiyi.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1_CollectionsUse {

	public static void main(String[] args) {
		//1.Collections������Ļ���ʹ��
		ArrayList<String> list = new ArrayList<String>();
		list.add("c");
		list.add("d");
		list.add("a");
		list.add("b");
		list.add("A");

		System.out.println("ArrayList ��ô��ͻ���ôȡ : "  + list);
		Collections.sort(list);
		System.out.println("����Collections�����������Ľṹ: " + list); //String Ĭ�ϰ�װacsii������
		
		int index = Collections.binarySearch(list, "a");
		System.out.println("���ҵ��Ľ����������" + index);
		System.out.println("���ҵ��Ľ����������" + Collections.binarySearch(list, "B")); // -(�����1)-1=-2

		System.out.println("����Ĭ����������ȡ���������ֵ��"+Collections.max(list));
		System.out.println("����Ĭ����������ȡ��������Сֵ��"+Collections.min(list));
		
		//��ת
		Collections.reverse(list);
		System.out.println("��ת������(�Ӵ�С): " + list);
		//�������
		Collections.shuffle(list);
		System.out.println("ÿ�ζ���������:" + list);
		
	}

}
