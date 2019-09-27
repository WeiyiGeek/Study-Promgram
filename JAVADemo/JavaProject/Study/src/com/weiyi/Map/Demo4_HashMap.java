package com.weiyi.Map;

import java.util.HashMap;

public class Demo4_HashMap {

	public static void main(String[] args) {
		//示例1.统计字符串中每个字符出现的次数
		String s = "abadsadasagsdasdc";
		char[] arr = s.toCharArray();
		//定义有一个双列集合存储字符以及字符出现的次数（一般清情况雄下采用HashMap）
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : arr) {
			//方式1
//			if(!hm.containsKey(c)) {
//				hm.put(c, 1);
//			}else {
//				int num = hm.get(c);
//				hm.put(c, hm.get(c) + 1);
//			}
			//方式2：推荐方式使用可键不可重复的特性
			hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
		}
		
		System.out.println("示例1：\n字符串中单个不相同字符的数量 : " + hm);
	}

}
