import java.util.ArrayList;

import com.weiyi.Collection.Students;

public class Demo3_ArrayLists {

	public static void main(String[] args) {
		//ʾ��������Ƕ��ArrayList�е�ArrayList
		ArrayList<ArrayList<Students>> list = new ArrayList<ArrayList<Students>>(); //����һ���꼶
		ArrayList<Students> first = new ArrayList<Students>(); //��һ���༶
		first.add(new Students("��ΰ",25));
		first.add(new Students("����ΰ",25));
		first.add(new Students("����",25));

		ArrayList<Students> seconde = new ArrayList<Students>(); //�ڶ����༶
		seconde.add(new Students("Love", 99));
		seconde.add(new Students("Test", 199));

		//���༶�ӵ��꼶������
		list.add(first);
		list.add(seconde);
		
		//����ѧ�Ƽ���(ֵ��ѧϰ)
		for (ArrayList<Students> x: list) {
			for (Students y : x) {
				System.out.println(y);
			}
		}
	}

}
