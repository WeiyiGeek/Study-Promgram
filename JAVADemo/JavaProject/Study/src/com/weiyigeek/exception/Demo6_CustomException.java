package com.weiyigeek.exception;

public class Demo6_CustomException {

	public static void main(String[] args) throws AgeOutOfBoundsException {
		//示例1.自定义异常的使用
		try {
			Demo1(1024);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("错误的信息 ： "+e.getMessage());
		}
	}
	
	//抛出自定义异常类
	public static void Demo1(int age) throws AgeOutOfBoundsException {
		if( age > 0 && age <= 150){
			System.out.println("您是一个正常的人类");
		}else {
			throw new AgeOutOfBoundsException("年龄出现异常");  //爆出异常
		}
	}

}

//自定义异常类 (这里可以选择编译时异常也可选择执行时异常)
class AgeOutOfBoundsException extends Exception {
	//继承父类的构造方法,使其可以传递具体的错误参数字符串;
	public AgeOutOfBoundsException() {
		super();
	}

	public AgeOutOfBoundsException(String message) {
		super(message);
	}
}