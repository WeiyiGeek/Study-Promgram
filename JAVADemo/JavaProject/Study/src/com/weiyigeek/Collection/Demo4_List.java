package com.weiyigeek.Collection;

import java.util.List;
import java.util.ArrayList;
import com.weiyi.Collection.Students;

public class Demo4_List {

	public static void main(String[] args) {
		//1.List���Ϲ���(������������)
		List l = new ArrayList(); //ע������java.util.List;
		l.add("Weiyi");
		l.add("Geek");
		l.add("Love");
		l.add("Java");
		l.add(0,"Start"); //ͷ������  INDEX <= SIZE ���� Index >= 0 ���ᱨ�����쳣
		l.add(5,"END");  //β������
		System.out.println(l);
		
		//ʾ��2.ͨ������ɾ��Ԫ�ز����䷵��
		Object demo1 = l.remove(3); //ɾ��Love - ע��:ɾ����ʱ�򲻻��Զ�װ��
		System.out.println(l + " ɾ���ļ���Ԫ���� " + demo1);
		
		//ʾ��3.����������ȡԪ��
		Object demo2 = l.get(1);
		System.out.println("��ȡָ���������ļ���Ԫ�� ��" + demo2 + l.get(2));
		//ͨ����������List����;
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " - ");
		}
		
		//ʾ��4.������������ָ��λ��Ԫ�ؽ����޸�
		l.set(3, "Editer");
		System.out.println("\n�޸ĺ�ļ���Ԫ�� : " + l);
		
		//�ۺ�ʵ��
		//��List�����д洢ѧ������Ȼ��ͨ��size��get()������ϱ���
		List list = new ArrayList();
		list.add(new Students("Weiyi",28));
		list.add(new Students("Geek",32));

		for (int i = 0; i < list.size(); i++) {
			//�洢�Զ������ͨ��size()��get()��ʽ��ȡ
			Students s = (Students)list.get(i); //��������
			System.out.println(i + " - " + s.getName() + " " + s.getAge());
		}
	}
}
