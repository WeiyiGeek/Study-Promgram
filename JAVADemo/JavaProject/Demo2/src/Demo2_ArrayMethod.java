import java.util.Arrays;

public class Demo2_ArrayMethod {

	public static void main(String[] args) {
		//示例1.Arrays类中的toString
		int[] arr1 = {20,19,17,1,5,9,95};
		System.out.println("示例1 : " + Arrays.toString(arr1));
		
		//示例2.Arrays类中的sort排序
		Arrays.sort(arr1);
		System.out.println("示例2 : " + Arrays.toString(arr1)); //重点这里输出是采用Arrays.方法
		
		//示例3.Arrays类中的二分法
		System.out.println("示例3 : Index = " + Arrays.binarySearch(arr1, 19));
		System.out.println("示例3 : Index = " + Arrays.binarySearch(arr1, 2019)); //由于2019大于arr1数组中所有元素则排在索引为7的地方;  -(7+1) 及 -插入点 -1  
	}

}