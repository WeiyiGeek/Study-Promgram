package com.weiyigeek.exception;

public class Demo3_throw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	}
	
	//Throws 后加异常类名以,分割(方法上)
	public void Demo1() throws Exception,RuntimeException {
		//throw用在方法内并且有两种写法
		throw new Exception("方式1:异常对象");

		// Exception e = new Exception("方式2:年龄非法!");
		// throw e
	}
}

