package com.weiyi.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import com.weiyi.Collection.Students;
public class Demo4_super {
	public static void main(String[] args) {
		TreeSet<Students> ts1 = new TreeSet<>(new CompareByAge());
		ts1.add(new Students("����", 1024));
		ts1.add(new Students("����1", 1021));

		TreeSet<ChildStudents> ts2 = new TreeSet<>(new CompareByAge());
		ts2.add(new ChildStudents("����", 1023));
		ts2.add(new ChildStudents("����", 1021));
		
		//�ؼ���ע��ts1��ts2�����
		System.out.println(ts1);
		System.out.println(ts2);  //�������ͬ���Ŀ��Խ��а���age����(˵��������Ҳ���Բ��ø���ıȽ���)
	}

}

//��д�Ƚ�������֤���͹̶��±߽�(Students�������Ƚ�)
class CompareByAge implements Comparator<Students> 
{
	@Override
	public int compare(Students o1, Students o2) {
		int num = o1.getAge() - o2.getAge();
		return num == 0 ? o1.getName().compareTo(o2.getName()) : num;
	}
}
