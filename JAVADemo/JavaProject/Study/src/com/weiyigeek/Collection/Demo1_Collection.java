package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;

import com.weiyi.Collection.Students;  //����ѧ����

public class Demo1_Collection {
	/**
	 * Student[] arr = new Student[5]; //�洢ѧ������
		arr[0] = new Student("����", 23);
		arr[1] = new Student("����", 24);
		arr[2] = new Student("����", 25);
		arr[3] = new Student("����", 26);
		arr[4] = new Student("���", 20);
	 * 
	 */
	public static void main(String[] args) {
		//ʾ��1.����������������
		//int[] arr = new int[5];
		
		//ʾ��2.����������������
		Students[] arrs = new Students[5];
		arrs[0] = new Students("����", 23);
		arrs[1] = new Students("����", 25);
		arrs[2] = new Students("����", 27);
		
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]); //����ͼ��������������ʹ洢���ǵ�ֵַ
		}
		
		//ʾ��3.Collection���ʹ�� (���뿴����,���п�����)
		Collection c = new ArrayList(); //��������ָ���������
		//add���������List����һֱ������True,��ΪList�������ǿ��Դ洢�ظ�Ԫ�ص�;�������set���ϵ��洢�ظ�Ԫ�ص�ʱ��ͻ᷵��false;
		boolean b1 = c.add("abc");
		boolean b2 = c.add(true); //�Զ�װ������new Boolean(true)
		boolean b3 = c.add(100);
		boolean b4 = c.add(10.24);
		boolean b5 = c.add(new Students("����",23));
		boolean b6 = c.add("abc");  //��������ظ���Ԫ��
		System.out.println(c);  //������Python�еļ���
		//ArrayList �ĸ���ĸ�����дtoString����,�����ڴ�ӡ��������õ�ʱ������Ľ������Object���е�toString����
		System.out.println(c.toString());  //������Python�еļ���

		//ʾ��4.�����ķ���
		System.out.println("����Ԫ�ظ��� :" + c.size());//��ȡ������Ԫ�ظ���

		c.remove("abc"); //ɾ��Ԫ��
		System.out.println("ɾ��ָ��Ԫ�� : "+c);  //������Python�еļ���

		System.out.println("�ж��Ƿ���� " + c.contains(10.24));
	
		c.clear();//���Ԫ��
		System.out.println("���Ԫ�� : " + c);  //������Python�еļ���
		
		System.out.println("�ж��Ƿ�Ϊ�� : " + c.isEmpty()); //�жϼ����Ƿ�Ϊ��
	}
}
