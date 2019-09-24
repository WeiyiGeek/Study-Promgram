/**
* @Filename: Set_Demo1.java
 * @Author: WeiyiGeek
 * @Function: Set����ѧϰ 
 * @CreateTime: ����7:38:16
 */
package com.weiyi.set;

import java.util.HashSet;
import com.weiyi.Collection.Students;

public class Set_Demo1 {

	public static void main(String[] args) {
		//1.Set���ϵ��ص㣺
		//�������������ظ�������(��ȡ����˳��һ��)
		System.out.println("#########ʾ��1#############");
		demo();
		
		//2.�洢�Զ������֤Ԫ��Ψһ��
		System.out.println("\n\n@@@@@@@@@@ʾ��2@@@@@@@@@@");
		demo1();
	}

	public static void demo1() {
		HashSet<Students> st = new HashSet<>();
		st.add(new Students("����",35));
		st.add(new Students("������",32));
		st.add(new Students("������",35));
		st.add(new Students("������",32));
		st.add(new Students("����",35));
		//�鿴�����д��Ԫ�صĸ���(���ڿ�ʼ���ǻ�δ���ظ����˵�ʱ��size()���Ϊ5)
		System.out.println(st.size());   //4
		System.out.println(st);  //������дHashCode()��euquals()����ʹ���Զ���������Ԫ�ر��ֲ��ظ�
	}

	public static void demo() {
		HashSet<String> hs = new HashSet<String>(); //����HashSet����;
		boolean b1 = hs.add("a");   //����set�����д洢�ظ�Ԫ�ص�ʱ�򷵻�false;
		boolean b2 = hs.add("a"); 
		hs.add("b");
		hs.add("d");
		hs.add("c");
		System.out.println(hs); //HashSet�̳���ϵ����д��toString����,�����Ԫ�ز��ظ�������
		System.out.println(b1 + " - " + b2);
		for (String string : hs) {  //ֻҪ���õ����������ľͿ���ʹ����ǿforѭ������
			System.out.print(string + " ");
		}

	}
}

