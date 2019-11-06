package com.weiyigeek.reflect;
public class EnumWeek {
	public static void main(String[] args) {
		//Enum ���÷�����ʾ
		Week2 mon = Week2.MON;
		Week2 tue = Week2.TUE;
		Week2 wed = Week2.WED;
		System.out.println("ö������б�ŵģ�" + mon.ordinal() + ", " + tue.ordinal());
		System.out.println("�Ƚ�ö��������˳��" + mon.compareTo(tue));
		System.out.println("ö����HasCode��" + wed.hashCode());
		System.out.println("ö��������:  " + wed.name());
		System.out.println("ö��������: " + wed.toString());
		
		System.out.print("ͨ���ֽ���������ȡö���� : ");
		Week2 mon1 = Week2.valueOf(Week2.class, "MON");
		System.out.println(mon1);
		
		//����˵��:Value() JDK�ĵ���û�е��Ƿǳ�����
		System.out.println("Value() JDK�ĵ���û�е��Ƿǳ����ã�");
		Week2[] w2 = Week2.values();
		for (Week2 wk : w2) {
			System.out.println(wk); //����toString�Ĺ���
		}
	
	}

}
