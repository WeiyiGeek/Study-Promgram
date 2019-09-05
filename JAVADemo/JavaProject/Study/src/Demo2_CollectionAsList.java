import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2_CollectionAsList {
	public static void main(String[] args) {
		//Arrays�������asList()������ʹ��
		//ʵ��1.����ת�ɼ��ϣ���Ȼ���ܿ������ӻ���ɾ��Ԫ��,���ǿ������ü��ϵ�˼��������飩,
		//Ҳ����˵ʹ���������ϵķ���
		String[] arr = {"a","b","c","d"};
		List<String> list = Arrays.asList(arr);
		System.out.println(arr + " " + list);
		//list.add("��������")
		
		
		//ʾ��2.��������ת����Ϊ����
		int[] arr1 = {11,222,333}; //������������
		List<int[]> list1 = Arrays.asList(arr1); //�����������͵�����ת����Ϊ����.�Ὣ�������鵱��һ������
		System.out.println(list1);   //���ص���һ����ַ
		//�ص�
		Integer[] arr2 = {11,22,344};   //������������(����ת����)
		List<Integer> list2 = Arrays.asList(arr2);
		System.out.println(arr2 + " " + list2);
		
		
		//ʾ��3.���ͼ���ת����
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("demo");
		list3.add("YES");
		list3.add("this");
		
		String[] arr3 = list3.toArray(new String[0]); //������ת��������ʱ��,����ĳ���С�ڵ��ڼ��ϵ�size,ת��������鳤�ȵ��ڼ���
		//������鳤�ȴ�����size,ƥ�������ͺ������ó���һ��,�����ڵ���null����
		for (String param : arr3) {
			System.out.print(param + " ");
		}
	}
}
