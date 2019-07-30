@echo off
::扩展字符串变量
cls
echo 正在运行的这个批处理：
echo 完全路径：%0
echo 去掉引号：%~0
echo 所在分区：%~d0
echo 所处路径：%~p0
echo 文件名：%~n0
echo 扩展名：%~x0
echo 路径和文件名：%~f0 = %~s0
echo 文件属性：%~a0
echo 修改时间：%~t0
echo 文件大小：%~z0
::可以用上面的修饰符进行重新组合,达到的扩充字符串!
echo 驱动器号和路径：%~dp0
echo 文件名和扩展名：%~nx0
echo 完整路径名：%~fs0
echo "相当于lINUX中ll的效果 ：%~ftza0
echo 路径的环境变量的目录：%~ds%PATH%:0
pause
