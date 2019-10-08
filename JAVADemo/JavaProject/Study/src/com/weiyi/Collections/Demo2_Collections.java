package com.weiyi.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Demo2_Collections {

	public static void main(String[] args) {
		//����:ģ�����ϴ�ƺͷ��ƣ�����û������
		//1.�����˿���
		String[] pk = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] color = {"����","����","��Ƭ","÷��"};
		//ƴ�ӻ�ɫ�����б��ż���
		ArrayList<String> poker = new ArrayList<>();
		for (String p : pk) {
			for (String c : color) {
				poker.add(c.concat(p));
			}
		}
		poker.add("����");
		poker.add("С��");
		System.out.println("������"+ poker.size() + "\n" + poker + "\n");
		
		//2.ϴ��
		Collections.shuffle(poker);
		
		//3.���ƺ͵���
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> C = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		
		for(int i = 0; i < poker.size(); i++)
		{
			if( i >= poker.size() - 3){
				dipai.add(poker.get(i)); //������ŵ���
			}else if(i % 3 == 0) {   //���ٵĵط����ˣ�����ȡ��������
				A.add(poker.get(i));
			}else if(i % 3 == 1) {
				B.add(poker.get(i));
			}else if(i % 3 == 2) {
				C.add(poker.get(i));
			}
		}
		
		//4.����(������)
		System.out.println("A:" + A);
		System.out.println("B:" + B);
		System.out.println("C:" + C);
		System.out.println("dipai:" + dipai);

	
		//#################��ʵ������#################
		//1.�����˿���
		String[] p1 = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] c1 = {"����","����","��Ƭ","÷��"};
		//���ü�ֵ�����洢���ǵ���(����ͷ�������������)
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		ArrayList<Integer> index = new ArrayList<Integer>();  //�洢����
		int i = 0;
		for(String sp1 : p1)
		{
			for (String sc1 : c1) {
				index.add(i);
				hm.put(i++,sc1.concat(sp1));
			}
		}
		
		index.add(i);
		hm.put(i++,"С��");
		index.add(i);
		hm.put(i,"����");
		
		//ϴ��
		Collections.shuffle(index);
		
		//����
		TreeSet<Integer> a = new TreeSet<Integer>();
		TreeSet<Integer> b = new TreeSet<Integer>();
		TreeSet<Integer> c = new TreeSet<Integer>();
		TreeSet<Integer> dp = new TreeSet<Integer>();
		for(i = 0; i < hm.size(); i++)
		{
			if( i >= hm.size() - 3){
				dp.add(index.get(i)); //������ŵ���
			}else if(i % 3 == 0) {   //���ٵĵط����ˣ�����ȡ��������
				a.add(index.get(i));
			}else if(i % 3 == 1) {
				b.add(index.get(i));
			}else if(i % 3 == 2) {
				c.add(index.get(i));
			}
		}
		
		//����(�ظ����ú�������ʽֵ��ѧϰ)
		lookup(hm, dp, "����");
		lookup(hm, a, "A");
		lookup(hm, b, "B");
		lookup(hm, c, "C");
	}

	public static void lookup(HashMap<Integer, String> hm, TreeSet<Integer> dp,String name) {
		ArrayList<String> flag = new ArrayList<String>();
		for (Integer idp : dp) {
			flag.add(hm.get(idp));
		}
		System.out.println("��ɫ"+name+"������:\n"+flag);
	}
}
