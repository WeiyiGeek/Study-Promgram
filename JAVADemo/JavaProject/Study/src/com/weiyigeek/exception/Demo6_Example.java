package com.weiyigeek.exception;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Demo6_Example {

	public static void main(String[] args) {
		// ����1.��������һ��int���͵������������������Ʊ�����ʽ;
		System.out.println("/***\n*** ������ת���쳣������ ***\n***/");
		Scanner sc = new Scanner(System.in);
		System.out.print("������һ������: ");

		while(true) {
			String line = sc.nextLine();
			try {
				int num = Integer.parseInt(line);	
				System.out.println(line+ "(Binary) = " +Integer.toBinaryString(num));
			} catch(Exception e) {
				try {
					new BigInteger(line);  //������С���ͷǳ��ַ����쳣;
					System.out.println("�������,¼�����һ�����������,����������:");
				} catch (Exception e2) {
					//��������ֵ��ѧϰ��
					try {
						new BigDecimal(line);
						System.out.println("�������,¼�����һ��С��,����������:");
					} catch (Exception e3) {
						System.out.println("�������,��¼����ǷǷ��ַ�,����������һ������:");
					}
				} 
				
			}	
		}
	}
}
