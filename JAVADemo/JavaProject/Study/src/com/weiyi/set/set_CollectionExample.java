
package com.weiyi.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author WeiyiGeek
 */
public class set_CollectionExample {
	public static void main(String[] args) {
		//����1������һ�����ϴ洢�ظ��������Ԫ��,�����ǲ�ȥ��;
		ArrayList<String> demo = new ArrayList<>();
		demo.add("weiy_");
		demo.add("Сΰ");
		demo.add("weiyi");
		demo.add("WeiyiGeek");
		demo.add("weiyi");
		//����ķ�������������
		sort(demo);
		//��ӡList
		System.out.println("����1��\n" + demo );
		
		//����2���Ӽ�������һ���ַ������������������(��Ȼ��ȥ�ظ�)
		System.out.println("����2��");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����봮�ַ���: ");
		String line = sc.nextLine();
		char[] arr = line.toCharArray(); //�ַ���ת����Ϊ�ַ�����
		TreeSet<Character> ch = new TreeSet<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				// TODO Auto-generated method stub
				int flag = c1.compareTo(c2);  //����Ͳ����Զ�������(ֵ��ѧϰ)
				return flag == 0 ? -1 : flag;
			}
		});
		//���ַ�����ֵ���뵽TreeSet����֮�У���Ҫ�Զ�װ�䣩
		for (Character c : arr) {
			ch.add(c);
		}
		//��������ַ�
		for (Character de : ch) {
			System.out.print(de + " ");
		}
		
		
		//ʾ��3.��������������ֱ��quitʱ���˳�������������������������д�ӡ;
		System.out.println("\nʾ��3:");
		TreeSet<Integer> in = new TreeSet<Integer>(new Comparator<Integer>() {
			//�����ڲ���
			@Override
			public int compare(Integer i1, Integer i2) {
				//��������Ҫ�������������Ｏ����Ԫ��i2��ȥ���õĲ���i1
				int num = i2 - i1;
				return num == 0 ? 1 : num; //����Ҫ�޳��ظ��򷵻ط�0����
			}
		});
		
		while(!(line = sc.nextLine()).equals("quit")) {
			//���ַ���ת��Integer����(��׽�쳣)
			try{
				Integer i = Integer.parseInt(line);
				in.add(i);
			} catch (Exception e){
				System.out.println("�����ֵ������!");
			}
		}
		
		System.out.println("���ϵ�������"+in);
		System.out.println("Game Over!");
	}

	public static void sort(ArrayList<String> demo) {
		// 1)����TreeSet���϶��󣬻���Ҫ�Զ���Ƚ���(����String��Ȼ�Դ��Ƚ��������ظ����ܹ�����)��������������ڲ���ʵ�֡�
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o1.compareTo(o2);
				return num == 0 ? 1 : num;  //����֮��
			}
		});
		// 2)���б�Ԫ�ظ�TreeSet����
		ts.addAll(demo);
		// 3)���list�б���Ԫ��
		demo.clear();
		// 4)���ź����Ԫ�����·���list��
		demo.addAll(ts);
	}
}
