package com.weiyigeek.reflect;
import com.weiyi.Collection.Students;
public class Demo1_Reflect {
	public static void main(String[] args) throws Exception {
		//1.��ȡClass�ļ���������ֺ췽ʽ
		Class clazz1 = Class.forName("com.weiyi.Collection.Students"); //��ʽ1
		Class clazz2 = Students.class; //��ʽ2
		
		Students clazz = new Students();
		Class clazz3 = clazz.getClass(); //��ʽ3
		
		//�жϻ�ȡ�����ַ�ʽ��class�����Ƿ���ͬ(��������ͬ��ֻ�����������ֲ�ͬ�Ľ׶�)
		System.out.println(clazz1 == clazz2);  //true
		System.out.println(clazz3 == clazz2);  //true
	}
}
