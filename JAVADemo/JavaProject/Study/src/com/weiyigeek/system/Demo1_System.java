package com.weiyigeek.system;

public class Demo1_System {

	public static void main(String[] args) {
		//示例1.垃圾回收机制(需要用到Object中的)
		//protected void finalize()throws Throwable 当垃圾收集确定没有对对象的引用时，由对象上的垃圾收集器调用。
		//子类重写 finalize方法配置系统资源或执行其他清理。 
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
			new GcDemo();
			System.gc(); //运行垃圾回收机制(当数量达到一定限制的时候)
		}
		
		//示例2.当前系统时间(毫秒数) 从 1970年1月1日开始
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\n循环花费的毫秒数 = " + (endTime - startTime));
		
		//示例3.直接copyArray
		int[] arr1 = {18,2017,2019,7,1,9};
		int[] arr2 = new int[5+arr1.length];
		arr2[1] = 1;
		arr2[4] = 4;
		System.arraycopy(arr1, 0, arr2, 5, arr1.length);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		//示例4
		System.exit(0);  //正常的退出java
	}
}


//注意：一个java文件中只有一个public 公共类
class GcDemo {
	public int count = 0;
	@Override
	public void finalize() throws Throwable {
		count++;
		System.out.println(" - 垃圾正在被回收!");
		//super.finalize();
	}
}