package com.weiyi.Map;

import java.util.LinkedHashMap;

public class Demo2_LinekedHashMap {

	public static void main(String[] args) {
		//LinkedHashMap�Զ�ȥ���ظ��ļ�ֵ
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		lhm.put("����",15);
		lhm.put("����",25);
		lhm.put("����",35);
		lhm.put("����",25);
		lhm.put("����",55);
		System.out.println(lhm);
		
	}

}
