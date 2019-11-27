#$DemoVar = $env:JDK_HOME
#Write-Output $DemoVar

function fun() {
   "DemoVar=$DemoVar";
   $DemoVar="Function Inner";
   $DemoVar;
}


fun