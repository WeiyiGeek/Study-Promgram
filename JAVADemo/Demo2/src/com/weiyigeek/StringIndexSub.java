package com.weiyigeek;

public class StringIndexSub {
	public static void main(String[] args) {
		//ʾ��1.�ַ�������length()��ʵ�ǻ�ȡÿһ���ַ��ĸ�����������Ӣ��
		String s1 = "WeiyiGeek";
		String s2 = "����һ��java������";
		System.out.println("English Text is "+s1+", Length = " +s1.length());
		System.out.println("Chinese Text is "+s2+", Length = " +s2.length());
		
		
		//ʾ��2.��ȡָ���������ַ����߼�¼�ַ����ֵ�����(+ �������""Ĭ���ǽ��ַ������Ϊascii��Ų��������)
		System.out.println(s1.charAt(0)+""+s1.charAt(1)+""+s1.charAt(2)+""+s1.charAt(3)+""+s1.charAt(4));
		System.out.println("Index : " + s2.indexOf('j'));   //�������յ���int���ͣ�����char���ͻ��Զ�������
		System.out.println("Index : " + s2.indexOf("java")); //����������򷵻� -1
		System.out.println("Index : " + s2.indexOf("������",5)+"\n"); //ָ��λ�ÿ�ʼ��ǰ�����
		
		System.out.println("lastIndex : " + s2.lastIndexOf('j')); //�Ӻ���ǰ�ҵ�һ�γ��ֵ��ַ���
		System.out.println("lastIndex : " + s1.lastIndexOf("e", 7)); //��ָ��λ����ǰ��(ע��������ָ����λ����Ȼ�Ǵ��ַ���ͷ����β��)
		System.out.println("lastIndex : " + s2.lastIndexOf("java",4)+"\n"); //�ӵ�4��λ�ý��в���ƥ��
		
		//ʾ��3.ָ����ȡ�ַ���
		System.out.println("My Name is " + s1.substring(0, 5) + ", I am is " + s1.substring(5)); //ָ��λ�ý�ȡ��ĩβ
		//�ؼ��㣺ע���ַ�����Щ���������ַ����Ͻ��в���,�еĲ����ַ���������в���(substring)����ı�Դ�ַ���;
		
		//ʾ��4.�ַ����ı�����ͨ��forѭ����ȡ���ַ�����ÿ���ַ�������;
		String Demo = "Hacker";
		for(int i = 0; i < Demo.length(); i++)
		{
			System.out.println(Demo.charAt(i));
		}
		
		//ʵ�ʰ���
		countNumber();
	}
	
	//ͳ���ַ����д�Сд���ַ����ַ��Լ������ַ����ִ�ʱ
	public static void countNumber() {
		String s = "abcdefABCDE123456!@#$%%^";
		int cap = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if( c >= 'a' && c <= 'z'){
				small++;
			}else if(c >= 'A' && c <= 'Z'){
				cap++;
			}else if(c >= '0' && c <= '9'){
				num++;
			}else {
				other++;
			}
		}
		System.out.println("��д��ĸ����: " + cap + ", Сд��ĸ����: " + small + ", ���ָ���: " + num + ", �����ַ�����" + other);
	}
}
