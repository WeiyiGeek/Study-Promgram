<?php
$text = "<note>";
$text .= "<to>Tove</to>";
$text .= "<from>Jani</from>";
$text .= "<heading>Reminder</heading>";
$text .= "<body>Don't forget me this weekend!</body>";
$text .= "</note>";

$fe = fopen("index.xml","a+"); 
fwrite($fe,$text);
fclose($fe);

echo "<iframe src='index.xml' width='100%' height='50%'>不支持Iframe</iframe>";
?> 