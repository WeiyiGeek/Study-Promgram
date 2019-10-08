package com.weiyi.Map;

import java.util.HashMap;
import java.util.Map;

import com.weiyi.Collection.Students;

public class Demo4_HashMap {

	private static final HashMap<Students, String> Students = null;

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
		
		
		//示例2.集合HashMap内部嵌套HashMap
		/***
		 * 需求：定义多个期的一个双列集合，键是学习对象，值是学生归属地
		 */
		//定义单个期的双列集合元素
		HashMap<Students, String> h1 = new HashMap<Students, String>();
		h1.put(new Students("张三", 13),"北京");
		h1.put(new Students("李四", 53),"广州");
		h1.put(new Students("王五", 93),"深圳");

		
		HashMap<Students, String> h2 = new HashMap<Students, String>();
		h2.put(new Students("张伟", 98),"北京");
		h2.put(new Students("阿斯顿", 13),"重庆");
		h2.put(new Students("坤璄烤", 23),"浙江");
		
		//注意：下面开始嵌套了
		HashMap<HashMap<Students, String>, String> hhmm = new HashMap<HashMap<Students,String>, String>();
		hhmm.put(h1, "1999级");
		hhmm.put(h2, "2000级");
		
		System.out.println("\n示例2:");
		
		//嵌套输出遍历双列集合
		for(HashMap<Students, String> c : hhmm.keySet()) {
			String classbj = hhmm.get(c);  //精华之所在外层的HashMap
			for(Students d : c.keySet())   //注意这里是Students //获取集合中所有学生键对象
			{
				String value = c.get(d); 
				System.out.println("姓名/年龄:" + d + ",归属地" + value + ", 班级：" + classbj);
			}
		}
		
		
	}

}
