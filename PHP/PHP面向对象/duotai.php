<?php
/*  	多态特性：
 *  	1. 程序扩展准备
 *  	技术：必须有继承关系， 父类最好是接口或抽象类
 */
	//USB 接口
	interface USB {
		const ID = 0x12;
		const DERC = "USB";
		function load();
		function run();
		function stop();	
	}

	//Cimputer 为一个类得方法，限制调用得对象得方法；
	class Cumputer {
		//注意：类和接口可以用类名来限制得,只能传USB中这个类得对象得方法;
		function useUSB(USB $usb) {
			$usb -> load();
			$usb -> run();
			$usb -> stop();		
		}
	}

	//鼠标得子类继承USB （类必须实现这个接口得所有方法）
	class Mouse implements USB{
		function load() {
			echo "ID|Device加载鼠标成功!<br>";
		}

		function run() {
			echo "运行鼠标功能!<br>";
		}

		function stop() {
			echo "鼠标工作结束!<br>";
		}
	}

	//键盘得子类继承USB （类必须实现这个接口得所有方法）
	class KeyPress implements USB {
		function load() {
			echo "ID|Device加载键盘成功!<br>";
		}
		function run() {
			echo "运行键盘成功!<br>";
		}
		function stop() {
			echo "停止键盘使用!<br>";
		
		}
	}

	//建立一个工作者得类进行统一得调度
	class Worker {
		function work() {
			$c = new Cumputer();
			$m = new Mouse;
			$k = new KeyPress;
			$c->useUSB($k);  //传入到这个限制类里面
			$c->useUSB($m);
		}
	}
	//申请对象,调用方法;
	$w = new Worker;
	$w -> work();
