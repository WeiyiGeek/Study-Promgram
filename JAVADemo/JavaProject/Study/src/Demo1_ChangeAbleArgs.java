public class Demo1_ChangeAbleArgs {
	public static void main(String[] args) {
		//ʵ��1.�ɱ������������
		int[] arr = {11,33,22,77,32};
		print(arr);
		println(arr);
		printlns("�ص�:�ɱ��������", arr);
	}
	
	//�ɱ������������ʵ����������(������int ... arr)���жԱ�
	public static void print(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//�ɱ��������...��ʾ
	public static void println(int ... arr)
	{
		//foreach ��ʽֵ��ѧϰ
		for (int i : arr) {
			System.out.print(i + " - ");
		}
	}
	
	//�������,�ɱ����һ��Ҫ���ں������������
	public static void printlns(String test, int ... arr)
	{
		System.out.println("\n#####�ɱ����һ��Ҫ���ں������������######\n" + test);
		 for (int i : arr) {
			System.out.print(i + " # ");
		}
	}
}
