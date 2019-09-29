package com.weiyigeek.exception;
public class Demo1_Throwable {
	public static void main(String[] args) {
		//(1) Throwable 常见方法
		try {
			System.out.println(1/0);
		} catch(Exception e) {  //Exception e = new ArithmeticException("/ by zero")
			System.out.println("1." + e.getMessage());  //获取异常信息
			System.out.println(e);  //调用toString方法打印异常类名和异常信息
			e.printStackTrace();    //jvm默认就用的这种方式处理异常
		}
	}
}

/**
 *  //执行结果
 *  1./ by zero
	2.java.lang.ArithmeticException: / by zero
	3.java.lang.ArithmeticException: / by zero
		at com.weiyigeek.exception.Demo1_Throwable.main(Demo1_Throwable.java:8)
 *
 */