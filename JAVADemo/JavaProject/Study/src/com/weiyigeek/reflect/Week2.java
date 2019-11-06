package com.weiyigeek.reflect;
public enum Week2 {
	MON("星期一"){
		public void show() {
			System.out.println("星期一");
		}
	},TUE("星期二"){
		public void show() {
			System.out.println("星期二");
		}
	},WED("星期三"){
		public void show() {
			System.out.println("星期三");
		}
	};
	
	private String w;
	private Week2(String w) {
		this.w = w;
	};
	private String getWeek() {
		return w;
	}
	public abstract void show();
	//重写ToString方法
	public String toString() {
		return w;
	}
}
