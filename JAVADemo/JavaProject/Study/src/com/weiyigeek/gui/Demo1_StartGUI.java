package com.weiyigeek.gui;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

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
		f.setLayout(new FlowLayout()); //���������ֹ�����
		//3.�¼�Դ�Ǵ���Ѽ�����ע�ᵽ�¼�Դ�ϣ��¼����󴫵ݸ�������(�ô�������������֧��)
		f.addWindowListener(new WindowAdapter() {
				//��Ȼ��Ҳ���Խ���һ����ʵ��WindowsAdapter�ӿ��з���;
				//���߲��������ڲ���;
		        public void windowClosing(WindowEvent e) {
		        System.exit(0);//�˳������,�رմ��� 
		    } 
		});
		f.addWindowListener(new newWindowListener());
		
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
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("����ǰ�����ֵ:" + e.getKeyCode() + "�ַ�ֵ:" + e.getKeyChar());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			} 
		});
		
		//6.��������
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true); //�Ƿ����ʾ
	}
}

//ʵ����д�ӿ��з���
class newWindowListener implements WindowListener {
  
	//�����ʱ����ʾ
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println(e.paramString());
		System.out.println(e.getClass());
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}
   
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	
	//���Ĭ�ϴ��Լ���С��ԭ��ʱ����ʾִ��
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Windows Show");
	}
	
	//�����Сʱ�򴥷�
	@Override
	public void windowDeactivated(WindowEvent e) {
	    JOptionPane.showMessageDialog(null, "������ʾ");  
	}
}


