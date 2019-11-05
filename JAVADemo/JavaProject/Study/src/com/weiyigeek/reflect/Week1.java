//创建一个枚举类
package com.weiyigeek.reflect;
//枚举类本身就有私有构造得方法
public enum Week1 {
	Mon,Tue,Wed("星期三");
	
	//方式1
	private Week1() {};
	
	//方式2
	private String w;
	private Week1(String w) {
		this.w = w;
	}
	public String getWeek() {
		return w;
	}
}

