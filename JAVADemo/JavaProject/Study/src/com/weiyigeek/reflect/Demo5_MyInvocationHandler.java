package com.weiyigeek.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Demo5_MyInvocationHandler implements InvocationHandler {
	//动态代理类
	private Object target;
	
	public Demo5_MyInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验"); //关键点:
		method.invoke(target, args); //执行被代理的target的对象方法
		System.out.println("日志记录");
		return null;
	}
}
