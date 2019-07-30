
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>视屏播放</title>
</head>
<body align="center">

    <?php
        $handle = opendir('.');
        if($handle)
        {   $video = "";
            while($file = readdir($handle))
            {
                if($file != '.' && $file !=".." && $file != "index.php")
                {
                    $video .= "<p style='color:red'>".$file."</p><video src='".$file."' controls='true' height='450px' >Not supoort Video</video><br><br><hr>";
                }
            }
            echo $video;
        }
        closedir($handle);
    ?>
</body>
</html>
