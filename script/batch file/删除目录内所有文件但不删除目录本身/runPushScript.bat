@echo off

rem 进入push目录
cd push

rem 先删除原有日志文件
del /s/q logs
::删除logs目录里所有文件，但不删除目录本身

rem 再执行推送程序
java -jar ./service.push-1.0-SNAPSHOT.jar
