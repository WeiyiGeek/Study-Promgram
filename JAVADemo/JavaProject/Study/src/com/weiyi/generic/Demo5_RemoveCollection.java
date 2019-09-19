package com.weiyi.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.weiyi.Collection.Students;

public class Demo5_RemoveCollection {
	public static void main(String[] args) {
		//ʵ��1.���ֵ��������Ƿ��ܽ���ɾ��
		ArrayList<String> list = new ArrayList<String>();
		list.add("a"); 
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("WeiyiGeek");


		//(1)���Ҫɾ����Ԫ���ǰ��ŵ�,��ͨѭ��ֻ�ܶ���index��������<-�ص�
		for (int i = 0; i < list.size(); i++) {
			if("a".equals(list.get(i)))
				list.remove(i--); //ע���������ȸ�ֵ,�ټ���
		}
		
		//(2)������ɾ��
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			if("b".equals(it.next()))
				//ע�����ﲻ��ʹ�ü��ϵ�ɾ�������ᵼ�²����޸��쳣(���������н������޸�),��Ϊ����������������ϱ��޸�,��ᵼ�µ����޸��쳣
				it.remove();
		}
		
		//��һ�ַ�ʽ �������������� �����ظ�ʹ�õ�����it1
		for(Iterator<String> it1 = list.iterator(); it.hasNext();)
		{
			if("c".equals(it1.next()))
				it1.remove();
		}
		
		
		//(3)��ǿforѭ������ɾ��ֻ���Ա���
		for(String param: list){
			if("c".equals(param))
				//list.remove(param);
				System.out.println(param);
		
			System.out.println("��� : " +  param);
		}
		System.out.println(list);		
	}
}
