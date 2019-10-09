# -*- coding: utf-8 -*-
# @Author: renyi0301
# @Date:   2019-01-09 19:45:57
# @Last Modified by:   renyi0301
# @Last Modified time: 2019-01-14 11:10:45

# adb shell getevent //dev/input/event0 >> getevent.log

'''
with open('./getevent2.bat', 'w') as f2:
    # f2.write("@echo off\r\n")
    f2.write("adb shell input keyevent 26\r\n")
    f2.write("adb shell input keyevent 82\r\n")
    f2.write("@choice /t 1 /d y /n >nul\r\n")
    with open('./getevent.log', 'r') as f:
        for line in f.readlines():
            new_line = " ".join([str(int(it, 16)) for it in line.strip().split(" ")])
            f2.write("adb shell sendevent /dev/input/event0 " + new_line + "\r\n")
    f2.write("echo ############################################\r\n")
    f2.write("echo. & pause & goto:eof\r\n")
'''


with open('./getevent2.sh', 'w') as f2:
    f2.write("adb shell input keyevent 26\r")
    f2.write("adb shell input keyevent 82\r")
    with open('./getevent.log', 'r') as f:
        for line in f.readlines():
            new_line = " ".join([str(int(it, 16)) for it in line.strip().split(" ")])
            f2.write("adb shell sendevent //dev/input/event0 " + new_line + "\r")

# event_path='//dev/input/event0' && adb shell getevent ${event_path} | awk -v event="${event_path}" '{print "adb shell sendevent "event" "strtonum("0x"$1)" "strtonum("0x"$2)" "strtonum("0x"$3)}'
# event_path='//dev/input/event0' && adb shell getevent ${event_path} | awk -v event="${event_path}" '{print "adb shell sendevent "event" "strtonum("0x"$1)" "strtonum("0x"$2)" "strtonum("0x"$3); fflush()}' >> record_event.sh

'''
adb shell input keyevent 26 &&
adb shell input keyevent 82 &&
bash ./record_event.sh
'''
