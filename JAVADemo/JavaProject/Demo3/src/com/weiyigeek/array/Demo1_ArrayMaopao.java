package com.weiyigeek.array;

public class Demo1_ArrayMaopao {
	public static void main(String[] args) {
		//ʵ��1. ð������(����Ԫ�رȽ�)
		int[] arr = {45,12,89,75,65,17};
		for (int i = 0; i < arr.length - 1; i++) { //��ѭ��ֻ��Ҫ�Ƚ�arr.length-1
			for(int j = 0; j < arr.length - 1 - i; j++) { // -1Ϊ�˷�ֹ����Խ������쳣, -i Ϊ�����Ч��;
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;  //��ȡ���ֵ�������
				}
			}
		}
		extracted("ð���㷨 :",arr);
		
		//ʵ��2. ѡ������
		int[] arr1 = {45,12,89,75,65,17};
		for (int i = 0; i < arr1.length - 1; i++) {  //ѭ��5��
			for(int j = i + 1; j < arr1.length; j++) //�� i + 1  �ο�ʼ
			{
				if(arr1[i] > arr1[j])
				{
					int temp = arr1[i];  //����ֵ�����temp
					arr1[i] = arr1[j];   //ѭ���������˳���С��
					arr1[j] = temp;      //��temp����ǰ[j]
				}
			}
		}
		extracted("\nѡ������:", arr1);
		
		//ʵ��3.���ֲ���
		int res = binarySearch(arr1,45);
		if(res != -1) {
			System.out.println("\n���ֲ���:\n�Ѿ��ҵ���ֵ : " + arr1[res]+", Index = "+res);
		}else {
			System.out.println("δ�ҵ���Ҫ��ѯ��ֵ!");
		}
		
	}

	private static int binarySearch(int[] arr1, int i) {
		int min = 0;
		int max = arr1.length - 1;
		int mid = (max - min) / 2;
		//�ж�mid����������ֵ�Ƿ����i
		while(arr1[mid] != i) {
			if(arr1[mid] < i) {  //�����Ȼmid����ֵ С�� ���ҵ�ֵ �� ��Сֵ = mid+1;�´ξʹ�mid+1����ʼ
				min = mid + 1;
			}else if(arr1[mid] > i) {
				max = mid - 1; 
			}
			if( min > max ) {
				return -1;
			}
			mid = (max - min) /2;
		}	
		return mid;
	}

	public static void extracted(String name,int[] arr) {
		System.out.println(name);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
