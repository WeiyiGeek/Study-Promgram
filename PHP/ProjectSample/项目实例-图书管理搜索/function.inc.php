<?php
	
function upload($name) {
		global $waterimg;
		$up = new FileUpload();
		$up -> set("path", "../uploads/");
		if($up->upload($name)) {
			//获取上传的图片名字
			$pic = $up->getFileName();
			//创建图像对象
			$img = new Image("../uploads/");
			//缩放两张， 一个原图， 一个是用来，列表使用的小图
			$img -> thumb($pic, 300, 300, "");
			$img -> thumb($pic, 200, 200, "th_");
			//添加水印图片
			$img -> watermark($pic, $waterimg, 9, "");

			return $pic;
		} else {
			echo $up->getErrorMsg();
			return false;
		
		}

}
?>

