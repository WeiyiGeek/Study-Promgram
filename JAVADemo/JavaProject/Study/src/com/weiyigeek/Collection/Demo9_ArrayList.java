package com.weiyigeek.Collection;

import java.util.ArrayList;

public class Demo9_ArrayList {

	public static void main(String[] args) {
		// 1.约瑟夫环
		System.out.println("幸运人的编号 : " + getLuckly(8));
	}
	
	/**
	 * getLuckly : 实现约瑟夫环算法
	 * @param i : 人数
	 * @return Integer
	 */
	private static Integer getLuckly(int i) {
		ArrayList<Integer> list = new ArrayList<Integer>(); //创建存储1到num的对象
		for(int num = 1; num <= i; num ++){ //注意位置号从1开始到i结束
			list.add(num); //将每一个人进行标位置号
		}
		
		int count = 1; // 计算器如果是3的倍数的人将被剔除
		for(int num = 0; list.size() != 1; num++)
		{
			if(num == list.size()){
				num = 0;  //如果当索引值等于列表总的个数的时候,重置为0进行下一轮比较剔除
			}
			
			if(count % 3 == 0) {
				list.remove(num--); //非常注意这里因为ArrayList删除列表元素后，后面的元素会向前补齐(索引这里需要要索引移动回到删除的位置)
			}
			count++;
		}
		return list.get(0); //最后只剩下1人打印其的位置号
	}
}
