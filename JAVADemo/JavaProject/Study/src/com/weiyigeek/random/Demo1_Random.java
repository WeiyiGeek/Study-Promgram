package com.weiyigeek.random;
import java.util.Random;
public class Demo1_Random {
	public static void main(String[] args) {
		//示例1.Random类的使用
		//方式1:伪随机数底层种子默认采用系统当前时间的纳秒
		Random ra = new Random();
		System.out.println("伪随机 = " + ra.nextInt());
		System.out.println("伪随机 = " + ra.nextInt());

		//方式2
		System.out.println("相同的seed种子数,生成的随机数是一致的:");
		Random r = new Random(1024); //调用new Random(seed)与r.setSeed(seed)是等价的：
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		
		//方式3
		Random r1 = new Random();
		r1.setSeed(1024);
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt());
		
		//示例2.生成一个范围内的随机数
		Random r2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.print(r.nextInt(100) + " "); //生成十次 0 ~ 99 的随机数(注意这里不是100)
		}	
	}
}
