//动态代理的测试
package com.weiyigeek.reflect;

import java.lang.reflect.Proxy;

public class Demo5_Test {
	public static void main(String[] args) {
		Demo5_UserImp ui = new Demo5_UserImp();
		
		//我创建的动态代理类
		Demo5_MyInvocationHandler dm = new Demo5_MyInvocationHandler(ui); //传入对象
		
		//首先拿到字节码文件 -> 类加载器 ，再拿到该对象的接口
		Demo5_User du = (Demo5_User)Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(), dm);
		du.login(); //运行类中方法，并加入了动态代理中添加的方法;
		du.run();
	
	}
}
