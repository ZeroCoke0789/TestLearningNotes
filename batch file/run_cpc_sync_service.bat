@echo off

chcp 65001

@rem 进入指定目录
cd 广告数据同步

@rem 先删除原有日志文件
del /s/q log
::删除logs目录里所有文件，但不删除目录本身

@rem 再执行推送程序
Che168.Quartz.Test.exe

echo. & pause & goto:eof