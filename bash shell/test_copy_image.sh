# 判断截图文件路径： /sdcard/pictures/screenshots 或 /sdcard/dcim/screenshots，二选一
ls_image_result=`adb shell ls "./sdcard/pictures/screenshots"`
# echo ${ls_image_result}
if [[ ${ls_image_result} =~ "No such file or directory" ]]
then
	echo "路径不存在"
	image_path="./sdcard/dcim/screenshots"
	
else
	echo "路径存在"
	image_path="./sdcard/pictures/screenshots"
fi
echo "截图目录为：${image_path}"

# 执行复制到桌面
adb pull ${image_path} "C:/Users/renyi0301/Desktop"

echo "截图目录复制完毕"

# 删除目录文件
read -p "Press any key to over."