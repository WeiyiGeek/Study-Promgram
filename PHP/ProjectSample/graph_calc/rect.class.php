<?php
/*
 * 这个类是一个矩形的类， 这个类要按形状的规范去实现
 *
 */
class Rect extends Shape {
	private $width;
	private $height;

	function __construct($arr=array()) {

		if(!empty($arr)) {
			$this->width = $arr['width'];
			$this->height = $arr['height'];
		}
		$this->name = "矩形";
	}
	
	function area() {
		return $this->width * $this->height;
	}

	function zhou() {
		return 2*($this->width + $this->height);
	}

	function view() {
		$form = '<form action="index.php?action=rect" method="post">';
		$form .= $this->name.'的宽:<input type="text" name="width" value="'.$_POST['width'].'" /><br>';
		$form .= $this->name.'的高:<input type="text" name="height" value="'.$_POST['height'].'" /><br>';
		$form .= '<input type="submit" name="dosubmit" value="计算"><br>';
		$form .='<form>';
		echo $form;
	}

	function yan($arr) {
		$bg = true;
		if($arr['width'] < 0) {
			echo $this->name."的宽不能小于0!<br>";
			$bg = false;	
		}

		if($arr['height'] < 0) {
			echo $this->name."的高度不能小于0!<br>";
			$bg = false;
		}

		return $bg;
	}

}
