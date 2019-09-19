import java.util.ArrayList;

import com.weiyi.Collection.Students;

public class Demo3_ArrayLists {

	public static void main(String[] args) {
		//示例：集合嵌套ArrayList中的ArrayList
		ArrayList<ArrayList<Students>> list = new ArrayList<ArrayList<Students>>(); //当做一个年级
		ArrayList<Students> first = new ArrayList<Students>(); //第一个班级
		first.add(new Students("张伟",25));
		first.add(new Students("大张伟",25));
		first.add(new Students("纳音",25));

		ArrayList<Students> seconde = new ArrayList<Students>(); //第二个班级
		seconde.add(new Students("Love", 99));
		seconde.add(new Students("Test", 199));

		//将班级加到年级集合中
		list.add(first);
		list.add(seconde);
		
		//遍历学科集合(值得学习)
		for (ArrayList<Students> x: list) {
			for (Students y : x) {
				System.out.println(y);
			}
		}
	}

}
