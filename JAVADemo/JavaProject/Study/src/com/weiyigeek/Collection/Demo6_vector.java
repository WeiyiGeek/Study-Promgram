package com.weiyigeek.Collection;

import java.util.Enumeration;
import java.util.Vector;

public class Demo6_vector {

	public static void main(String[] args) {
		//ʾ��1.Vector�ĵ��������Ԫ��
		Vector v = new Vector();
		v.addElement("Weiyi");
		v.addElement("Geek");
		v.addElement("Java");
		Enumeration en = v.elements(); //��ȡö��
		while(en.hasMoreElements()) //�жϼ������Ƿ���Ԫ��
		{
			//������ȡ�����е�Ԫ��
			System.out.print(en.nextElement() + " ");
		}
		
		
	}

}
