<?php
$img = imagecreate(400,300);
imagecolorallocate($img,255,255,255);

imageellipse($img, 240, 100, 50, 50, imagecolorallocate($img,255,0,0));

header('Content-type: image/png');
imagepng($img);
?>