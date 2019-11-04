<<<<<<< HEAD
package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Demo3_TcpSend {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8888);  //创建客户端连接到服务端的Tcp-socket = 港口
		//优化1:需要读的时候是字符串，写的时候也是字符串
		//优化2:服务器端应该是多线程的
		
		//这时候我们将一个字节流转换成为了字符流 
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //获取服务端发送的信息,读取默认是以\r\n为结束符号
		//这里不建议使用BufferedWriter 一行一行写
		PrintStream ps = new PrintStream(socket.getOutputStream()); //PrintStream 中有写入换行的方法并且以\r\n为结束符号;
		//读取服务端的消息并且输出消息
		System.out.println(br.readLine());
		ps.println("2.我是客户端的反馈信息!");
		System.out.println(br.readLine());
		ps.println("4.客户端的通信结束!");
		//关闭客户端的socket
		socket.close();
	}
}
=======
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
>>>>>>> 96cd630503027409f79068bfe4468a7f0b544d2b
