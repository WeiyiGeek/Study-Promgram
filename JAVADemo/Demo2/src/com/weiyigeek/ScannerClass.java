package com.weiyigeek;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//ʾ��1�������ʽ�ж�
		System.out.print("������һ������:");
		if (sc.hasNextInt()) {
			System.out.println("������"+sc.nextInt());
		}else {
			System.out.println("��ʽ����");
		}
		
		//ʾ��2.NextInt��nextLine���õ�����
		System.out.print("������ڶ���1���֣�");
		int integer = sc.nextInt();
		System.out.println("������ڶ����ַ�����");
		String line = sc.nextLine();
		System.out.println("Integer ����:"+integer+","+line);
		//�������1���������ζ���
		int i = sc.nextInt();
		Scanner lineStr = new Scanner(System.in);
		String line1 = lineStr.nextLine();
		System.out.println("�������: ����="+ i +", �ַ���=" + line1);
	}
}
