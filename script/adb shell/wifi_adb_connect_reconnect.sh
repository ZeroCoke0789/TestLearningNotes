# !/bin/zsh

# 无线adb连接函数
function adbReconnect() {
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
	echo "重连接：${line}"
    adb connect ${2}:${3}
    # echo "设备${1}已重连接，结果见上输出（此处未做结果判断）"
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
}


# 处理for循环不按整行输出的问题
IFS_old=$IFS
IFS=$'\n'

# 获取需重连接的设备ip列表
reconnect_device_list=`cat connect_device_list.txt`

# 若当前无连接中的设备，则终止脚本
if [ ! "${reconnect_device_list}" ]
then
    echo "文件中无任何设备ip信息，脚本终止。"
else
    echo "有已连接过的设备ip信息，开始判断："
	# 若文件中有已连接过的设备ip信息，则继续
	for line in ${reconnect_device_list}
	do
		# echo ${line}
		# 获取手机当前wifi的ip
		device_name=`echo ${line} | awk '{print $1}'`
		device_ip=`echo ${line} | awk '{print $2}'`
		device_port=`echo ${line} | awk '{print $3}'`
		adbReconnect ${device_name} ${device_ip} ${device_port}
		echo
	done
fi

echo "脚本运行结束"
read -p "Press any key to over."
IFS=$IFS_old
exit
