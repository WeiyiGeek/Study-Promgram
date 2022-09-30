
$gifs=dir -Path "C:\Users\WeiyiGeek\Documents\Tencent Files\291238737\FileRecv\GIF" -Filter '*.gif';
$newPath=$gifs[0].DirectoryName+'\JPG';
if(-not (Test-Path $newPath)){mkdir $newPath|Out-Null;};
if($gifs){
  foreach($g in $gifs){
      $bf=[System.Drawing.Bitmap]::FromFile($g.fullName);
      $newFileName=$newPath+'\'+$g.BaseName+'.jpg';
      $bf.Save($newFileName,[System.Drawing.Imaging.ImageFormat]::Jpeg);
      $bf.Dispose();
  }
  Write-Host ('共'+$gifs.Count+'个，转换完成...');
  }else{
  Write-Host '当前目录没有找到任何GIF文件！';
  }