import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2_CollectionAsList {
	public static void main(String[] args) {
		//Arrays工具类的asList()方法的使用
		//实例1.数组转成集合（虽然不能可以增加或者删除元素,但是可以利用集合的思想操作数组）,
		//也就是说使用其他集合的方法
		String[] arr = {"a","b","c","d"};
		List<String> list = Arrays.asList(arr);
		System.out.println(arr + " " + list);
		//list.add("不能添加")
		
		
		//示例2.整形数组转换成为集合
		int[] arr1 = {11,222,333}; //基本数据类型
		List<int[]> list1 = Arrays.asList(arr1); //基本数据类型的数组转换成为集合.会将整改数组当做一个对象
		System.out.println(list1);   //返回的是一个地址
		//重点
		Integer[] arr2 = {11,22,344};   //引用数据类型(数组转集合)
		List<Integer> list2 = Arrays.asList(arr2);
		System.out.println(arr2 + " " + list2);
		
		
		//示例3.泛型集合转数组
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("demo");
		list3.add("YES");
		list3.add("this");
		
		String[] arr3 = list3.toArray(new String[0]); //当集合转化成数组时候,数组的长度小于等于集合的size,转换后的数组长度等于集合
		//如果数组长度大于了size,匹配的数组就和您设置长度一致,不存在的以null补齐
		for (String param : arr3) {
			System.out.print(param + " ");
		}
	}
}
