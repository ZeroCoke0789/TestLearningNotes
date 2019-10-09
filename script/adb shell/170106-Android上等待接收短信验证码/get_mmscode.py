# coding=utf-8

import os
import time
import re
import sys

# ====================Function()====================
# 匹配字符串中的验证码（6位数字）


def match_vercode(str_msg):
    ver_code = re.search("\d{6}", str_msg, 0)
    return ver_code.group()


# adb识别手机是否连上了
def is_connect_adb():
    cmd_adb = "adb devices"
    content = os.popen(cmd_adb).read()
    default_adb_devices = "List of devices attached"
    return (content.strip() != "List of devices attached")


# 获取短信验证码，默认超时20秒
def get_code_from_mms(timeout=10):
    os.system("adb logcat -c")

    # 执行cmd获取收到的短信内容
    cmd = "adb logcat -d | findstr /C:\"message content is \""

    num = 0
    while num < timeout:
        msg_content = os.popen(cmd).read()
        print(msg_content)

        # 调试短信内容
        # if num == 5:
        #    msg_content = "D/PPL/PplSmsFilterExtension( 1185): pplFilter: message content is 验证码：708933"

        if msg_content != "":
            #msg_content = matchVercode(msg_content)
            print("code is {}:".format(msg_content))
            break
        else:
            time.sleep(1)
            num += 1
            print('已等待:{}秒'.format(num))
            continue

    if num == timeout:
        print("等待超时！短信接收失败。")


# ====================正文====================
# 判断是否有timeout参数，没有则执行默认
def run_get_code(list):
    length = len(list)
    if length == 2:
        get_code_from_mms(list[1])
    else:
        get_code_from_mms()


# 先判断adb是否正常，正常则运行代码。
if(is_connect_adb()):
    print("adb连接正常！开始等待获取短信验证码！")
    run_get_code(sys.argv)
else:
    print("Android设备adb连接有问题，请cmd输入\"adb devces\"命令，重新检查设备连接。")
