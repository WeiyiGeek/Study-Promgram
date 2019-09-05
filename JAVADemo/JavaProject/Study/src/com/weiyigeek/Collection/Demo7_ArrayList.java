package com.weiyigeek.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import com.weiyi.Collection.Students;

public class Demo7_ArrayList {
	public static void main(String[] args) 
	{
	/**
	 * A:������ʾ
	   * ����ArrayListȥ���������ַ������ظ�ֵ(�ַ�����������ͬ)
	   * ˼·�������¼��Ϸ�ʽ
	 */
		ArrayList newList = new ArrayList();
		newList.add("a");
		newList.add("c");
		newList.add("b");
		newList.add("b");
		newList.add("b");

		ArrayList list = getSingle(newList);
		System.out.println(list);
		
		/**
		B:������ʾ
		* ����ArrayListȥ���������Զ������Ԫ�ص��ظ�ֵ(����ĳ�Ա����ֵ��ͬ)
		* **/
		ArrayList objList = new ArrayList();
		objList.add(new Students("����",13)); //�������Object��ʽ�ǶԱȵĵ�ֵַ�ǲ�һ����
		objList.add(new Students("����",13));
		objList.add(new Students("����",13));
		objList.add(new Students("����",13));
		ArrayList objres = getSingleObj(objList); //ѭ���������ж���ȥ��
		objList.remove(new Students("����",13));   //�ײ㶼��������object��equals����
		System.out.println(objres);
	}
	
	/*
	    *  ����: ȥ���ظ�
	 * 1,����ArrayList�������
	 * 2,�����б�ArrayList
	 * �����¼��ϡ����ݴ���ļ��ϻ�ȡ������
	 * �����ϼ��ϡ�ͨ���¼����ж��Ƿ�����ϼ����е�Ԫ��,����������Ͳ����;
	 */
	public static ArrayList getSingle(ArrayList list)  {
		ArrayList newList = new ArrayList();			//����һ���¼���
		Iterator it = list.iterator();					//��ȡ������
		while(it.hasNext()) {							//�ж��ϼ������Ƿ���Ԫ��
			String temp = (String)it.next();			//��ÿһ��Ԫ����ʱ��¼ס
			if(!newList.contains(temp)) {				//����¼����в�������Ԫ��
				newList.add(temp);						//����Ԫ����ӵ��¼�����
			}
		}
		return newList;									//���¼��Ϸ���
	}
	
	//���Դ���Ƚ϶������
	private static ArrayList getSingleObj(ArrayList objList) {
		ArrayList newList = new ArrayList();
		Iterator it = objList.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if(!newList.contains(obj))
			{
				newList.add(obj);
			}
		}
		return newList;
	}
}
