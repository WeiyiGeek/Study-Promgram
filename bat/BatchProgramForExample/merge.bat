@echo off
::合并字符串Demo
cls
set aa=伟大的中国！
set bb=我为你自豪！
echo %aa%%bb%
echo aa=%aa%
echo bb=%bb%
set "aa=%aa%%bb%"
echo aa=%aa%
pause
