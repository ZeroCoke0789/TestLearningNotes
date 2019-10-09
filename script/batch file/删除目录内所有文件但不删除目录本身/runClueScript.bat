@echo off

@rem Set local scope for the variables with windows NT shell
@rem if "%OS%"=="Windows_NT" setlocal enabledelayedexpansion


@rem 进入服务目录
cd D:/Che168/SyncSalesClue/SyncSalesClueRecord

@rem 先删除原有日志文件
del /s/q log
::删除logs目录里所有文件，但不删除目录本身

@rem 再执行服务程序
GrabSalesClueRecord.exe


@rem End local scope for the variables with windows NT shell
@rem if "%OS%"=="Windows_NT" endlocal

echo. & pause & goto:eof