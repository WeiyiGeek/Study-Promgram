//��̬����Ĳ���
package com.weiyigeek.reflect;

import java.lang.reflect.Proxy;

public class Demo5_Test {
	public static void main(String[] args) {
		Demo5_UserImp ui = new Demo5_UserImp();
		
		//�Ҵ����Ķ�̬������
		Demo5_MyInvocationHandler dm = new Demo5_MyInvocationHandler(ui); //�������
		
		//�����õ��ֽ����ļ� -> ������� �����õ��ö���Ľӿ�
		Demo5_User du = (Demo5_User)Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(), dm);
		du.login(); //�������з������������˶�̬��������ӵķ���;
		du.run();
	
	}
}
