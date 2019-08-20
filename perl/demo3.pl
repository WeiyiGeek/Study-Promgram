#!/usr/bin/perl
#function:验证Perl正则表达式进行匹配
#方式1:接受用户输入并且判断校验输入
print "Please Enter a number(Eg:1024):";
$demo = <STDIN>;  #交互式接收用户输入
chomp($demo);  #去掉$demo变量中输入的换行符
# 关键点：注意=~符号后的 m/,匹配成功返回true否则false
if ($demo =~ m/^[0-9]+$/ ) {
  print "only digits\n"
} else {
  print "not only digits\n"
}
