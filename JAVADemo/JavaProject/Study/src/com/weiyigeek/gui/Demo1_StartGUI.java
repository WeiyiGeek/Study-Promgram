package com.weiyigeek.gui;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo1_StartGUI {
	public static void main(String[] args) {
		//1.JAVA-GUI������ʾ����
		Frame f = new Frame("�ҵĵ�һ��Title!");
		f.setSize(500, 300); //��ʾ��С
		f.setLocation(500, 500); //��ʾλ��
		f.setIconImage(Toolkit.getDefaultToolkit().createImage("C:\\net.png"));  //���ͼ��
		//2.��ʾ��ť
		Button button = new Button("����");
		Button bt = new Button("�˳�");
		f.add(bt);
		f.add(button);
		f.setLayout(new FlowLayout()); //���ò��ֹ�����
		//3.�¼�Դ�Ǵ���Ѽ�����ע�ᵽ�¼�Դ�ϣ��¼����󴫵ݸ�������(�ô�������������֧��)
		f.addWindowListener(new WindowAdapter() {
				//��Ȼ��Ҳ���Խ���һ����ʵ��WindowsAdapter�ӿ��з���;
				//���߲��������ڲ���;
		        public void windowClosing(WindowEvent e) {
		        System.exit(0);//�˳������,�رմ��� 
		    }
		});
		//4.������ 
		bt.addMouseListener(new MouseAdapter() {
			//��������
			public void mouseClicked(MouseEvent e) {
				System.out.println("����");
				System.exit(0);
			}
			//�ͷż���
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("�ͷ�");
				System.exit(0);
			}
		});


		//5.���̼���
		button.addKeyListener(new KeyAdapter() {
			public void KeyReleased(KeyEvent e) {
				System.out.println("����ǰ�����ֵ:" + e.getKeyCode() + "�ַ�ֵ:" + e.getKeyChar());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		
		f.setVisible(true); //�Ƿ����ʾ
	}
}
