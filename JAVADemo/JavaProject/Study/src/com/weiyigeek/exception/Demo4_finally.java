package com.weiyigeek.exception;

public class Demo4_finally {
	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("��������ΪZero");
			return; //�൱���Ƿ��������һ����,��������֮ǰ�ῴ����ľ��finally���������Ը������оͽ�finallyִ�к��ٳ��׷���;
			// System.exit(0);  //��ʾ�˳�JVM�����
		} finally {
			System.out.println("��return����ǰִ����,�������System.exit(0)�����򲻻�ִ��finally");
		}
	}
}
