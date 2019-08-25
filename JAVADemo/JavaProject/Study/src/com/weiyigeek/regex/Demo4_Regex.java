package com.weiyigeek.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo4_Regex {

	public static void main(String[] args) {
		//ʾ��1.Pattern��ļ�ʵ��
		Pattern p = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE); //��ȡ������ʽ�����ִ�Сд (��ʽ1)
		Matcher m = p.matcher("AABBB"); //��ȡ������
		boolean b1 = m.matches();  //�ж��Ƿ��ܽ���ƥ��
		boolean b2 = Pattern.compile("[a-z]+").matcher("AABBB").matches(); //����2 ��ʽƥ��
		System.out.println("��ʽ1 �Ľ�� : " + b1);
		System.out.println("��ʽ2 �Ľ�� : " + b2);
		
		//ʾ��2.Pattern��Matcher�Ľ��ʹ�ý��� �ֻ�������ƥ��
		String s = "�ҵ��ֻ�����:18983441325, �����ù�18487258412, ���ù�18883420241";
		Matcher m1 = Pattern.compile("1[456789]\\d{9}").matcher(s);
		//ע��Ҫ�����ٻ�ȡע�������find��ȡ��һ��������һ��λ�ý��в���
		System.out.println("��ȡ���ĵ绰����:");
		while(m1.find())
			System.out.println(m1.group());
	}
}
