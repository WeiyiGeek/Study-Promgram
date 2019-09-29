package com.weiyigeek.exception;
public class Demo1_tryCatch {
	public static void main(String[] args) {
		Demo d = new Demo();
		int[] arr = {1,2,3,45,6};
		
		// 示例1.常规异常捕获处理		
		try {
			int x = d.div(10, 0);  //不能接收ArithmeticException异常最终打印处改行
			System.out.println(x);			
		} catch(ArithmeticException e) { // ArithmeticException(算数异常)是运行时异常的子类,
			System.out.println("1.除数不能为zero");
		}
		System.out.println("2.有了异常处理后我可以继续执行");
		
		// 示例2.指定多个异常捕获处理
		try {
			int x = d.div(10, 0);
			System.out.println(x);
			System.out.println(arr[1024]);
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) { //算数异常或者数组索引出界异常
			System.out.println("3.算数异常或者数组索引出界异常");
		}
		//也可采用多个Catch指定单个 不同异常的输出;
		
		// 示例3.捕获全部异常(注意Exception获取全部异常后,后面无法根子异常)
		try {
			int x = d.div(10, 0);
			System.out.println(x);
			System.out.println(arr[1024]);
		}catch(Exception e) { //算数异常或者数组索引出界异常
			System.out.println("4.Exception所有异常捕获" + e);
		}
		
	}

}

class Demo {
	/* 除法运算 */
	public int div(int a,int b) {		//a = 10,b = 0
		return a / b;	//10 / 0 被除数是10,除数是0当除数是0的时候违背了算数运算法则,抛出异常
	} //new ArithmeticException("/ by zero");
} 
