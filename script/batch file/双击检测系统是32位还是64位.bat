@echo off
if %PROCESSOR_ARCHITECTURE% == x86 (
echo+
echo+
echo 您的操作系统是32位的
echo+
echo+
)else (
echo+
echo+
echo 您的操作系统是64位的
echo+
echo+
)
pause