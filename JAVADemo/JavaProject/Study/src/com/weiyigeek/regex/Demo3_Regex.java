package com.weiyigeek.regex;
public class Demo3_Regex {
	public static void main(String[] args) {
		//ʾ��1.�����ʹ��(�������) ��������,�������
		System.out.println("ʾ��1-1 : " + "��������".matches("(.)\\1(.)\\2"));
		System.out.println("ʾ��1-2 : " + "���Ŀ���".matches("(..)\\1"));
		
		//ʾ��2.�и������밴�յ����и "sdqqfgkkkhjppppkl";
		String str = new String("sdqqfgkkkhjppppkl");
		String[] Arr = str.split("(.)\\1+");
		for (int i = 0; i < Arr.length; i++) {
			System.out.println(Arr[i]);
		}
		
		//ʾ��3.�滻��������....��...��.Ҫ...ҪҪ...Ҫѧ....ѧѧ..ѧ.��..���.��.��.��.��..�̽��ַ�����ԭ��:����Ҫѧ��̡���
		String s1 = "����....��...��.Ҫ...ҪҪ...Ҫѧ....ѧѧ..ѧ.��..���.��.��.��.��..��";
		String res = s1.replaceAll("\\.", "").replaceAll("(.)\\1\\1", "");  //��ʽ1
		String res1 = s1.replaceAll("\\.", "").replaceAll("(.)\\1+", "$1");  //��ʽ2 (�������$1���沶���ֵ��ѧϰ)
		System.out.println(res + "\n" + res1);
	}
}
