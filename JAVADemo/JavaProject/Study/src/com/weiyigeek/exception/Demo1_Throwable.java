package com.weiyigeek.exception;
public class Demo1_Throwable {
	public static void main(String[] args) {
		//(1) Throwable ��������
		try {
			System.out.println(1/0);
		} catch(Exception e) {  //Exception e = new ArithmeticException("/ by zero")
			System.out.println("1." + e.getMessage());  //��ȡ�쳣��Ϣ
			System.out.println(e);  //����toString������ӡ�쳣�������쳣��Ϣ
			e.printStackTrace();    //jvmĬ�Ͼ��õ����ַ�ʽ�����쳣
		}
	}
}

/**
 *  //ִ�н��
 *  1./ by zero
	2.java.lang.ArithmeticException: / by zero
	3.java.lang.ArithmeticException: / by zero
		at com.weiyigeek.exception.Demo1_Throwable.main(Demo1_Throwable.java:8)
 *
 */