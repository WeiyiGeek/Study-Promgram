//Socket学习之GUI进行聊天
package com.weiyigeek.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo2_NetGUI extends Frame {
	private Button send;
	private Button log;
	private Button clear;
	private Button shake;
	private TextField addr;
	private TextArea viewText;
	private TextArea sendText;
	private DatagramSocket ss;
	private BufferedWriter bw;
	private Button cls;

	//GUI聊天
	public Demo2_NetGUI() throws Exception
	{
		super("JAVA-Gui聊天"); //软件标题
		init();
		southPanel();
		centerPanel();
		event();
	}

	
	//事件处理
	public void event() {
		//窗口监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ss.close();  //关闭socket通信
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("已退出程序");
				System.exit(0);
			}
		});
		
		//发送按钮行为监听  (注意:动作监听器是没有适配器的)
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sendMsg();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//记录按钮
		log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					logFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//清屏按钮
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				viewText.setText("");
			}
		});
		//震动按钮
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//精华之所在 震动 发送一个 字节其内容是(-1)
					send(new byte[]{-1}, addr.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//清空聊天文件记录
		cls.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					viewText.setText(""); //清屏并且删除聊天记录
					new BufferedWriter(new FileWriter("E:\\config.txt")).close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//键盘监听(回车发送)
		sendText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Ctrl + Enter 进行发送信息
				if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown())
				{
					try {
						sendMsg();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	protected void shake() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		
		for(int i = 0; i < 20; i++)
		{
			try {
				Thread.sleep(20);
				this.setLocation(x+20, y+20);
				Thread.sleep(20);
				this.setLocation(x+20, y-20);
				Thread.sleep(20);
				this.setLocation(x-20, y+20);
				Thread.sleep(20);
				this.setLocation(x-20, y-20);
				Thread.sleep(20);
				this.setLocation(x, y);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void logFile() throws IOException {
		bw.flush();  //刷新缓冲区将里面的内容存储到文件之中
		FileInputStream fis = new FileInputStream("E:\\config.txt"); //打开文件输入流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  //内存创建缓冲区
		int len;
		byte[] arr = new byte[8192];
		while((len = fis.read(arr)) != -1) {
			bos.write(arr,0,len);
		}
		viewText.setText(bos.toString());  //将内存中的内容转成了字符串
		fis.close(); //关流
	}


	public void sendMsg() throws IOException {
		String msg = sendText.getText();  //发送的消息
		String ip = addr.getText();  //指定发送的IP
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip; //如果ip地址为空则对所有的人进行发送信息
		String time = getCurrentTime(); //获取当前时间
		String str = time + " ->" + (ip.equals("255.255.255.255") ? "all":ip) + "\n" + msg + "\n\n"; //ctrl + shift + l 抽取局部变量
		sendText.setText(""); //清空发送的信息
		viewText.append(str); //将发送的信息添加道显示的文本框区域之中
		send(msg.getBytes(), ip); //发送信息
		bw.write(str);  //将数据写入到文件之中
	}

	public void send(byte[] msg, String ip) throws UnknownHostException, IOException {
		DatagramPacket pt = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), 9999); //连接指定IP地址以及端口
		ss.send(pt);
	}

	public String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(new Date()); //返回当前时间
	}


	//中间的面板
	public void centerPanel() {
		Panel center = new Panel();
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());   //设置为边界布局管理器（从上往下）
		center.add(sendText,BorderLayout.SOUTH); //发送文本区域放在南边（注意添加的顺序对显示有影响）
		center.add(viewText,BorderLayout.CENTER);  //显示区域放在中间
		viewText.setEditable(false);  //显示的文本框禁止显示
		viewText.setBackground(new Color(255,255,255)); //显示白色 => 帮助 ctrl+shift+t
		sendText.setFont(new Font("xxx",Font.PLAIN,20)); //设置发送字体大小
		viewText.setFont(new Font("xxx",Font.PLAIN,20)); //设置显示的字体大小
		this.add(center,BorderLayout.CENTER);
	}

	public void init() throws Exception {
		this.setLocation(500, 50);
		this.setSize(400,600);
		System.out.println("已启动监听本地:9999端口");
		new Receive().start();
		System.out.println("已启动通信本地:随机端口");
		try {
			ss = new DatagramSocket();
			System.out.println("已加载本地存放的聊天记录");
			bw = new BufferedWriter(new FileWriter("E:\\config.txt",true)); //尾部追加
			bw.write("12312312");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
	
	public void southPanel() {
		//南边的面板
		Panel south = new Panel();
		addr = new TextField("127.0.0.1",15);  //预设值文本框以及大小
		send = new Button("发送");
		log = new Button("记录");
		clear = new Button("清屏");
		shake = new Button("震动");
		cls = new Button("清除记录");
		south.add(addr);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		south.add(cls);
		this.add(south,BorderLayout.SOUTH);  //将Panel放在Frame的南边;
	}
	
	//定义一个内部类 - 来定义接收的多线程
	private class Receive extends Thread {
		@Override
		public void run() {
			try {
				DatagramSocket rs = new DatagramSocket(9999); //监听的端接口
				DatagramPacket dp = new DatagramPacket(new byte[8192], 8192);
				//循环接收
				while(true) {
					rs.receive(dp);  //接收信息
					byte[] arr = dp.getData();
					int len = dp.getLength();
					//判断发送的是否是震动FLAGB标送
					if(arr[0] == -1 && len == 1)
					{
						shake();
						continue;
					}
					String msg=new String(arr,0,len);
					String ipPort= dp.getAddress().getHostAddress() + ":" + dp.getPort();
					String str = getCurrentTime() + " ->"+ ipPort + "\r\n" + msg + "\r\n\r\n";
					viewText.append(str); //将接收到的信息追加到显示文本框中
					bw.write(str); //并且写入到本地文件之中
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	//运行入口
	public static void main(String[] args) throws Exception {
		new Demo2_NetGUI();
	}
}
