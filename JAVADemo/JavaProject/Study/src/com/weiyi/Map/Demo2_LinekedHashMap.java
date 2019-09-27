package com.weiyi.Map;

import java.util.LinkedHashMap;

public class Demo2_LinekedHashMap {

	public static void main(String[] args) {
		//LinkedHashMap自动去除重复的键值
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		lhm.put("张三",15);
		lhm.put("张四",25);
		lhm.put("王五",35);
		lhm.put("赵六",25);
		lhm.put("张三",55);
		System.out.println(lhm);
		
	}

}
