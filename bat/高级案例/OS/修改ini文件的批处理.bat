@echo off >tmp.ini
for /f "tokens=1* delims=:" %%i in ('findstr /n ".*" �ļ�λ��') do (
   if "%%j"=="" (echo.>>tmp.ini) else (
      echo %%j|find "���滻����">nul&&(
        call set tp=%%j & call echo %%tp:���滻����=�滻����%%>>tmp.ini)||(
           >>tmp.ini echo %%j)
   )
)
copy tmp.ini �ļ�λ�� /y >nul || (attrib -s -a -r -h �ļ�λ�� & copy tmp.ini �ļ�λ�� /y >nul)
del tmp.ini
pause
