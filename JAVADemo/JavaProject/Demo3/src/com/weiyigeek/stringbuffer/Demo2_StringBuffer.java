package com.weiyigeek.stringbuffer;
public class Demo2_StringBuffer {
	public static void main(String[] args) {
		//ʵ��1.StringBuffer����String���໥ת��
		//String -> StringBuffer���� : ͨ�����췽�� ���� append() ����;
		StringBuffer sb1 = new StringBuffer("initialize ��ʼ��"); //ͨ��String����ת����ΪStringBuffer����;
		StringBuffer sb2 = new StringBuffer();
		sb2.append("initialize append");
		System.out.println("����1 : " + sb1);
		System.out.println("����2 : " + sb2);

		//StringBuferr -> String : ͨ�����췽�� ���� toString() ���� ���� subString(0, length)
		String s1 = new String(sb1);
		String s2 = sb1.toString();
		String s3 = sb1.substring(0, 10);
		System.out.println("����1 = " + s1);
		System.out.println("����2 = " + s2);
		System.out.println("����3 = " + s3);
		
		
		//ʵ��2.String��Stringbuffer�ֱ���Ϊ������������
		String s4 = "String parma";
		System.out.println("Դ�ַ��� : " + s4);
		changeStr(s4);  //һ��ջ���ڲ���s4�ͱ����������Ҳ����Stringһ����ʼ�������ᱻ�ı�
		System.out.println("changeStr ������: " + s4);
		
		StringBuffer sb3 = new StringBuffer();  //��������ָ��ͬһ������;
		sb3.append("append 1");
		System.out.println("��һ������ : " + sb3);
		changeStrBuf(sb3);
		System.out.println("�ڶ�������(����changeStrBuf) : " + sb3);
		
	}

	private static void changeStrBuf(StringBuffer sb3) {
		sb3.append(",append 2");
	}

	private static void changeStr(String s4) {
		s4 += "add";
		System.out.println("changeStr ������ :  " + s4);
	}

}
