package com.weiyigeek.net;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Demo3_TcpSend {

	public static void main(String[] args) throws Exception {
		//1.tcp Socket 客户端
		Socket client = new Socket("127.0.0.1",9999); //创建Socket指定ip地址和端口号
		InputStream is = client.getInputStream(); // 获取服务端发送的输入流信息
		OutputStream os = client.getOutputStream(); //客户端向服务端发送信息
		
		//先接送服务端信息
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
		
		//在向服务端发送信息
		os.write("我是客户端发来得消息!".getBytes());
		
		//关闭客户端Socket
		client.close();
	}

}
