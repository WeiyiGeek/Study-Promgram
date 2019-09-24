package com.weiyi.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class set_LinkedHashCode {

	public static void main(String[] args) {
		
		//ʾ��1.LinkedHashSet���ͳ���ʹ��
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("b");
		lhs.add("c");
		lhs.add("d");
		System.out.println("ʾ��1:LinkedHashSet��ʹ�� " + lhs + "\n");
		
		
		//ʾ��2.ʹ��Scanner�Ӽ��̶�ȡȥ����ͬ���ַ���ӡ����ͬ����Щ�ַ�
		/**
		 * 1.����Scanner����
		 * 2.����HashSet�����ַ��洢ȥ���ظ�
		 * 3.���ַ���ת��Ϊ�ַ�����,��ȡÿһ���ַ��洢��HashSet����֮���Զ�ȥ���ظ�
		 * 4.����HashSet��ӡÿһ���ַ�
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("������һ���ַ���: ");
		HashSet<Character> c = new HashSet<Character>();
		String line = sc.nextLine();
		char[] arr = line.toCharArray();
		for (char d : arr) {
			c.add(d);
		}
		//������ӡÿһ���ַ�
		for (Character ch : c) {
			System.out.print(ch);  //��ӡ���������
		}
		
		
		//ʾ��3.List������LinkedHashSet��������ʹ�ð���
		/**
		 *  (1)ȥ��List�����е��ظ�Ԫ�أ�
		 *  - ����һ��LinkedHashSet����
		 *  - ��List����������Ԫ����ӵ�LinkedHashSet����
		 *  - ��List�����е�Ԫ�����
		 *  - ��LinkedHashSet������Ԫ�ؼӻص�List����֮��
		 **/
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("a"); //�ظ�Ԫ��
		getSingle(list);
		System.out.println(list);
		
	}
	//����ĳ�List���Լ���linked
	public static void getSingle(ArrayList<String> list) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.addAll(list); //���������е��������(ȥ����)
		list.clear();
		list.addAll(lhs); //�ǳ�ֵ��ѧϰȥ�غ����·���list������
	}
}
