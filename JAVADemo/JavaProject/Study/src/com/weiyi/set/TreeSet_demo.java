package com.weiyi.set;
import java.util.Comparator;
import java.util.TreeSet;
import com.weiyi.Collection.Students;
public class TreeSet_demo {
	public static void main(String[] args) {
		//ʾ��1.TreeSet���ϻ���ʹ��
		TreeSet<Integer> ts = new TreeSet<>(); //����TreeSet����ȥ�غ�����
		ts.add(3);ts.add(1);ts.add(1);ts.add(2);ts.add(2);
		System.out.println("ʾ��1��\n" + ts);  //���Ԫ��
		
		//ʵ��2.TreeSet���ϱ�֤Ԫ��Ψһ����Ȼ���򣨲����˶�������ԭ��
		TreeSet<Students> st = new TreeSet<>();
		st.add(new Students("������",25));
		st.add(new Students("����",23));
		st.add(new Students("������",25));
		st.add(new Students("��ʦ��",24));
		System.out.println("ʾ��2��\n" + st);
		
		//ʾ��3.compareTo�е������ĶԱȲ��õ���unicode��
		System.out.println("ʾ��3��\n");
		System.out.println('��' + 0);
		System.out.println('��' + 0);
		System.out.println('��' + 0);
		System.out.println('��' + 0);
		
		
		//ʾ��4.TreeSet���ϱȽ���ԭ��
		System.out.println("ʾ��4��\n" + st);
		TreeSet<String> compare = new TreeSet<>(new CompareByLength());
		compare.add("aaaaa");
		compare.add("z");
		compare.add("xa");
		compare.add("weiyigeek");
		compare.add("cba");
		System.out.println("ʾ��4��\n" + compare);
	}
}

class CompareByLength extends Object implements Comparator<String>{
	//ע������:Comparator�ӿ���Ȼ������������������ֻд��һ��Ҳ���ᱨ��;�������е��඼Ĭ�ϻ���Object����������Ѿ���д��equals����
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int num = s1.length() - s2.length();   //�жϳ���
		return num == 0 ? s1.compareTo(s2) : num;  //����һ�����ж�����
	}
}
