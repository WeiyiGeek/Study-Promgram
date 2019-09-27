package com.weiyi.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import com.weiyi.Collection.Students;

public class Demo3_TreeMap {

	public static void main(String[] args) {
		//示例1.TreeMap集合采用com.weiyi.Collection.Students包中Students类当作对象作为Key(按照年龄进行排序),String为生源地
		TreeMap<Students, String> tm = new TreeMap<>();  //TreeMap对象采用了compareTo进行比较去除重复(如不重写则会导致ClassCastException异常)
		tm.put(new Students("颜国富",26), "北京");
		tm.put(new Students("喻艳华",27), "上海");
		tm.put(new Students("张三丰",100), "深圳");
		tm.put(new Students("颜国富",26), "广州");   //覆盖第一条
		System.out.println(tm);
		
		//示例2.匿名类Comparator重写compare方法实现按照姓名排序(升序)
		TreeMap<Students, String> ss = new TreeMap<Students, String>(new Comparator<Students>() {
			@Override
			public int compare(Students o1, Students o2) {
				int num = o1.getName().compareTo(o2.getName());
				return num == 0 ? o1.getAge() - o2.getAge():num ;
			}
		});
		ss.put(new Students("颜国富",26), "北京");
		ss.put(new Students("喻艳华",27), "上海");
		ss.put(new Students("三丰",100), "深圳");
		ss.put(new Students("颜国富",26), "广州");   //同样是覆盖第一条
		System.out.println(ss);
		System.out.println('喻' + 0);  //可以查看unicode码得出顺序
		System.out.println('张' + 0);
		System.out.println('颜' + 0);
		

		}

}
