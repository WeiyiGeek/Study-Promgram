import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2_CollectionAsList {
	public static void main(String[] args) {
		//ʵ��1.����ת�ɼ��ϣ���Ȼ���ܿ������ӻ���ɾ��Ԫ��,���ǿ������ü��ϵ�˼��������飩,Ҳ����˵ʹ���������ϵķ���
		String[] arr = {"a","b","c","d"};
		List<String> list = Arrays.asList(arr);
		System.out.println(arr + " " + list);
	}
}
