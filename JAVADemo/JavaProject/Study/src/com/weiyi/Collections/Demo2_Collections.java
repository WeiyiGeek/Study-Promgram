package com.weiyi.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Demo2_Collections {

	public static void main(String[] args) {
		//需求:模拟地主洗牌和发牌，【牌没有排序】
		//1.创建扑克牌
		String[] pk = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] color = {"红桃","黑桃","方片","梅花"};
		//拼接花色采用列表存放即可
		ArrayList<String> poker = new ArrayList<>();
		for (String p : pk) {
			for (String c : color) {
				poker.add(c.concat(p));
			}
		}
		poker.add("大王");
		poker.add("小王");
		System.out.println("牌数："+ poker.size() + "\n" + poker + "\n");
		
		//2.洗牌
		Collections.shuffle(poker);
		
		//3.发牌和底牌
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> C = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		
		for(int i = 0; i < poker.size(); i++)
		{
			if( i >= poker.size() - 3){
				dipai.add(poker.get(i)); //存放三张底牌
			}else if(i % 3 == 0) {   //精辟的地方来了，利用取余来发牌
				A.add(poker.get(i));
			}else if(i % 3 == 1) {
				B.add(poker.get(i));
			}else if(i % 3 == 2) {
				C.add(poker.get(i));
			}
		}
		
		//4.看牌(无排序)
		System.out.println("A:" + A);
		System.out.println("B:" + B);
		System.out.println("C:" + C);
		System.out.println("dipai:" + dipai);

	
		//#################牌实现排序#################
		//1.创建扑克牌
		String[] p1 = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] c1 = {"红桃","黑桃","方片","梅花"};
		//采用键值对来存储我们的牌(后面就方便我们排序了)
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		ArrayList<Integer> index = new ArrayList<Integer>();  //存储索引
		int i = 0;
		for(String sp1 : p1)
		{
			for (String sc1 : c1) {
				index.add(i);
				hm.put(i++,sc1.concat(sp1));
			}
		}
		
		index.add(i);
		hm.put(i++,"小王");
		index.add(i);
		hm.put(i,"大王");
		
		//洗牌
		Collections.shuffle(index);
		
		//发牌
		TreeSet<Integer> a = new TreeSet<Integer>();
		TreeSet<Integer> b = new TreeSet<Integer>();
		TreeSet<Integer> c = new TreeSet<Integer>();
		TreeSet<Integer> dp = new TreeSet<Integer>();
		for(i = 0; i < hm.size(); i++)
		{
			if( i >= hm.size() - 3){
				dp.add(index.get(i)); //存放三张底牌
			}else if(i % 3 == 0) {   //精辟的地方来了，利用取余来发牌
				a.add(index.get(i));
			}else if(i % 3 == 1) {
				b.add(index.get(i));
			}else if(i % 3 == 2) {
				c.add(index.get(i));
			}
		}
		
		//看牌(重复采用函数的形式值得学习)
		lookup(hm, dp, "底牌");
		lookup(hm, a, "A");
		lookup(hm, b, "B");
		lookup(hm, c, "C");
	}

	public static void lookup(HashMap<Integer, String> hm, TreeSet<Integer> dp,String name) {
		ArrayList<String> flag = new ArrayList<String>();
		for (Integer idp : dp) {
			flag.add(hm.get(idp));
		}
		System.out.println("角色"+name+"的牌是:\n"+flag);
	}
}
