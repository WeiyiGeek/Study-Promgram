import java.util.Arrays;

public class Demo2_ArrayMethod {

	public static void main(String[] args) {
		//ʾ��1.Arrays���е�toString
		int[] arr1 = {20,19,17,1,5,9,95};
		System.out.println("ʾ��1 : " + Arrays.toString(arr1));
		
		//ʾ��2.Arrays���е�sort����
		Arrays.sort(arr1);
		System.out.println("ʾ��2 : " + Arrays.toString(arr1)); //�ص���������ǲ���Arrays.����
		
		//ʾ��3.Arrays���еĶ��ַ�
		System.out.println("ʾ��3 : Index = " + Arrays.binarySearch(arr1, 19));
		System.out.println("ʾ��3 : Index = " + Arrays.binarySearch(arr1, 2019)); //����2019����arr1����������Ԫ������������Ϊ7�ĵط�;  -(7+1) �� -����� -1  
	}

}