
public class Demo4_Char {
	public static void main(String[] args) {
		//�����ַ�GBK���
		System.out.println('��' + 0); //gbk���һһ��Ӧ
		System.out.println('��' + 0);
		//JAVA������ʽ
		byte[] arr = "����".getBytes();
		for (Byte b : arr) {
			System.out.print( b + " ");
		}
		//�� : -42 -48 
		//�� : -50 -60
	}
}
