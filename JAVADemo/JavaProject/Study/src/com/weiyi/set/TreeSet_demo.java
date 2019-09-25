package com.weiyi.set;
import java.util.Comparator;
import java.util.TreeSet;
import com.weiyi.Collection.Students;
public class TreeSet_demo {
	public static void main(String[] args) {
		//示例1.TreeSet集合基本使用
		TreeSet<Integer> ts = new TreeSet<>(); //创建TreeSet对象去重和排序
		ts.add(3);ts.add(1);ts.add(1);ts.add(2);ts.add(2);
		System.out.println("示例1：\n" + ts);  //输出元素
		
		//实例2.TreeSet集合保证元素唯一和自然排序（采用了二叉树的原理）
		TreeSet<Students> st = new TreeSet<>();
		st.add(new Students("掌门人",25));
		st.add(new Students("凡哥",23));
		st.add(new Students("渣渣辉",25));
		st.add(new Students("刘师傅",24));
		System.out.println("示例2：\n" + st);
		
		//示例3.compareTo中的姓名的对比采用的是unicode码
		System.out.println("示例3：\n");
		System.out.println('掌' + 0);
		System.out.println('凡' + 0);
		System.out.println('渣' + 0);
		System.out.println('刘' + 0);
		
		
		//示例4.TreeSet集合比较器原理
		System.out.println("示例4：\n" + st);
		TreeSet<String> compare = new TreeSet<>(new CompareByLength());
		compare.add("aaaaa");
		compare.add("z");
		compare.add("xa");
		compare.add("weiyigeek");
		compare.add("cba");
		System.out.println("示例4：\n" + compare);
	}
}

class CompareByLength extends Object implements Comparator<String>{
	//注意这里:Comparator接口虽然是两个方法但是这里只写了一个也不会报错;由于所有的类都默认基础Object类而该类中已经重写了equals方法
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int num = s1.length() - s2.length();   //判断长度
		return num == 0 ? s1.compareTo(s2) : num;  //长度一致则判断条件
	}
}
