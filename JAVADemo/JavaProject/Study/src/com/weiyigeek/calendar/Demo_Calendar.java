package com.weiyigeek.calendar;
import java.util.Calendar;
import java.util.Scanner;
public class Demo_Calendar {

	public static void main(String[] args) {
		// 实例1.Calendar使用
		Calendar c = Calendar.getInstance();
		System.out.println("当前详细时间 ： " + c);
		//获取指定的年月日周
		System.out.println(c.get(Calendar.YEAR));  //字段静态成员年
		System.out.println(c.get(Calendar.MONTH)+1); //字段获取月主要是从年开始 (注意是从0开始的)
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); //月中的的第几天
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //周中第几天 周日是第一天,周六是最后一天
		
		//实例2.获取当前星期几
		System.out.println(getWeek(c.get(Calendar.DAY_OF_WEEK)));
		
		//实例3.个数前进行补0
		System.out.println("当前月中的天数 : " + getDay(c.get(Calendar.DAY_OF_MONTH)));
		
		//实例4.常用方法
		Calendar c1 = Calendar.getInstance(); //父类引用指向子类对象
		c1.add(Calendar.YEAR, -1);          //当前年份-1; 我们可以对字段进行向前减或者向后加  2018
		c1.set(Calendar.DAY_OF_MONTH,29); // 设置当前月中的天数为29号
		System.out.println(c1.get(Calendar.YEAR) + "年" + (c1.get(Calendar.MONTH)+1) +"月" +c1.get(Calendar.DAY_OF_MONTH)+"日");
		
		//实例5.平年闰年判断
		System.out.print("请输入一个年份判断是闰年还是平年: ");
		Scanner sc = new Scanner(System.in);
		String year = sc.nextLine();
		int y = Integer.parseInt(year);  //将数字字符串转换成为数字
		Calendar c2 = Calendar.getInstance();
		c2.set(y, 2, 1); //设置年3月1日
		c2.add(Calendar.DAY_OF_MONTH, -1);
		String flag = (c2.get(Calendar.DAY_OF_MONTH) == 29) ? "润年":"平年";
		System.out.println(year+"年是"+flag);
	}

	private static String getWeek(int i) {
		String[] week = {"","星期天","星期一","星期二","星期三","星期四","星期五","星期六"}; //注意这里week[0] 为空
		return week[i];
	}
	
	private static String getDay(int i) {
		return i > 9 ? "" + i:"0" + i;   //非两位数补0
	}
}
