//����3: ö�ٵõ�������ʽ�Ƚ���
package com.weiyigeek.reflect;

//�����ǳ��������Բ����ڲ�������
public abstract class Demo7_Week1 {
	//��������ָ��������� ������������������
	public static final Demo7_Week1 Sun = new Demo7_Week1("������") {
		public void show() {
			System.out.println("������");
		}
	};	
	private String week;
	public Demo7_Week1(String w) {
		this.week = w;
	}

	//����˵�����󷽷������ڳ�������
	public abstract void show();
}
