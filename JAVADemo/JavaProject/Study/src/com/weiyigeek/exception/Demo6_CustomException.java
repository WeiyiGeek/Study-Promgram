package com.weiyigeek.exception;

public class Demo6_CustomException {

	public static void main(String[] args) throws AgeOutOfBoundsException {
		//ʾ��1.�Զ����쳣��ʹ��
		try {
			Demo1(1024);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("�������Ϣ �� "+e.getMessage());
		}
	}
	
	//�׳��Զ����쳣��
	public static void Demo1(int age) throws AgeOutOfBoundsException {
		if( age > 0 && age <= 150){
			System.out.println("����һ������������");
		}else {
			throw new AgeOutOfBoundsException("��������쳣");  //�����쳣
		}
	}

}

//�Զ����쳣�� (�������ѡ�����ʱ�쳣Ҳ��ѡ��ִ��ʱ�쳣)
class AgeOutOfBoundsException extends Exception {
	//�̳и���Ĺ��췽��,ʹ����Դ��ݾ���Ĵ�������ַ���;
	public AgeOutOfBoundsException() {
		super();
	}

	public AgeOutOfBoundsException(String message) {
		super(message);
	}
}