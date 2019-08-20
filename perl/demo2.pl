
#!/usr/bin/perl
#FUNCTION: 实现判断语句与while循环
$num1 = 1024;
$num2 = 1;
$sum = 0;

if( $num1 != "" && $num2 != "" )
{
  $add = $num1 + $num2;
  print "$num1 + $num2 = $add\n";
}

while($num <= 100)
{
  $sum = $sum + $num;
  $num++;
}

print "1+..+3+...+7+100 = $sum \n";
