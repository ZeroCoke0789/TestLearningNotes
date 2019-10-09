@echo off
::设置包名、APK路径(查看Android应用包名、Activity的几个方法-http://blog.csdn.net/jlminghui/article/details/40622103)
set app_pkg=com.che168.ucdealer
set app_aty=com.che168.ucdealer.activity.LaunchActivity
::set app_apk=C:\Users\renyi0301\Desktop\chezhiying_beta.apk
set app_apk=.\chezhiying_beta.apk

::查看是否已安装
adb shell pm list package | findstr %app_pkg% > temp.txt
set /p pkg=<temp.txt
del temp.txt
echo %pkg%
::如果安装了就卸载
if "%pkg%"=="package:%app_pkg%" adb uninstall %app_pkg%
::卸载后再次安装
adb install %app_apk%
::打印个执行完成标志
echo Install Over!

::运行APP
adb shell am start -n %app_pkg%/%app_aty%
::打印个执行完成标志
echo Start Over!

::等待3秒后关闭(cmd-bat批处理命令延时方法-http://blog.csdn.net/xie1xiao1jun/article/details/45876815)
@choice /t 3 /d y /n >nul