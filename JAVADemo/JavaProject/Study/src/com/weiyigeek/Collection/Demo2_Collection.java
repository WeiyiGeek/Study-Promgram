package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;

import com.weiyi.Collection.Students;

public class Demo2_Collection {

	public static void main(String[] args) {
		//ʾ��1�����ϱ���֮����ת�������
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		Object[] arr = c.toArray(); //����֮�������
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		System.out.println("\n##########�ָ�����##########");
		//ʾ��2.����ת����Ϊ����
		Collection c1 = new ArrayList();
		c1.add(new Students("����ʦ",24));
		c1.add(new Students("����ʦ",23));
		c1.add(new Students("������",25));
		c1.add(new Students("��ʦ��",26));
		Object[] arr1 = c1.toArray();  //������ת��������
		for (int i = 0; i < arr1.length; i++) {
			Students s = (Students)arr1[i];  //����ת��
			System.out.println(s.getName() + "  " + s.getAge());
		}
		
		
		//ʾ��3.�Դ�All()���ܲ��Է���
		Collection c2 = new ArrayList();
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		
		Collection c3 = new ArrayList();
		c3.add("1");
		c3.add("2");
		c3.add("3");
		c3.add("4");
		c3.add("a");

		System.out.println("##########�ָ���###########");
		c2.add(c3);    //��c3����һ��������ӵ�c1�� [1,2,3,4]
		System.out.println(c2);
		c2.addAll(c3); //��c3�е�ÿһ��Ԫ����ӵ�c1��
		System.out.println(c2);
		
		boolean b = c2.removeAll(c3);  //��c2�е�c3Ԫ�ؽ���ɾ�� (��Ҫע��ɾ���ǽ���)
		System.out.println("��Ҫע��ɾ���ǽ���");
		System.out.println(c2);
		
		boolean b1 = c2.containsAll(c3); //�жϵ��ü����Ƿ��������ļ���
		System.out.println("c2�Ƿ����c3 : " + b1);
		
		//ȡ����������õļ��ϸı�ͷ���true,���򷵻�false;
		boolean b2 = c2.retainAll(c3); //ȡ����
		System.out.println(b2);
		System.out.println(c2);
	}
}
