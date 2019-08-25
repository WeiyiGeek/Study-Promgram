package com.weiyigeek.system;

public class Demo1_System {

	public static void main(String[] args) {
		//ʾ��1.�������ջ���(��Ҫ�õ�Object�е�)
		//protected void finalize()throws Throwable �������ռ�ȷ��û�жԶ��������ʱ���ɶ����ϵ������ռ������á�
		//������д finalize��������ϵͳ��Դ��ִ���������� 
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
			new GcDemo();
			System.gc(); //�����������ջ���(�������ﵽһ�����Ƶ�ʱ��)
		}
		
		//ʾ��2.��ǰϵͳʱ��(������) �� 1970��1��1�տ�ʼ
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\nѭ�����ѵĺ����� = " + (endTime - startTime));
		
		//ʾ��3.ֱ��copyArray
		int[] arr1 = {18,2017,2019,7,1,9};
		int[] arr2 = new int[5+arr1.length];
		arr2[1] = 1;
		arr2[4] = 4;
		System.arraycopy(arr1, 0, arr2, 5, arr1.length);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		//ʾ��4
		System.exit(0);  //�������˳�java
	}
}


//ע�⣺һ��java�ļ���ֻ��һ��public ������
class GcDemo {
	public int count = 0;
	@Override
	public void finalize() throws Throwable {
		count++;
		System.out.println(" - �������ڱ�����!");
		//super.finalize();
	}
}