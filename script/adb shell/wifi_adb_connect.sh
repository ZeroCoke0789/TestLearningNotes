# !/bin/zsh

# 无线adb连接函数
function adbConnect() {
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
    # 获取手机当前wifi的ip（先用netcfg，若无此命令则用ifconfig wlan0）
    execute_netcfg_result=`adb shell netcfg`
	if [[ "${execute_netcfg_result}" =~ "not found" ]]
	then
		ip=`adb shell ifconfig wlan0 | sed -n '2'p | grep -E '\<[0-9]+.[0-9]+.[0-9]+.[0-9]+\>' -o | sed -n '1'p`
	else
		if_info=`adb shell netcfg | grep wlan | awk '{print $3}'`
		ip=${ip_info%/*}
	fi
	#echo $ip
    echo "设备：${1}，当前wifi连接IP：${ip}"
    adb tcpip ${2}
    adb connect ${ip}:${2}
    # echo "（adb连接切换无线模式结束，结果见上输出，此处未做结果判断）"
    # 存储 connect 的ip号和端口号
    save_file_name="connect_device_list.txt"
    touch ${save_file_name}
    echo -e "${1}"\\t"${ip}"\\t"${2}" > ${save_file_name}
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
}


# 处理for循环不按整行输出的问题
IFS_old=$IFS
IFS=$'\n'

# 设定adb连接端口
tcpip_port=5037

# 查看当前连接的设备列表
adb devices
# echo

# 获取已连接成功的设备列表：过滤第1行数据、过滤空行。
# 过滤第1行数据：`awk '{if(NR > 1) print $0}'`或`sed -n '2,$p'`
# 过滤空行：`awk '{if($0!~"^$") print $0}'`
# result_adb_devices=`adb devices -l | awk 'NR > 1 {if($0!~"^$") print $1 "\t" $2 "\t" $3}'`
result_adb_devices=`adb devices -l | awk '{if(NR > 1 && $0!~"^$") print $1 "\t" $2 "\t" $3}'`
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
		device_mobile_info=`echo ${line} | awk '{print $3}'`
		# 当设备的连接状态是device时继续
		if  [ "${device_status}"x == "device"x ] # && [[ "${device_mobile_info}"x == usb* ]]
		then
			# # 当设备是usb连接时继续
			# if [[ "${device_mobile_info}"x == usb* ]]
			# then
			#     echo xxx
			# else
			#     echo "设备${device_name} --> 该设备目前连接方式不是usb连接，无法无线连接adb。"
			# fi
			# 当设备名是非ip连接时继续
			if [[ ! $device_name =~ ^([0-9]{1,3}.){3}[0-9]{1,3} ]]
			then
				echo "设备${device_name} --> 该设备可连接adb"
				adbConnect ${device_name} ${tcpip_port}
			else
				echo "设备${device_name} --> pass (是模拟器、或是已无线连接adb的设备)"
			fi
		else
			echo "设备${device_name} --> 该设备连接异常，请检查USB开发者选项是否都已勾选。： ${device_status}"
		fi
		echo
	done
fi

echo "脚本运行结束"
read -n 1 -p "Press any key to over."
IFS=$IFS_old
exit
