package com.weiyi.Collections;

import java.util.ArrayList;
import com.weiyi.Collection.Students;
public class Demo3_Extends {
	public static void main(String[] args) {
		ArrayList<Students> al = new ArrayList<>();
		al.add(new Students("父类测试", 23));
		al.add(new Students("父类安全开发", 30));
		
		ArrayList<ChildStudents> a2 = new ArrayList<>();
		a2.add(new ChildStudents("子类测试", 23));
		a2.add(new ChildStudents("子类安全开发", 30));

		al.addAll(a2); //关键点:把子类对象添加到父类对象集合里面去
	}
}
