package com.geek.hellowrold;

import java.io.*;

public class demo7 {
	String name;
	int age;
	String desc;
	float workmoney;
	
	public demo7(String xm, int nl) {
		this.name = xm;
		this.age = nl;
	}
	
	public void setDesc(String content) {
		desc = content;
	}
	
	public void setMoney(float gz) {
		this.workmoney = gz;
	}
	
	public void resultPrin() {
		System.out.println("姓名 ："+this.name);
		System.out.println("年龄 ："+this.age);
		System.out.println("描述 ："+this.desc);
		System.out.println("薪水 ："+this.workmoney);
	}
}
