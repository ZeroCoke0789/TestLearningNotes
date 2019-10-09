# !/bin/zsh

# 无线adb连接函数
function adbConnectStop() {
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
    # 获取手机当前wifi的ip
    adb -s ${1} usb
    # echo "（adb连接切换usb模式结束，结果见上输出，此处未做结果判断）"
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
}


# 处理for循环不按整行输出的问题
IFS_old=$IFS
IFS=$'\n'

# 查看当前连接的设备列表
adb devices
# echo

# 获取已连接成功的设备列表：过滤第1行列名，过滤空行
# result_adb_devices=`adb devices -l | awk 'NR > 1 {if($0!~"^$") print $1 "\t" $2 "\t" $3}'`
result_adb_devices=`adb devices -l | awk '{if(NR > 1 && $0!~"^$") print $1 "\t" $2}'`
# 若当前无连接中的设备，则终止脚本
if [ ! "${result_adb_devices}" ]
then
    echo "当前无连接中的设备，脚本终止。"
else
    echo "有连接中的设备，开始判断："
	# 若当前有连接中的设备，则继续
	for line in ${result_adb_devices}
	do
		# echo ${line}
		device_name=`echo ${line} | awk '{print $1}'`
		device_status=`echo ${line} | awk '{print $2}'`
		# 当设备的连接状态是device时继续
		if  [ "${device_status}"x == "device"x ] # && [[ "${device_mobile_info}"x == usb* ]]
		then
			# 当设备名是非ip连接时继续
			if [[ $device_name =~ ^([0-9]{1,3}.){3}[0-9]{1,3} ]]
			then
				echo "设备${device_name} --> 该设备可能是无线连接adb设备"
				adbConnectStop ${device_name}
			else
				echo "设备${device_name} --> pass (是USB连接设备)"
			fi
		else
			echo "设备${device_name} --> 该设备连接异常： ${device_status}"
		fi
		echo
	done
fi

echo "脚本运行结束"
read -p "Press any key to over."
IFS=$IFS_old
exit
