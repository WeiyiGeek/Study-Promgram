package com.weiyi.Map;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo5_Hashtable {

	public static void main(String[] args) {
		//HashMap��Hashtable������
		HashMap<String, Integer> hM = new HashMap<String, Integer>();
		hM.put(null, 23);
		hM.put("����", null);
		System.out.println("HashMap�ڼ�ֵΪnull���������ȷִ��" + hM);
		
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put(null,25);
		ht.put("����˭",null);
		System.out.println("Hashtable�ڼ�ֵΪnull������²�����ȷִ��(���Ա��䲻���)" + ht);
	}
}
