import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2_CollectionAsList {
	public static void main(String[] args) {
		//实例1.数组转成集合（虽然不能可以增加或者删除元素,但是可以利用集合的思想操作数组）,也就是说使用其他集合的方法
		String[] arr = {"a","b","c","d"};
		List<String> list = Arrays.asList(arr);
		System.out.println(arr + " " + list);
	}
}
