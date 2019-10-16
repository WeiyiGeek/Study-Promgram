
public class Demo4_Char {
	public static void main(String[] args) {
		//中文字符GBK码表
		System.out.println('中' + 0); //gbk码表一一对应
		System.out.println('文' + 0);
		//JAVA表现形式
		byte[] arr = "中文".getBytes();
		for (Byte b : arr) {
			System.out.print( b + " ");
		}
		//中 : -42 -48 
		//文 : -50 -60
	}
}
