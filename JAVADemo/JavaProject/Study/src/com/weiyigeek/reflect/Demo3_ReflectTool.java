package com.weiyigeek.reflect;
import java.lang.reflect.Field;
public class Demo3_ReflectTool {
	//1.ͨ������дһ��ͨ�����������޸�ĳ������ֵ(ʵ�ʰ�ǰ����ѧ��һ���ܽ�)
	public Demo3_ReflectTool() {};
	public void setProperty(Object obj, String propertyName, Object value) throws Exception {
		Class clazz = obj.getClass(); //��ȡ�ֽ������
		Field f = clazz.getDeclaredField(propertyName); //���߶�����˽�г�Ա����
		f.setAccessible(true);   //ȥ��˽�г�Ա����Ȩ��
		f.set(obj, value); //���øĳ�Ա������ֵ
	}
	public void run() {
		System.out.println("Welcome to China");
	}
}
