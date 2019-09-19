package com.weiyi.generic;

import com.weiyi.Collection.Students;
import java.util.ArrayList;
import java.util.List;

public class Demo3_Generic {

	public static void main(String[] args) {
		//ʵ��1.���ұߵķ��Ͳ�ȷ��ʱ,��߿���ָ��Ϊ?
		List<?> list = new ArrayList<Integer>();

		//ʵ��2.ͨ���������֤
		ArrayList<Study> list1 = new ArrayList<>();
		list1.add(new Study("1.������", 15)); //����
		list1.add(new Study("2.���ϼ�", 15));
		list1.add(new Study("3.������", 15));
		
		ArrayList<Students> list2 = new ArrayList<>();
		list2.add(new Students("4.����",25));  //����
		list2.add(new Students("5.ѧ����",25));

		list2.addAll(list1);   //��������ƴ������ļ��� ��ע�ⲻ�ܸ���ǿ��ת����Ϊ����list1.addAll(list2))
		System.out.println("������:"+list2);
	}
}


//ʵ��1
class Study extends Students {
	public Study() {
		super();
	}
	public Study(String name, int age) {
		super(name, age);
	}
}