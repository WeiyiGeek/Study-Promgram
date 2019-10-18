package com.weiyigeek.Thread;

public class Demo11_Singleton {

	public static void main(String[] args) {
		// ʵ�ֵ������ģʽ�ļ��ַ���
		// 1.����ʽ
		Singleton s1 = Singleton.getInstance(); 
		Singleton s2 = Singleton.getInstance();
		if(s1 == s2) {
			s1.print();
		}
		
		// 2.����ʽ
		Singleton1 sl1 = Singleton1.getInstance(); 
		Singleton1 sl2 = Singleton1.getInstance();
		if(sl1 == sl2) {
			sl1.print();
		}
		
		// 3.����ʽ
		Singleton2 slt1 = Singleton2.s;
		Singleton2 slt2 = Singleton2.s;
		System.out.println(slt1 == slt2);
	}
}

//��ʽ1:����ʽ��������ʹ�����ַ�ʽ��
class Singleton {
	//1,˽�й��캯��
	private Singleton(){}
	//2,�����������
	private static Singleton s = new Singleton();
	//3,�����ṩ�����ķ��ʷ���
	public static Singleton getInstance() {
		return s;
	}
	public static void print() {
		System.out.println("����1");
	}
}


//��ʽ2:����ʽ����ʱ����ʹ��
class Singleton1 {
	//1,˽�й��캯��
	private Singleton1() {};
	//2,����������󣨵���������и�ֵ��
	private static Singleton1 s;
	//3,�����ṩ�����ķ��ʷ���
	public static Singleton1 getInstance() {
		if(s == null)
			//�߳�1,�߳�2�����̵߳�ʱ��ᵼ�°�ȫ���⣬�������Ե�ʱ�򲻽���ʹ�ã�
			s = new Singleton1();
		return s;
	}
	public static void print() {
		System.out.println("��ʽ2");
	}
}


//��ʽ3����������
class Singleton2 {
	//��һ��.���ǹ���˽�к���
	private Singleton2() {};
	//�ڶ���.���侫��֮����
	public static final Singleton2 s = new Singleton2();
}