package com.weiyi.set;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Demo_TreeSet {

	public static void main(String[] args) {
		//����1.����¼��5��ѧ����Ϣ(����,������ɼ���,�ָ�),֮�����ִܷӸߵ������������̨Control
		Scanner sc = new Scanner(System.in);
		System.out.println("���ü���¼��5��ѧ����Ϣ(����,������ɼ���,�ָ�) : ");
		TreeSet<Student> st = new TreeSet<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				//������Ҫ�Ӹߵ�������(��������)
				int num = o2.getSum() - o1.getSum(); //�Զ����getSum()���бȽ����
				return num == 0 ? 1 : num;
			}
		});
		//ֻ¼�������Ϣ
		while(st.size() < 5 )
		{
			String line = sc.nextLine();
			String[] res = line.split(","); //��,�ָ�ת����Ϊ�ַ���
			Integer chinese = Integer.parseInt(res[1]);
			Integer math = Integer.parseInt(res[2]);
			Integer english = Integer.parseInt(res[3]);
			//��Ӹö���Treeset������
			st.add(new Student(res[0], chinese, math, english));
		}
		//��������������Ľ��
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
	//�޲ι���
	public Student() {
		super();
	}
	//�вι���
	public Student(String name, int chinese, int math, int english) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		//�ɼ��ܺʹ�����������ʹ��
		this.sum = chinese + math + english;
	}
	//����һ���������ݵ���Դ
	public int getSum() {
		return sum;
	}
	//����toString�����������ʽ
	@Override
	public String toString() {
		return "����: " + name + ", chinese=" + chinese + ", math=" + math + ", english=" + english + ", �ܷ�="
				+ sum ;
	}
}
