package com.weiyi.Map;

import java.util.HashMap;
import java.util.Map;

import com.weiyi.Collection.Students;

public class Demo1_MapClass {
	public static void main(String[] args) {
		//ʾ��˵��:�����������ǵ�students����,value�Ǵ���ÿһ��ѧ������Դ��
		Map<Students, String> ss = new HashMap<Students, String>();
		ss.put(new Students("������",25),"����"); //�ؼ���1����Students������д�� equals() �� hashcode()����  �����ȥ�����뼯��
		ss.put(new Students("������",25),"�Ϻ�"); //Value���Ϻ����Ḳ�Ǳ���
		ss.put(new Students("�չ���",18),"����"); 
		ss.put(new Students("���޻�",26),"����"); 
		System.out.println(ss);  //HashMap��д��toString() ����
	}
}
