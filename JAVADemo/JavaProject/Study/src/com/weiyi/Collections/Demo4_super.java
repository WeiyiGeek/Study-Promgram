package com.weiyi.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import com.weiyi.Collection.Students;
public class Demo4_super {
	public static void main(String[] args) {
		TreeSet<Students> ts1 = new TreeSet<>(new CompareByAge());
		ts1.add(new Students("父类", 1024));
		ts1.add(new Students("父类1", 1021));

		TreeSet<ChildStudents> ts2 = new TreeSet<>(new CompareByAge());
		ts2.add(new ChildStudents("子类", 1023));
		ts2.add(new ChildStudents("子类", 1021));
		
		//关键点注意ts1与ts2的输出
		System.out.println(ts1);
		System.out.println(ts2);  //子类对象同样的可以进行按照age排序(说白了子类也可以采用父类的比较器)
	}

}

//重写比较器来验证泛型固定下边界(Students对象作比较)
class CompareByAge implements Comparator<Students> 
{
	@Override
	public int compare(Students o1, Students o2) {
		int num = o1.getAge() - o2.getAge();
		return num == 0 ? o1.getName().compareTo(o2.getName()) : num;
	}
}
