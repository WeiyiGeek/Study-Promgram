package com.weiyigeek.reflect;
public class EnumWeek {
	public static void main(String[] args) {
		//Enum 常用方法演示
		Week2 mon = Week2.MON;
		Week2 tue = Week2.TUE;
		Week2 wed = Week2.WED;
		System.out.println("枚举项都是有编号的：" + mon.ordinal() + ", " + tue.ordinal());
		System.out.println("比较枚举项的序号顺序：" + mon.compareTo(tue));
		System.out.println("枚举项HasCode：" + wed.hashCode());
		System.out.println("枚举项名称:  " + wed.name());
		System.out.println("枚举项内容: " + wed.toString());
		
		System.out.print("通过字节码码对象获取枚举项 : ");
		Week2 mon1 = Week2.valueOf(Week2.class, "MON");
		System.out.println(mon1);
		
		//补充说明:Value() JDK文档中没有但是非常好用
		System.out.println("Value() JDK文档中没有但是非常好用：");
		Week2[] w2 = Week2.values();
		for (Week2 wk : w2) {
			System.out.println(wk); //这是toString的功劳
		}
	
	}

}
