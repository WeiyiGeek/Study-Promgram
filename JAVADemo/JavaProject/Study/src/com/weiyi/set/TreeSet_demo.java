package com.weiyi.set;

import java.util.TreeSet;

public class TreeSet_demo {
	public static void main(String[] args) {
		//ʾ��1.TreeSet���ϻ���ʹ��
		TreeSet<Integer> ts = new TreeSet<>(); //����TreeSet����ȥ�غ�����
		ts.add(3);
		ts.add(1);
		ts.add(1);
		ts.add(2);
		ts.add(2);
		ts.add(2);
		ts.add(2);
	
		System.out.println(ts);  //���Ԫ��
	}
}
