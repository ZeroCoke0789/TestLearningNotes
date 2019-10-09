@echo off 
set work_path=D:\git-workspace
D: 
cd %work_path% 
::遍历该目录下所有目录和文件： for /f %%s in ('dir /b') do ( echo %%s ) 
::遍历该目录下所有目录： for /f %%s in ('dir /ad/b') do ( echo %%s )
::注意：for命令的"/f"和"/b"不能同时用，是错误语法。
for /f %%s in ('dir /ad/b') do ( echo %%s ) 

pause 


::dir命令：
::/ad表示只显示目录，/b表示按空格式显示（没有标题信息和摘要）
::其他dir命令见百度百科：https://baike.baidu.com/item/DIR/297827?fr=aladdin