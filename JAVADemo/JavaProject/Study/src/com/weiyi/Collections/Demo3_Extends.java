package com.weiyi.Collections;

import java.util.ArrayList;
import com.weiyi.Collection.Students;
public class Demo3_Extends {
	public static void main(String[] args) {
		ArrayList<Students> al = new ArrayList<>();
		al.add(new Students("�������", 23));
		al.add(new Students("���లȫ����", 30));
		
		ArrayList<ChildStudents> a2 = new ArrayList<>();
		a2.add(new ChildStudents("�������", 23));
		a2.add(new ChildStudents("���లȫ����", 30));

		al.addAll(a2); //�ؼ���:�����������ӵ�������󼯺�����ȥ
	}
}
