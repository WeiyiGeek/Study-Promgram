<?php
/*
 * 这是一个形状的抽象类
 * 定义子类必须实现的一些方法
 */
abstract class  Shape{
	//形状的名称
	public $name;
	//形状的计算面积方法
	abstract function area();
	//形状的计算周长的方法
	abstract function zhou();
	//形状的图形表单界面
	abstract function view();
	//形状的验证方法
	abstract function yan($arr);

}


