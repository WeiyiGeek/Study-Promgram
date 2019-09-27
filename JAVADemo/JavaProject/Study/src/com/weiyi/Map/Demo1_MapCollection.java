package com.weiyi.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo1_MapCollection {

	public static void main(String[] args) {
		//ʾ��1.Map���ϵ���ӹ���(ע��HashĬ���ǲ������ݽ��������)
		Map<String, Integer> stu = new HashMap<String, Integer>();
		stu.put("С��",25);  //ע������Key�����ظ�put��һ�η���null,�ڶ������Ƿ��ر����ǵ�ֵ
		stu.put("Сΰ",88);
		stu.put("С��",18);
		stu.put("С��",14);
		System.out.println("ʾ��1: " + stu);
		
		//ʾ��2.�ж�ֵ�Ƿ�������Ƿ����
		boolean keyFlag = stu.containsKey("Сΰ");
		boolean ValueFlag = stu.containsValue(88);
		System.out.println("ʾ��2: " + "Сΰ Key�Ƿ����" + keyFlag +",88 Value�Ƿ����" + ValueFlag + ", �Ƿ�Ϊ�� ��" + stu.isEmpty());

		//ʾ��3.��ȡMap���ϳ��Ⱥͼ����еļ�ֵ
		System.out.println("ʾ��3:\nMap���ϳ���: " + stu.size());
		System.out.println("��ȡָ��Key��Value: " + stu.get("Сΰ"));
		System.out.println("��ȡMap��������Key: " + stu.keySet());
		System.out.println("��ȡMap��������Value: " + stu.values());
		
		//ʾ��5.Map˫�м��ϵ�������(���ַ���);Map���ϵı���֮����ֵ
		//Iterator������
		System.out.println("\nʾ��5:");
		Set<String> keySet = stu.keySet();  //������һ��Set�������͵�ֵ����Set�����д��ڵ����������ʹ��
		Iterator<String> ot = keySet.iterator(); // ��ȡ������
		while(ot.hasNext())
		{
			String key = ot.next(); //��ȡÿһ����
			Integer value = stu.get(key); //���ݼ���ȡֵ
			System.out.println("Key=" + key + ", Value=" + value);
		}
		
		//��ǿforѭ��������ʽ(ʵ��ʹ�����Ƽ�)
		for (String Key : stu.keySet()) {
			System.out.println(Key+":"+stu.get(Key));
		}

		//ʾ��6.����֮`��ֵ�Զ����Ҽ���ֵ`˼·
		System.out.println("\nʾ��6:");
		//Map.Entry˵��Entry��Map���ڲ��ӿ�,������ֵ��װ��ΪEntry���󲢴�����Set������
		Set<Map.Entry<String, Integer>> entryset = stu.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entryset.iterator();  //��ȡ����������
		while(it.hasNext())
		{
			//��ȡÿһ��Entry����
			Map.Entry<String, Integer> st = it.next();
			//֮��Ϳ��Ը�������ӿ�����ķ�����ȡֵ/keys
			String stkey = st.getKey();
			Integer stvalue = st.getValue();
			System.out.println( stkey + " - " + stvalue);
		}
		
		//���ǿ��Բ�����ǿforѭ��(ʵ�ʿ������Ƽ���ʽ)
		for (Map.Entry<String, Integer> entry : stu.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() + " " + entry.getClass());
		}
		
		//ʾ��4.ɾ��Map�����е�Keyֵ
		System.out.println("\nʾ��4:\n�Ƴ�ɾ����ֵ��Ԫ��: " + stu.remove("Сΰ"));
		stu.clear();
		System.out.println("ɾ��ȫ��Key/Value: " + stu);
	}

}




