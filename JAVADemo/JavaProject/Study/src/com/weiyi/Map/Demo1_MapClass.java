package com.weiyi.Map;

import java.util.HashMap;
import java.util.Map;

import com.weiyi.Collection.Students;

public class Demo1_MapClass {
	public static void main(String[] args) {
		//示例说明:将键存入我们的students对象,value是存入每一个学生的生源地
		Map<Students, String> ss = new HashMap<Students, String>();
		ss.put(new Students("王爱国",25),"北京"); //关键点1由于Students类中重写了 equals() 和 hashcode()方法  会进行去除插入集合
		ss.put(new Students("王爱国",25),"上海"); //Value的上海将会覆盖北京
		ss.put(new Students("颜国富",18),"广州"); 
		ss.put(new Students("渝艳华",26),"重庆"); 
		System.out.println(ss);  //HashMap重写了toString() 方法
	}
}
