@echo off

echo ############### param_ready ###############
rem 获取今天日期（格式：11/23/2017 Thu），然后转换为commit_content
echo %date%
set location=CompanySubmit
set today=%date:/=%
::echo %today:~4,4%
::echo %today:~0,2%
::echo %today:~2,2%
::echo %today:~-3,3%
set today_commit_content=%today:~4,4%%today:~0,2%%today:~2,2%_%today:~-3,3%_%location%_Update_By_bat
::set today_commit_content=%today_commit_content%_更新xxx
echo %today_commit_content%
echo.

echo ############### shell start! ###############
echo.
D:
cd D:\git-workspace
FOR /F %%i IN ('cd') DO echo %%i
echo.
echo.
echo.

:: for loop push
for /f %%i in ('dir /ad/b') do (
    if %%i neq appium (
    	if %%i neq bilibili-captcha (
    		if %%i neq soapui (
    			if %%i neq mybook-java-imageprocess (
    				call:gitPush %%i %today_commit_content%
    			)
    		)
    	)
    )
)
::call :gitPush "git-groovy" %today_commit_content%
::call :gitPush "git-python" %today_commit_content%
::call :gitPush "git-soapui" %today_commit_content%

echo ############################################
echo. & pause & goto :eof

::--------------------------------------------------------
::-- Function section starts below here
::--------------------------------------------------------

:gitPush

echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo %~1 
echo.
echo ########## git-push start! ##########
echo.
cd ./%~1
FOR /F %%i IN ('cd') DO echo %%i
echo.
echo -----
git add .
git commit -m "%~2"
echo.
git push origin
echo -----
echo.
cd ..
FOR /F %%i IN ('cd') DO echo %%i
echo.
echo ########## git-push over! ##########
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo.
echo.
goto :eof