package com.weiyigeek.array;

public class Demo1_ArrayMaopao {
	public static void main(String[] args) {
		//实例1. 冒泡排序(相邻元素比较)
		int[] arr = {45,12,89,75,65,17};
		for (int i = 0; i < arr.length - 1; i++) { //外循环只需要比较arr.length-1
			for(int j = 0; j < arr.length - 1 - i; j++) { // -1为了防止数组越界产生异常, -i 为了提高效率;
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;  //拿取最大值向左边走
				}
			}
		}
		extracted("冒泡算法 :",arr);
		
		//实例2. 选择排序
		int[] arr1 = {45,12,89,75,65,17};
		for (int i = 0; i < arr1.length - 1; i++) {  //循环5次
			for(int j = i + 1; j < arr1.length; j++) //从 i + 1  次开始
			{
				if(arr1[i] > arr1[j])
				{
					int temp = arr1[i];  //将大值存放在temp
					arr1[i] = arr1[j];   //循环遍历过滤出最小的
					arr1[j] = temp;      //将temp给当前[j]
				}
			}
		}
		extracted("\n选择排序:", arr1);
		
		//实例3.二分查找
		int res = binarySearch(arr1,45);
		if(res != -1) {
			System.out.println("\n二分查找:\n已经找到该值 : " + arr1[res]+", Index = "+res);
		}else {
			System.out.println("未找到您要查询的值!");
		}
		
	}

	private static int binarySearch(int[] arr1, int i) {
		int min = 0;
		int max = arr1.length - 1;
		int mid = (max - min) / 2;
		//判断mid索引在数组值是否等于i
		while(arr1[mid] != i) {
			if(arr1[mid] < i) {  //如果当然mid索引值 小于 查找的值 则 最小值 = mid+1;下次就从mid+1处理开始
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
