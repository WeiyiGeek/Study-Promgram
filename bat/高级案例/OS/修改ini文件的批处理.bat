@echo off >tmp.ini
for /f "tokens=1* delims=:" %%i in ('findstr /n ".*" 文件位置') do (
   if "%%j"=="" (echo.>>tmp.ini) else (
      echo %%j|find "被替换内容">nul&&(
        call set tp=%%j & call echo %%tp:被替换内容=替换内容%%>>tmp.ini)||(
           >>tmp.ini echo %%j)
   )
)
copy tmp.ini 文件位置 /y >nul || (attrib -s -a -r -h 文件位置 & copy tmp.ini 文件位置 /y >nul)
del tmp.ini
pause
