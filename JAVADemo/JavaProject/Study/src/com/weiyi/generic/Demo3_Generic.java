package com.weiyi.generic;

import com.weiyi.Collection.Students;
import java.util.ArrayList;
import java.util.List;

public class Demo3_Generic {

	public static void main(String[] args) {
		//实例1.当右边的泛型不确定时,左边可以指定为?
		List<?> list = new ArrayList<Integer>();

		//实例2.通配符案例验证
		ArrayList<Study> list1 = new ArrayList<>();
		list1.add(new Study("1.王老五", 15)); //子类
		list1.add(new Study("2.王老吉", 15));
		list1.add(new Study("3.王老四", 15));
		
		ArrayList<Students> list2 = new ArrayList<>();
		list2.add(new Students("4.测试",25));  //父类
		list2.add(new Students("5.学生类",25));

		list2.addAll(list1);   //父类添加拼接子类的集合 （注意不能父类强制转换成为子类list1.addAll(list2))
		System.out.println("输出结果:"+list2);
	}
}


//实例1
class Study extends Students {
	public Study() {
		super();
	}
	public Study(String name, int age) {
		super(name, age);
	}
}