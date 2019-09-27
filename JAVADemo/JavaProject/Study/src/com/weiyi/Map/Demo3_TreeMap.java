package com.weiyi.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import com.weiyi.Collection.Students;

public class Demo3_TreeMap {

	public static void main(String[] args) {
		//ʾ��1.TreeMap���ϲ���com.weiyi.Collection.Students����Students�൱��������ΪKey(���������������),StringΪ��Դ��
		TreeMap<Students, String> tm = new TreeMap<>();  //TreeMap���������compareTo���бȽ�ȥ���ظ�(�粻��д��ᵼ��ClassCastException�쳣)
		tm.put(new Students("�չ���",26), "����");
		tm.put(new Students("���޻�",27), "�Ϻ�");
		tm.put(new Students("������",100), "����");
		tm.put(new Students("�չ���",26), "����");   //���ǵ�һ��
		System.out.println(tm);
		
		//ʾ��2.������Comparator��дcompare����ʵ�ְ�����������(����)
		TreeMap<Students, String> ss = new TreeMap<Students, String>(new Comparator<Students>() {
			@Override
			public int compare(Students o1, Students o2) {
				int num = o1.getName().compareTo(o2.getName());
				return num == 0 ? o1.getAge() - o2.getAge():num ;
			}
		});
		ss.put(new Students("�չ���",26), "����");
		ss.put(new Students("���޻�",27), "�Ϻ�");
		ss.put(new Students("����",100), "����");
		ss.put(new Students("�չ���",26), "����");   //ͬ���Ǹ��ǵ�һ��
		System.out.println(ss);
		System.out.println('��' + 0);  //���Բ鿴unicode��ó�˳��
		System.out.println('��' + 0);
		System.out.println('��' + 0);
		

		}

}
