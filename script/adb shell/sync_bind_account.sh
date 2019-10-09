adb shell input text hrc2shouche && adb shell input keyevent 66 &&
adb shell input text hrc2019 && adb shell input keyevent 4 &&
read width high < <(echo `adb shell wm size | awk -F": " '{print $2}'` | awk -F"x" '{print int($1),int($2)}') &&
adb shell input tap $((width/2)) $((high*945/1000))