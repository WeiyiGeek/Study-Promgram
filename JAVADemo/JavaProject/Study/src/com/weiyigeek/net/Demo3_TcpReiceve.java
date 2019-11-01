package com.weiyigeek.net;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Demo3_TcpReiceve {
	public static void main(String[] args) throws Exception {
		//2.Server服务端TCP socket 案例
		ServerSocket ss = new ServerSocket(9999); //服务端监听端口
		Socket socket = ss.accept(); //接受客服端得请求
		InputStream is = socket.getInputStream();  //获取客户端得输入流
		OutputStream os = socket.getOutputStream(); //客户端得输出流
		
		//向客户端发送信息
		os.write("这是从服务端发送得信息".getBytes());
		
		//打印出接收客户端发送得信息
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
		socket.close();
	}
}
