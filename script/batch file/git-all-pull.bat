@echo off

echo ############### shell start! ###############
echo.
D:
cd D:\git-workspace
FOR /F %%i IN ('cd') DO echo %%i
echo.
echo.
echo.

:: for loop pull
for /f %%i in ('dir /ad/b') do ( call:gitPull %%i )

:: specify-project-pull
rem call:gitPull "git-groovy"
rem call:gitPull "git-python"
rem call:gitPull "git-soapui"
rem call:gitPull "git-robotframework"

echo ############################################
echo. & pause & goto:eof

::--------------------------------------------------------
::-- Function section starts below here
::--------------------------------------------------------

:gitPull
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo %~1 
echo.
echo ########## git-pull start! ##########
echo.
cd ./%~1
FOR /F %%i IN ('cd') DO echo %%i
echo.
git pull
echo.
cd ..
FOR /F %%i IN ('cd') DO echo %%i
echo.
echo ########## git-pull over! ##########
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo.
echo.
goto:eof