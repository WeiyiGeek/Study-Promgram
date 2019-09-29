package com.weiyigeek.exception;
public class Demo1_tryCatch {
	public static void main(String[] args) {
		Demo d = new Demo();
		int[] arr = {1,2,3,45,6};
		
		// ʾ��1.�����쳣������		
		try {
			int x = d.div(10, 0);  //���ܽ���ArithmeticException�쳣���մ�ӡ������
			System.out.println(x);			
		} catch(ArithmeticException e) { // ArithmeticException(�����쳣)������ʱ�쳣������,
			System.out.println("1.��������Ϊzero");
		}
		System.out.println("2.�����쳣������ҿ��Լ���ִ��");
		
		// ʾ��2.ָ������쳣������
		try {
			int x = d.div(10, 0);
			System.out.println(x);
			System.out.println(arr[1024]);
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) { //�����쳣�����������������쳣
			System.out.println("3.�����쳣�����������������쳣");
		}
		//Ҳ�ɲ��ö��Catchָ������ ��ͬ�쳣�����;
		
		// ʾ��3.����ȫ���쳣(ע��Exception��ȡȫ���쳣��,�����޷������쳣)
		try {
			int x = d.div(10, 0);
			System.out.println(x);
			System.out.println(arr[1024]);
		}catch(Exception e) { //�����쳣�����������������쳣
			System.out.println("4.Exception�����쳣����" + e);
		}
		
	}

}

class Demo {
	/* �������� */
	public int div(int a,int b) {		//a = 10,b = 0
		return a / b;	//10 / 0 ��������10,������0��������0��ʱ��Υ�����������㷨��,�׳��쳣
	} //new ArithmeticException("/ by zero");
} 
