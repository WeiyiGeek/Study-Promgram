package com.weiyigeek;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#ʾ��1.�ַ����ǲ��ɸ��ĵ�,���� �ַ���������֧�ֿɱ��ַ���
		String str = "abcdefg"; //�ַ�������
		System.out.println(str);  //����ַ���
		System.out.println(str.toString()); //String����д��toString�������ص��Ǹö�����;
		
		//#ʾ��2.�ַ����ǳ���һ������ֵ�����ܱ��ı�
		str = "���¸�ֵ,ԭ�����ַ����ͱ�������ȴ�������!";
		System.out.println(str);
		
		//#ʾ��3.String��Ĺ��췽��
		byte[] arr1 = {48, 65, 97};
		String s1 = new String(arr1); //ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ�����ֽ������������µ� String
		System.out.println(s1);
		
		byte[] arr2 = {97,98,99,100,101,102};
		String s2 = new String(arr2,2,3); //��arr2�����е�����Ԫ�ؿ�ʼ����ת��3��
		System.out.println(s2);
		
		char[] arr3 = {'a','b','c','d','e'}; //�ַ�����ת����Ϊ�ַ���
		String s3 = new String(arr3);
		System.out.println(s3);
	
		String s4 = new String(arr3,2,2); //�ַ������ָ��λ�ÿ�ʼת���ٸ�
		System.out.println(s4);
		
		String s5 = new String("WeiyiGeek");
		System.out.println(s5);
		
		//ʾ��3.������
		extracted();
		stackFinal();
	    diffrenent();
	}



	//��������û������ַ�������ʹ���,����о�ֱ�����ü���(��ͬ��ַ)
	private static void extracted() {
		String a1 = "abc";
		String b1 = "abc";
		System.out.println("��ʽ1��"+(a1 == b1));   //����ǰ��֪�� == ��Ĭ�ϱȽϵ��Ƕ����ַ,���������ַ����ǳ���ʵ��a1��b1ָ��ͬһ��;
		System.out.println("��ʽ2��"+b1.equals(a1));
	}

	//�������еĵ�ַ����ڴ��еĵ�ַ�ǲ�һ����;
	private static void stackFinal() {
		String s1 = new String("abc");	 //��¼���Ƕ��ڴ�ĵ�ֵַ		
		String s2 = "abc";               //��¼�ǳ������еĵ�ֵַ
		System.out.println(s1 == s2);    // == �Ƚϵ��ǵ�ַ
		System.out.println(s1.equals(s2));  //�Ƚϵ����ַ���
	}
	
	//�ַ�����������+�Լ�����������ת��Ϊ�ַ���
	private static void diffrenent() {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c"; //����StringBuffer ��ʹ��toStringת����String ; ���Ե�ַ�ǲ�ͬ��
		System.out.println("��ʽ1��" + (s3 == s2));  
		System.out.println("��ʽ2��" + s3.equals(s2));
	}
}
