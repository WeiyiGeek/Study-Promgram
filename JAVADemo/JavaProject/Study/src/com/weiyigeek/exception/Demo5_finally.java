package com.weiyigeek.exception;

public class Demo5_finally {
	public static void main(String[] args) {
		System.out.println(extracted());
	}

	public static String extracted() {
		int x = 10;
		try {
			x = 20;
			System.out.println(1/0);
			return "try������б���Ҫ��return���: " + x;
		} catch (Exception e) {
			x = 30;
			return "catch�������Ҳ����Ҫ��return���:" + x; //�൱��ռ����һ��������ֻ�ܴ�30(��finally��ɺ�������);
		} finally {
			x = 40; // ע���:finally�����(�������ͷ���Դ)��һ�����ܴ���return������Ὣ����try����catch�е�return���
		}
	}
}
