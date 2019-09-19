public class Demo1_ChangeAbleArgs {
	public static void main(String[] args) {
		//实例1.可变参数函数讲解
		int[] arr = {11,33,22,77,32};
		print(arr);
		println(arr);
		printlns("重点:可变参数特征", arr);
	}
	
	//可变参数函数接收实际上是数组(与下面int ... arr)进行对比
	public static void print(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//可变参数采用...表示
	public static void println(int ... arr)
	{
		//foreach 方式值得学习
		for (int i : arr) {
			System.out.print(i + " - ");
		}
	}
	
	//多个参数,可变参数一定要放在函数参数的最后
	public static void printlns(String test, int ... arr)
	{
		System.out.println("\n#####可变参数一定要放在函数参数的最后######\n" + test);
		 for (int i : arr) {
			System.out.print(i + " # ");
		}
	}
}
