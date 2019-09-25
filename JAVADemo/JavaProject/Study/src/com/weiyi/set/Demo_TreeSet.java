package com.weiyi.set;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Demo_TreeSet {

	public static void main(String[] args) {
		//需求1.键盘录入5个学生信息(姓名,语数外成绩以,分割),之后按照总分从高到低输出到控制台Control
		Scanner sc = new Scanner(System.in);
		System.out.println("请用键盘录入5个学生信息(姓名,语数外成绩以,分割) : ");
		TreeSet<Student> st = new TreeSet<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				//由于需要从高到低排序(逆序所以)
				int num = o2.getSum() - o1.getSum(); //以对象的getSum()进行比较相减
				return num == 0 ? 1 : num;
			}
		});
		//只录入五次信息
		while(st.size() < 5 )
		{
			String line = sc.nextLine();
			String[] res = line.split(","); //以,分割转换成为字符串
			Integer chinese = Integer.parseInt(res[1]);
			Integer math = Integer.parseInt(res[2]);
			Integer english = Integer.parseInt(res[3]);
			//添加该对象到Treeset集合中
			st.add(new Student(res[0], chinese, math, english));
		}
		//输出集合中排序后的结果
		for (Student student : st) {
			System.out.println(student);
		}
	}

}

class Student {
	private String name;
	private int chinese;
	private int math;
	private int english;
	private int sum;
	//无参构造
	public Student() {
		super();
	}
	//有参构造
	public Student(String name, int chinese, int math, int english) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		//成绩总和传给集合排序使用
		this.sum = chinese + math + english;
	}
	//传出一个排序数据的来源
	public int getSum() {
		return sum;
	}
	//重新toString方法即输出样式
	@Override
	public String toString() {
		return "姓名: " + name + ", chinese=" + chinese + ", math=" + math + ", english=" + english + ", 总分="
				+ sum ;
	}
}
