//����һ��ö����
package com.weiyigeek.reflect;
//ö���౾�����˽�й���÷���
public enum Week1 {
	Mon,Tue,Wed("������");
	
	//��ʽ1
	private Week1() {};
	
	//��ʽ2
	private String w;
	private Week1(String w) {
		this.w = w;
	}
	public String getWeek() {
		return w;
	}
}

