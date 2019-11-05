package com.weiyigeek.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Demo5_MyInvocationHandler implements InvocationHandler {
	//��̬������
	private Object target;
	
	public Demo5_MyInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Ȩ��У��"); //�ؼ���:
		method.invoke(target, args); //ִ�б������target�Ķ��󷽷�
		System.out.println("��־��¼");
		return null;
	}
}
