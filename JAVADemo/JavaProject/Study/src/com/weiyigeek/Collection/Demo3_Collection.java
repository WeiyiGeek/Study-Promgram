package com.weiyigeek.Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import com.weiyi.Collection.Students;

@SuppressWarnings("rawtypes")

public class Demo3_Collection {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//ʾ��1.�Լ����е�Ԫ�ؽ��е�������
		Collection c = new ArrayList();
		c.add("Weiyi");
		c.add("Geek");
		c.add("1024");
		c.add("Java");
		Iterator it = c.iterator(); //��ȡ������
		boolean bl = it.hasNext(); //�жϼ������Ƿ���Ԫ��,���򷵻�true;
		Object obj = it.next();  //ָ����¼��ǰλ�������λ;
		System.out.print(bl + " ");
		System.out.println(obj); //���뼯���е�һ��Ԫ��
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		

		//ʾ��2.ͨ��whileѭ����������������
		Collection c1 = new ArrayList();
		c1.add(new Students("��ΰ", 15)); //��������ָ���������
		c1.add(new Students("�Ž�", 29)); //Object obj = new Student
		c1.add(new Students("�Ÿ�˶", 35));
		c1.add(new Students("����ΰ", 25));
		Iterator it1 = c1.iterator();
		//Collection�洢�Զ�������õ���������
		while(it1.hasNext())
		{
			Students s = (Students)it1.next(); //����ת�� ǿת
			System.out.println(s.getName() + " " + s.getAge());
		}
	}
}
