package com.weiyi.generic;

import java.util.ArrayList;

import com.weiyi.Collection.Students;

public class Demo4_For {

	public static void main(String[] args) {
		//ʵ��1.��ǿfor��������
		int[] arr = {11,22,33,44,55};
		//foreach ����(ֵ��ѧϰ)
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//ʵ��2.��ǿfor�������ϴ洢Ԫ��
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for (String param : list) {
			System.out.print(param+" ");
		}
		System.out.println();

		
		//ʵ��3.ArrayList�洢�ַ������Զ�����󲢱�����ǿfor��
		ArrayList<Students> list1  = new ArrayList<Students>();
		list1.add(new Students("������", 27));
		list1.add(new Students("��ʦ��", 26));
		list1.add(new Students("����ʦ", 27));
		
		for (Students param : list1) {
			System.out.println(param);  //������������д��toString��Ч��
		}
	}
}
