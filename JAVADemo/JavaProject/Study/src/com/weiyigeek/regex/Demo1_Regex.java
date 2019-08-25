/**
 *  * a:��������ʽʵ�� 
    * b:������ʽʵ��
	*    ����: У��qq����
    * 1:Ҫ�������5-15λ����
    * 2:0���ܿ�ͷ
    * 3:���붼������
 */

package com.weiyigeek.regex;
public class Demo1_Regex {
	public static void main(String[] args) {
		//ʾ��1.���÷�������ʽʵ�� param1 String
		String str = new String("12345678");
		System.out.println("��������֤ƥ�� :  "+notRegex(str));
		
		//ʾ��2������ʽString.matches()
		System.out.println("����ƥ���� : " + str.matches("^[1-9]\\d{4,14}"));
		System.out.println("����ƥ���� : " + "01234579".matches("^[1-9]\\d{4,14}"));
	}

	private static boolean notRegex(String str) {
		boolean flag = false;
		if(str.length() > 4 && str.length() < 16){
			if(!str.startsWith("0")) {
				char[] arr = str.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] > '0' && arr[i] < '9') {
						flag = true;
					}else {
						break;
					}
				}
			}
		}
		return flag;
	}
}
