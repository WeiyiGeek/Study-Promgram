
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
		//需求1：输入一个集合存储重复且无序的元素,排序但是不去重;
		ArrayList<String> demo = new ArrayList<>();
		demo.add("weiy_");
		demo.add("小伟");
		demo.add("weiyi");
		demo.add("WeiyiGeek");
		demo.add("weiyi");
		//定义的方法对其排序保留
		sort(demo);
		//打印List
		System.out.println("需求1：\n" + demo );
		
		//需求2：从键盘输入一个字符串程序对其排序后输出(任然不去重复)
		System.out.println("需求2：");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入串字符串: ");
		String line = sc.nextLine();
		char[] arr = line.toCharArray(); //字符串转换成为字符数组
		TreeSet<Character> ch = new TreeSet<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				// TODO Auto-generated method stub
				int flag = c1.compareTo(c2);  //这里就不用自动拆箱了(值得学习)
				return flag == 0 ? -1 : flag;
			}
		});
		//将字符数组值传入到TreeSet集合之中（需要自动装箱）
		for (Character c : arr) {
			ch.add(c);
		}
		//遍历输出字符
		for (Character de : ch) {
			System.out.print(de + " ");
		}
		
		
		//示例3.键盘输入多个整数直到quit时候退出。把所有输出的整数倒序排列打印;
		System.out.println("\n示例3:");
		TreeSet<Integer> in = new TreeSet<Integer>(new Comparator<Integer>() {
			//匿名内部类
			@Override
			public int compare(Integer i1, Integer i2) {
				//由于是需要倒序排序则这里集合中元素i2减去调用的参数i1
				int num = i2 - i1;
				return num == 0 ? 1 : num; //不需要剔除重复则返回非0即可
			}
		});
		
		while(!(line = sc.nextLine()).equals("quit")) {
			//将字符串转成Integer对象(捕捉异常)
			try{
				Integer i = Integer.parseInt(line);
				in.add(i);
			} catch (Exception e){
				System.out.println("输入的值非数字!");
			}
		}
		
		System.out.println("集合倒序结果："+in);
		System.out.println("Game Over!");
	}

	public static void sort(ArrayList<String> demo) {
		// 1)创建TreeSet集合对象，还需要自定义比较器(由于String虽然自带比较器但是重复不能够保留)，这里采用匿名内部类实现”
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o1.compareTo(o2);
				return num == 0 ? 1 : num;  //精辟之处
			}
		});
		// 2)将列表元素给TreeSet集合
		ts.addAll(demo);
		// 3)清空list列表中元素
		demo.clear();
		// 4)将排好序的元素重新放入list中
		demo.addAll(ts);
	}
}
