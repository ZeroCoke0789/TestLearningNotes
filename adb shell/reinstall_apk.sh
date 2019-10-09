apk_name=${1} &&
pkg_name=`aapt dump badging ./${apk_name} | grep package | grep -o "name='[^']*" | awk -F"'" '{print $2}'` &&
adb uninstall ${pkg_name} | adb install -r ${apk_name}

# 单用方法：
# apk_name=AutoTraderCloud_beta.apk  &&

# sh运行方法：
# ./reinstall_apk.sh AutoTraderCloud_beta.apk
