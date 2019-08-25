package com.weiyigeek.DateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1_DateFormat {

	public static void main(String[] args) throws ParseException {
		//示例1
		//DateFormat df = new DateFormat(); //注意 ： DateFormat是抽象类不允许实例化
		//态工厂方法之一：
		DateFormat df1 = DateFormat.getDateInstance();//默认格式YYYY/MM/dd 相当于父类引用指向子类对象,右边的方法返回一个子类
		System.out.println("示例1 " + df1.format(new Date())); 
		DateFormat df2 = new SimpleDateFormat(); //效果同上
		
		
		//示例2
		Date d = new Date();  //时间对象
		SimpleDateFormat sdf = new SimpleDateFormat(); //创建日期格式化对象
		System.out.println("当前时间默认格式化:  " + sdf.format(d)); //将日期转换字符串
		//自定义输出格式
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
		System.out.println("当前时间自定义格式化:  " + sdf1.format(d));
		
		
		//示例3
		String str = "2019 年 08 月 25 日 22:09:25"; //将时间字符串转换成日期对象
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
		Date d1 = sdf2.parse(str);
		System.out.println("转换结果 : " + d1);
		
		
		//示例4:生日当前时间生活了多少天
		String birthDay = "1995年01月10日";
		String currentDay = "2019年08月25日";
		//定义日期格式化对象
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年mm月dd日");
		//将日期字符串转换成为日期对象
		Date bir = sdf3.parse(birthDay);
		Date cur = sdf3.parse(currentDay);
		//通过日期对象获取时间毫秒值
		long res = cur.getTime() - bir.getTime();
		//之间差毫秒值除以1天的毫秒值 1000 / 3600 / 24
		System.out.println("我已经生活了 " + (res / 1000 / 3600 / 24) + " 天");
	}
}
