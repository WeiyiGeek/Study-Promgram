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
		f.setLayout(new FlowLayout()); //设置布局管理器
		//3.事件源是窗体把监听器注册到事件源上，事件对象传递给监听器(让窗口适配器可以支持)
		f.addWindowListener(new WindowAdapter() {
				//当然您也可以建立一个类实现WindowsAdapter接口中方法;
				//或者采用匿名内部类;
		        public void windowClosing(WindowEvent e) {
		        System.exit(0);//退出虚拟机,关闭窗口 
		    }
		});
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
			public void KeyReleased(KeyEvent e) {
				System.out.println("您当前输入的值:" + e.getKeyCode() + "字符值:" + e.getKeyChar());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		
		f.setVisible(true); //是否可显示
	}
}
