@echo off

echo ############### param_ready ###############
rem 获取今天日期（格式：11/23/2017 Thu），然后转换为commit_content
echo %date%
set location=Coltd
set commit=更新bat脚本
set today=%date:/=%
set today_commit_content=%today:~4,4%%today:~0,2%%today:~2,2%_%today:~-3,3%_%location%_Update_%commit%
echo %today_commit_content%
echo.
echo ############### shell start! ###############
echo %cd%
rem call :gitPull %cd% %today_commit_content%
echo.
git add .
git commit -m %today_commit_content%
echo.
git push origin
echo.
echo ############################################
echo. & pause & goto :eof
