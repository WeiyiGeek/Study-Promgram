package com.weiyigeek.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.weiyi.Collection.Students;
public class Demo1_Reflect {
	public static void main(String[] args) throws Exception {
		//1.��ȡClass�ļ���������ֺ췽ʽ
		Class clazz1 = Class.forName("com.weiyi.Collection.Students"); //��ʽ1 ��ȡһ������ֽ����ļ�
		Class clazz2 = Students.class; //��ʽ2
		
		Students clazz = new Students();
		Class clazz3 = clazz.getClass(); //��ʽ3
		
		//�жϻ�ȡ�����ַ�ʽ��class�����Ƿ���ͬ(��������ͬ��ֻ�����������ֲ�ͬ�Ľ׶�)
		System.out.println(clazz1 == clazz2);  //true
		System.out.println(clazz3 == clazz2);  //true
		
		
		//2.�����ȡ�������Ĺ��췽����ʹ��
		//Class clazz4 = Class.forName("com.weiyigeek.Collection.Students"); //[Error]�ظ����ط�����ᱨ��
		Constructor<Students> cs = clazz1.getConstructor(String.class,int.class); //��ȡ�вι���
		Students s = (Students) cs.newInstance("�вι���",1024);  //�ص㡣�����вι��촴������
		System.out.println(s);
		
		
		//3.ͨ�������ȡ��Ա������ʹ��
		//������Ա������ʱ��
		//Field demo = clazz1.getField("name");
		//demo.set(s, "����");
		
		//˽�г�Ա������ʱ��
		Field f = clazz1.getDeclaredField("name"); //������ȡ�ֶ�name
		f.setAccessible(true); //ȥ��˽������
		f.set(s, "Field");
		System.out.println(s);
		
		
		//4.ͨ�������ȡ����
		Method m = clazz1.getMethod("reflectDemo"); //��ȡ���еķ���
		m.invoke(s); //ִ���޲η���reflectDemo
		Method m1 = clazz1.getMethod("reflectDemo", int.class); //��ȡ�в�����ʽ
		m1.invoke(s, 1024);
		
		
		//5.ͨ������Խ�����ͼ��
		//ArrayList <Integer>��һ��������������������һ���ַ����������ʵ�ֵ���?
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		//ע���������ڷ��͵����Բ��ܼ����ַ��� "abc"
		//list.add("abc")
		//�������ǿ���ͨ������Reflect���������
		Class clazz6 = Class.forName("java.util.ArrayList"); //��ȡArrayList�ֽ������
		Method m2 = clazz6.getMethod("add",Object.class); //��ȡadd����
		m2.invoke(list, "abc");
		System.out.println("�����ƹ�����: " + list);
	}
}
