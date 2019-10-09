@echo off

set TempFile=D:\temp.txt

adb shell am start -W -n com.UCMobile/com.UCMobile.main.UCMobile

adb shell ps -x -c | findstr com.UCMobile > %TempFile%
set /p BroswerAppUid=<"%TempFile%"
set /a BroswerAppUid=10%BroswerAppUid:~4,3%
echo %BroswerAppUid%
adb shell cat /proc/net/xt_qtaguid/stats | findstr %BroswerAppUid% |findstr "wlan0" 
echo.

echo. & pause & goto :eof
