package com.weiyigeek.stringbuffer;

import java.util.Scanner;

public class Demo3_Stringbuffer {
	public static void main(String[] args) {
		//ʵ��1. ����StringBuffer������ת����Ϊ�ַ���; "[1,2,3]"��ʽ
		int[] arr = {1,2,3};
		System.out.println(arrayToString(arr));
		
		
		//ʵ��2.����¼�뷴ת
		Scanner sc = new Scanner(System.in);  //����һ������¼�����
		System.out.print("������һ���ַ�: ");
		String line = sc.nextLine();  //������¼����ַ����洢��line��
		StringBuffer sb = reverseStr(line);
		System.out.println("�����������ݷ�ת  : " + sb);

		//ʵ��3.��ת�ַ������鲢����ض���ʽ
		String[] arr1 = {"Study","Java","Programming"};
		System.out.println(changeStrReverse(arr1));
		
	}

	//ʵ��1.��ȡ����
	private static String arrayToString(int[] arr) {
		StringBuffer sb1 = new StringBuffer();  //��������������(��ʡ�ڴ�-����Ҫ�ظ�������������Ч��)
		sb1.append("[");
		for(int i = 0; i < arr.length; i++)  //��������
		{
			if( i == arr.length-1 ){
				sb1.append(arr[i]).append("]");  //[�Ƽ���ʽ]
			}else {
				sb1.append(arr[i] + ",");  //ֻ��������ʽ���Ƽ�(�ײ㻹��new stringȻ��toString()),���Ի��ǽ������append�ķ���
			}
		}
		return sb1.toString();
	}
	
	//ʵ��2.��ȡ����
	public static StringBuffer reverseStr(String line) {
		StringBuffer sb = new StringBuffer(line); //�ص�,��������ַ������뻺����֮��
		sb.reverse(); //ע�������sb������
		return sb;
	}
	
	//ʵ��3. ��ȡ���� (���ﷵ�ط�������StringBuffer����һ��String��������)
	private static StringBuffer changeStrReverse(String[] arr1) {
		StringBuffer sb2 = new StringBuffer();
		sb2.append("{");
		for (int i = 0; i < arr1.length; i++) {
			if( i == arr1.length - 1)
			{
				sb2.append(reverseStr(arr1[i])).append("}");
			}else {
				sb2.append(reverseStr(arr1[i])).append(",");
			}
		}
		return sb2;
	}

}
