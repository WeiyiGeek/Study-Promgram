package com.weiyigeek.Date;
import java.util.Date;
public class Demo_Date {
	public static void main(String[] args) {
		//示例1.
		Date d1 = new Date(); //没有传入参数代表的是当前时间
		System.out.println("当前时间 = " + d1);
		Date d2 = new Date(0); //代表的是1970年1月1日，通过毫秒值创建时间对象
		System.out.println("格林GMT起始时间 = " + d2); //需要注意时区的影响
		
		//示例2.
		Date d3 = new Date();
		System.out.println("通过时间对象获取当前毫秒值 ：" + d3.getTime());
		System.out.println("通过类方法获取当前毫秒值 ：" + System.currentTimeMillis());
		
		//示例3.设置毫秒值改变时间对象 从1970年一月一日开始 (与示例 d2 有一定的关联)
		Date d4 = new Date();
		d4.setTime(1000);
		System.out.println(d4);
	}
}
