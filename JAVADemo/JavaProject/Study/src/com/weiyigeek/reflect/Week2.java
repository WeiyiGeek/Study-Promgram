package com.weiyigeek.reflect;
public enum Week2 {
	MON("����һ"){
		public void show() {
			System.out.println("����һ");
		}
	},TUE("���ڶ�"){
		public void show() {
			System.out.println("���ڶ�");
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
}
