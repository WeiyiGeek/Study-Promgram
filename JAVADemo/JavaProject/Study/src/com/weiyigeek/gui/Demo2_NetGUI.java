//Socketѧϰ֮GUI��������
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

	//GUI����
	public Demo2_NetGUI() throws Exception
	{
		super("JAVA-Gui����"); //�������
		init();
		southPanel();
		centerPanel();
		event();
	}

	
	//�¼�����
	public void event() {
		//���ڼ���
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ss.close();  //�ر�socketͨ��
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("���˳�����");
				System.exit(0);
			}
		});
		
		//���Ͱ�ť��Ϊ����  (ע��:������������û����������)
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
		
		//��¼��ť
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
		
		//������ť
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				viewText.setText("");
			}
		});
		//�𶯰�ť
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//����֮���� �� ����һ�� �ֽ���������(-1)
					send(new byte[]{-1}, addr.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��������ļ���¼
		cls.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					viewText.setText(""); //��������ɾ�������¼
					new BufferedWriter(new FileWriter("E:\\config.txt")).close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//���̼���(�س�����)
		sendText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Ctrl + Enter ���з�����Ϣ
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
		bw.flush();  //ˢ�»���������������ݴ洢���ļ�֮��
		FileInputStream fis = new FileInputStream("E:\\config.txt"); //���ļ�������
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  //�ڴ洴��������
		int len;
		byte[] arr = new byte[8192];
		while((len = fis.read(arr)) != -1) {
			bos.write(arr,0,len);
		}
		viewText.setText(bos.toString());  //���ڴ��е�����ת�����ַ���
		fis.close(); //����
	}


	public void sendMsg() throws IOException {
		String msg = sendText.getText();  //���͵���Ϣ
		String ip = addr.getText();  //ָ�����͵�IP
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip; //���ip��ַΪ��������е��˽��з�����Ϣ
		String time = getCurrentTime(); //��ȡ��ǰʱ��
		String str = time + " ->" + (ip.equals("255.255.255.255") ? "all":ip) + "\n" + msg + "\n\n"; //ctrl + shift + l ��ȡ�ֲ�����
		sendText.setText(""); //��շ��͵���Ϣ
		viewText.append(str); //�����͵���Ϣ��ӵ���ʾ���ı�������֮��
		send(msg.getBytes(), ip); //������Ϣ
		bw.write(str);  //������д�뵽�ļ�֮��
	}

	public void send(byte[] msg, String ip) throws UnknownHostException, IOException {
		DatagramPacket pt = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), 9999); //����ָ��IP��ַ�Լ��˿�
		ss.send(pt);
	}

	public String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		return sdf.format(new Date()); //���ص�ǰʱ��
	}


	//�м�����
	public void centerPanel() {
		Panel center = new Panel();
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());   //����Ϊ�߽粼�ֹ��������������£�
		center.add(sendText,BorderLayout.SOUTH); //�����ı���������ϱߣ�ע����ӵ�˳�����ʾ��Ӱ�죩
		center.add(viewText,BorderLayout.CENTER);  //��ʾ��������м�
		viewText.setEditable(false);  //��ʾ���ı����ֹ��ʾ
		viewText.setBackground(new Color(255,255,255)); //��ʾ��ɫ => ���� ctrl+shift+t
		sendText.setFont(new Font("xxx",Font.PLAIN,20)); //���÷��������С
		viewText.setFont(new Font("xxx",Font.PLAIN,20)); //������ʾ�������С
		this.add(center,BorderLayout.CENTER);
	}

	public void init() throws Exception {
		this.setLocation(500, 50);
		this.setSize(400,600);
		System.out.println("��������������:9999�˿�");
		new Receive().start();
		System.out.println("������ͨ�ű���:����˿�");
		try {
			ss = new DatagramSocket();
			System.out.println("�Ѽ��ر��ش�ŵ������¼");
			bw = new BufferedWriter(new FileWriter("E:\\config.txt",true)); //β��׷��
			bw.write("12312312");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
	
	public void southPanel() {
		//�ϱߵ����
		Panel south = new Panel();
		addr = new TextField("127.0.0.1",15);  //Ԥ��ֵ�ı����Լ���С
		send = new Button("����");
		log = new Button("��¼");
		clear = new Button("����");
		shake = new Button("��");
		cls = new Button("�����¼");
		south.add(addr);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		south.add(cls);
		this.add(south,BorderLayout.SOUTH);  //��Panel����Frame���ϱ�;
	}
	
	//����һ���ڲ��� - ��������յĶ��߳�
	private class Receive extends Thread {
		@Override
		public void run() {
			try {
				DatagramSocket rs = new DatagramSocket(9999); //�����Ķ˽ӿ�
				DatagramPacket dp = new DatagramPacket(new byte[8192], 8192);
				//ѭ������
				while(true) {
					rs.receive(dp);  //������Ϣ
					byte[] arr = dp.getData();
					int len = dp.getLength();
					//�жϷ��͵��Ƿ�����FLAGB����
					if(arr[0] == -1 && len == 1)
					{
						shake();
						continue;
					}
					String msg=new String(arr,0,len);
					String ipPort= dp.getAddress().getHostAddress() + ":" + dp.getPort();
					String str = getCurrentTime() + " ->"+ ipPort + "\r\n" + msg + "\r\n\r\n";
					viewText.append(str); //�����յ�����Ϣ׷�ӵ���ʾ�ı�����
					bw.write(str); //����д�뵽�����ļ�֮��
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	//�������
	public static void main(String[] args) throws Exception {
		new Demo2_NetGUI();
	}
}
