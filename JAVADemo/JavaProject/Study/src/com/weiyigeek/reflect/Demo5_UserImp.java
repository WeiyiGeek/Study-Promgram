package com.weiyigeek.reflect;

//实现接口
public class Demo5_UserImp implements Demo5_User {
	@Override
	public void login() {
		System.out.println("- 1.登录操作");
	}

	@Override
	public void run() {
		System.out.println("- 2.运行操作");
	}
}
