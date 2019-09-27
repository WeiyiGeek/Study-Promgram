package com.weiyi.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo1_MapCollection {

	public static void main(String[] args) {
		//示例1.Map集合的添加功能(注意Hash默认是不对数据进行排序的)
		Map<String, Integer> stu = new HashMap<String, Integer>();
		stu.put("小王",25);  //注意由于Key不能重复put第一次返回null,第二次则是返回被覆盖的值
		stu.put("小伟",88);
		stu.put("小赵",18);
		stu.put("小李",14);
		System.out.println("示例1: " + stu);
		
		//示例2.判断值是否包含键是否包含
		boolean keyFlag = stu.containsKey("小伟");
		boolean ValueFlag = stu.containsValue(88);
		System.out.println("示例2: " + "小伟 Key是否存在" + keyFlag +",88 Value是否存在" + ValueFlag + ", 是否为空 ：" + stu.isEmpty());

		//示例3.获取Map集合长度和集合中的键值
		System.out.println("示例3:\nMap集合长度: " + stu.size());
		System.out.println("获取指定Key的Value: " + stu.get("小伟"));
		System.out.println("获取Map集合所有Key: " + stu.keySet());
		System.out.println("获取Map集合所有Value: " + stu.values());
		
		//示例5.Map双列集合迭代方法(两种方法);Map集合的遍历之键找值
		//Iterator迭代器
		System.out.println("\n示例5:");
		Set<String> keySet = stu.keySet();  //返回是一个Set集合类型的值，而Set集合中存在迭代器则进行使用
		Iterator<String> ot = keySet.iterator(); // 获取迭代器
		while(ot.hasNext())
		{
			String key = ot.next(); //获取每一个键
			Integer value = stu.get(key); //根据键获取值
			System.out.println("Key=" + key + ", Value=" + value);
		}
		
		//增强for循环遍历方式(实际使用中推荐)
		for (String Key : stu.keySet()) {
			System.out.println(Key+":"+stu.get(Key));
		}

		//示例6.遍历之`键值对对象找键和值`思路
		System.out.println("\n示例6:");
		//Map.Entry说明Entry是Map的内部接口,将键和值封装成为Entry对象并存在再Set集合中
		Set<Map.Entry<String, Integer>> entryset = stu.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entryset.iterator();  //获取迭代器对象
		while(it.hasNext())
		{
			//获取每一个Entry对象
			Map.Entry<String, Integer> st = it.next();
			//之后就可以根据这个接口里面的方法获取值/keys
			String stkey = st.getKey();
			Integer stvalue = st.getValue();
			System.out.println( stkey + " - " + stvalue);
		}
		
		//还是可以采用增强for循环(实际开发中推荐方式)
		for (Map.Entry<String, Integer> entry : stu.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() + " " + entry.getClass());
		}
		
		//示例4.删除Map集合中的Key值
		System.out.println("\n示例4:\n移除删除键值对元素: " + stu.remove("小伟"));
		stu.clear();
		System.out.println("删除全部Key/Value: " + stu);
	}

}




