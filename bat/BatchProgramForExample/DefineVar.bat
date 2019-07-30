@echo off
::Variable 定义与调用
set varTest=123
echo varTest=%varTest%

set varText=456
echo varText=%varText%

::将变量进行调用并进行算数运算
set /a a=%varTest%+%varText%
echo "variable Sum"%a%
