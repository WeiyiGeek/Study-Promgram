package com.weiyi.generic;

public class Demo2_Generic {

	public static void main(String[] args) {
		//ʾ��1.�������ʹ��
		Tools<String> tls = new Tools<>();
		tls.show("Hello World!");
		tls.showMethod("Yes");
		tls.showStatic("Generic");
		
		//ʾ��2.�ӿڷ���
		Demo d1 = new Demo();
		d1.show("Interfaces");
		
		Demo1<String> d2 = new Demo1();
		d2.show("Interfaces");
	}
}

//ʾ��1.������(һ���ַ���д ����E)
class Tools<Q> {
	private Q obj;  //���ʹ�����ʲô���;���ʲô����

	public Q getObj() {
		return obj;
	}

	public void setObj(Q obj) {
		this.obj = obj;
	}
	
	public void show(Q str) {
		System.out.println("�෺��:"+str);
	}
	
	//ʾ��2.���������������ķ�����һ��,�����һ����Ҫ�ڷ����������÷���
	public<T> void showMethod(T t) {
		System.out.println("��������:"+t); 
	}
	
	//ʾ��3.ע��:���о�̬����������ļ��ض�����,�ڼ��ص�ʱ����ܻ�û���ֶ���;����˵�ھ�̬����������Ҳ���������Լ��ķ���
	public static<W> void showStatic(W w) {
		System.out.println("��̬��������:"+w);
	}
	
}


//ʾ��2.���ͽӿ�(һ���ַ���д ����E)
interface Inter<T> {
	public void show(T t);
}
//��ʽ1���Ƽ���ʽ
class Demo implements Inter<String> {
	@Override
	public void show(String t) {
		System.out.println("���ͽӿ�-ʾ��1:"+t);
	}
}
//��ʽ2��û�б�Ҫ��ʹ�ýӿڵ�ʱ��ָ������
class Demo1<T> implements Inter<T>
{
	@Override
	public void show(T t) {
		System.out.println("���ͽӿ�-ʾ��2:"+t);
	}
}
