package com.weiyigeek.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Demo5_ListIterator {

	public static void main(String[] args) {
		//��ʽ1��
		List list = new ArrayList();
		list.add("Weiyi");
		list.add("world");
		list.add("Geek");
		
		//���ã�����Iterator������
		Iterator it = list.iterator();
		boolean flag = false;
		while(it.hasNext())
		{
			String str = (String)it.next();
			if(str.equals("world")) {
			//list.add("JavaEE") //������׳�ConcurrentModificationException�����޸��쳣
			//���������������޸ļ���,�쳣���ڵ������Ѿ�֪�����ϵĸ���,Ȼ���ڵ�����ʱ��������˼���Ԫ�����Ե����쳣
			//���Բ��ô��ַ���
				flag = true;
				break;
			}
		}
		if(flag) {
			list.add("JavaEE");
		}
		System.out.println("����1:" + list);
		
		
		//��ʽ2��
		//* a:����������Ԫ�أ��������޸�Ԫ��(ListIterator�����й���add)
		//* b:���ϱ���Ԫ�أ������޸�Ԫ��
		ListIterator lit = list.listIterator();		//������ڱ����Ĺ��������Ԫ��,������ListIterator�е�add����
		while(lit.hasNext()) {
			String str = (String)lit.next();
			if(str.equals("world")) {
				//�����������ҵ�world����������javaee
				lit.add("javaee");	//�ؼ��� lit�� ListIterator�ڵ����Ĺ��������Ԫ�ض���;
			}
		}
		System.out.println("��ʽ2:"+list);
	}
}
