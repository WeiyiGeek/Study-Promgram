package com.weiyigeek;

public class StringReplace {

	public static void main(String[] args) {
		//ʾ��1.�ַ����滻replace
		String s = "I love Java Programing!";
		String s1 = s.replace("o", "A");  
		String s2 = s.replace("Java", "PHP");    //���û���ҵ��滻�ַ�����ԭ�ַ������ı�;
		System.out.println("o -> A : " + s1);
		System.out.println("Java -> PHP : " + s2);
		
		//ʾ��2.��ȥ�ַ������ߵĿո�
		String s3 = "  Weiyi Geek  ";
		String s4 = s3.trim();
		System.out.println("���� blank space ȥ�� : " + s4);
		
		
		//ʾ��3.�Ƚ������ַ���ʵ�ʽ�ascii����бȽ�����������һ���ַ����Ϊ0��,�ڶ����ַ������������ֱ���ַ���ĩβ;
		String s5 = "abc";
		String s6 = "bcd";
		int num = s5.compareTo(s6);  //�ǰ������ֵ���бȽ�
		System.out.println("s5 < s6 = " + num); // 97(a) - 98(b) = -1 
		//�����ִ�д�Ƚ�
		int num2 = "weiyigeek".compareToIgnoreCase("WeiyiGeek");
		System.out.println("CompareToIgnoreCase �����ִ�Сд: " + num2);
		//javaĬ����utf-8���
		int num1 = "Ψ".compareTo("һ");
		System.out.println('Ψ'+0);
		System.out.println('һ'+0);
		System.out.println("unicode(Ψ) - unicode(һ) = " + num1);
		
	}

}
