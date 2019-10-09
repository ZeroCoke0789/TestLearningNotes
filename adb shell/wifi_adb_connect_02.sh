# !/bin/zsh

# 无线tcp连接函数
function tcp_connect() {
	echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
	# 设定设备号
	serial_number=${1}
	tcpip_port=${2}
	echo "设备${serial_number}，开始tcp连接:"
    # 查询ip(根据系统版本命令不同
	sdk_num=`adb -s"${serial_number}" shell getprop ro.build.version.sdk` &&
	if [ $sdk_num -eq 19 ]; then
		ip=`adb -s"${serial_number}" shell netcfg 2>/dev/null | grep wlan0 | awk '{print $3}' | awk -F"/" '{print $1}'`
	else
		ip=`adb -s"${serial_number}" shell ifconfig eth0 2>/dev/null || adb -s"${serial_number}" shell ifconfig wlan0 2>/dev/null \
		| grep -oE "(inet addr:)[^ ]+" | awk -F":" '{print $2}' | sed 's/ //g'`
	fi &&
	# 切换tcp模式
	adb -s"${serial_number}" tcpip 5555 &&
	# adb无线连接
	adb connect $ip
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
}


# 处理for循环不按整行输出的问题
IFS_old=$IFS
IFS=$'\n'

# 设定adb连接端口
tcpip_port=5037

# 断开所有连接
adb disconnect
echo

# 查看当前连接的设备列表
adb devices
echo

# 获取所有可无线连接的设备列表: 过滤第1行数据+过滤空行+过滤ip行+只显示状态=device的行
device_list=`adb devices | awk '{if(NR>1 && $0!~"^$" && $1!~"[.:]" && $2=="device" ) print $1}'`
# 学习: 
# 过滤第1行: 可以用2种方式: `awk '{if(NR > 1) print $0}'` 和 `sed -n '2,$p'`
# 过滤空行: `$0!~"^$"`
# 过滤ip行: 判断显示第1列不包含"."和":"的行: `$1!~"[.:]`
# 只显示状态=device的行: 判断显示第2列=device的行: $2=="device"
echo

# 输出下列表，若当前无连接中的设备，则终止脚本。
if [ ! "${device_list}" ]; then
    echo "当前无可连接设备，运行停止。"
	echo
else
	echo '找到以下可无线连接设备:'
	for device_name in ${device_list}
	do
		echo device_name
	done
	echo
	# 开始逐个改为tcp连接
	for device_name in ${device_list}
	do
		tcp_connect ${device_name} ${tcpip_port}
	done
	echo
fi


echo "脚本运行结束"
read -p "Press any key to over."
IFS=$IFS_old
exit

# 判断是否是ip：
# if [[ ! $device_name =~ ^([0-9]{1,3}.){3}[0-9]{1,3} ]]

