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
		//1.JAVA-GUI界面显示设置
		Frame f = new Frame("我的第一个Title!");
		f.setSize(500, 300); //显示大小
		f.setLocation(500, 500); //显示位置
		f.setIconImage(Toolkit.getDefaultToolkit().createImage("C:\\net.png"));  //软件图标
		//2.显示按钮
		Button button = new Button("测试");
		Button bt = new Button("退出");
		f.add(bt);
		f.add(button);
		f.setLayout(new FlowLayout()); //设置流布局管理器
		//3.事件源是窗体把监听器注册到事件源上，事件对象传递给监听器(让窗口适配器可以支持)
		f.addWindowListener(new WindowAdapter() {
				//当然您也可以建立一个类实现WindowsAdapter接口中方法;
				//或者采用匿名内部类;
		        public void windowClosing(WindowEvent e) {
		        System.exit(0);//退出虚拟机,关闭窗口 
		    } 
		});
		f.addWindowListener(new newWindowListener());
		
		//4.鼠标监听 
		bt.addMouseListener(new MouseAdapter() {
			//单击监听
			public void mouseClicked(MouseEvent e) {
				System.out.println("单击");
				System.exit(0);
			}
			//释放监听
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("释放");
				System.exit(0);
			}
		});


		//5.键盘监听
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("您当前输入的值:" + e.getKeyCode() + "字符值:" + e.getKeyChar());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			} 
		});
		
		//6.动作监听
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true); //是否可显示
	}
}

//实现重写接口中方法
class newWindowListener implements WindowListener {
  
	//软件打开时候显示
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
	
	//软件默认打开以及缩小还原的时候显示执行
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Windows Show");
	}
	
	//软件缩小时候触发
	@Override
	public void windowDeactivated(WindowEvent e) {
	    JOptionPane.showMessageDialog(null, "友情提示");  
	}
}


