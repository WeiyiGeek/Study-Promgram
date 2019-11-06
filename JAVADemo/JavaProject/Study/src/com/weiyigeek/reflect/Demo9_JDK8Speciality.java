package com.weiyigeek.reflect;
public class Demo9_JDK8Speciality {
	public static void main(String[] args) {
		//JDK 8 ������
		Demo d = new Demo();
		d.print();

		Inter.method();  //��̬����ֱ�ӵ���
		
		d.run();
	}
}

interface Inter {
	//�Ǿ�̬��һ�㷽���������Default�����������Σ����򱨴�;
	public default void print() {
		System.out.println("Hello World!");
	}
	
	//��̬��������ֱ�Ӳ��ýӿ����Ƶ���
	public static void method() {
		System.out.println("Static Method");
	}
}


class Demo implements Inter {
	//�ֲ��ڲ��࣬���þֲ�����ʱ��1.7��ǰ���������final���Σ�������1.8�Ժ�Ͳ�����;
	public void run() {
		int flag = 1024; //�ֲ�����
		class Inner {
			public void num() {
				System.out.println("flag = " + flag);
			}
		}
		Inner i = new Inner();
		i.num();
	}
}
