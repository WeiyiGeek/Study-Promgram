@echo off
::ErrorLevel·µ»ØÖµ
reg add HKCU /v try /f>nul
reg delete HKCU /v try /f
if %errorlevel%==0 (echo É¾³ý³É¹¦) else (echo É¾³ýÊ§°Ü)
reg delete HKCU /v try /f
if %errorlevel%==0 (echo É¾³ý³É¹¦) else (echo É¾³ýÊ§°Ü£©
pause>nul
