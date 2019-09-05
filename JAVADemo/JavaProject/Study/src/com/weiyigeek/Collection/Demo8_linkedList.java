package com.weiyigeek.Collection;

import java.util.LinkedList;

public class Demo8_linkedList {

	public static void main(String[] args) {
		//ʾ��1.���ϳ��÷���չʾ
		LinkedList list = new LinkedList(); //����Linked����
		list.add("1");
		list.addFirst("0");
		list.addLast("2");
		
		System.out.println("��ȡ�����е�һ��Ԫ�أ�"+list.getFirst());
		System.out.println("��ȡ���������һ��Ԫ�أ�"+list.getLast());
		System.out.println("����ɾ���ĵ�һ��Ԫ�أ�"+list.removeFirst());
		System.out.println("����ɾ�������һ��Ԫ�أ�"+list.removeLast());
		System.out.println("����������ȡԪ�� (ԭ��ֵ��ѧϰ): "+list.get(0));
	
		//ʾ��2.����LinkedListģ��ջ�ṹ
		LinkedStack stack = new LinkedStack();
		stack.in("a"); //��ջ
		stack.in("b");
		stack.in("c");
		stack.in("d");
		//ѭ����ջ
		while(!stack.isEmpty()) {
			System.out.println(stack.out());
		}
		
		//ʾ��3.ʵ�ֶѼ��Ƚ��ȳ�����addFrist();�Լ�RemoveFrist��������
		
	}
}

//����һ���ཫLinked�еķ�����װ  
class LinkedStack {
	private LinkedList lt = new LinkedList();
	
	/**ģ��ջ�Ƚ��ȳ�**/
	public void in(Object obj) {
		lt.addLast(obj);  //��ĩβ��ӷ���
	}
	public Object out() {
		return lt.removeLast();  //��ĩβɾ������
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return lt.isEmpty();
	}
}
