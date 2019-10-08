package com.weiyi.Map;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo5_Hashtable {

	public static void main(String[] args) {
		//HashMap与Hashtable的区别
		HashMap<String, Integer> hM = new HashMap<String, Integer>();
		hM.put(null, 23);
		hM.put("张三", null);
		System.out.println("HashMap在键值为null的情况下正确执行" + hM);
		
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put(null,25);
		ht.put("我是谁",null);
		System.out.println("Hashtable在键值为null的情况下不能正确执行(所以本句不输出)" + ht);
	}
}
