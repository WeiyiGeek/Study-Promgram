package com.weiyigeek.reflect;

//枚举Enumerate 类
public class Demo7_Week {
	//方法1：无参
	public static final Demo7_Week Mon = new Demo7_Week();
	public static final Demo7_Week Tue = new Demo7_Week();
	public static final Demo7_Week Wen = new Demo7_Week();
	private Demo7_Week() {};  //私有构造不让其他类创建本类对象
	
	
	//方法2：有参
	public static final Demo7_Week Thu = new Demo7_Week("星期四");
	public static final Demo7_Week Fri= new Demo7_Week("星期五");
	public static final Demo7_Week Sat= new Demo7_Week("星期六");
	private String week;
	private Demo7_Week(String w) {
		this.week = w;  //私有构造不让其他类创建本类对象
	}
	public String getWeek() {
		return week;
	}
}
