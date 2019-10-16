# Appium安装_11_双平台_appium-desktop安装及Android端环境安装

介绍在Windows电脑或Mac电脑上，若想使用appium-desktop进行自动化测试，在对Android端的安装及运行测试的过程。  
注意：  
1.因非Mac系统不能进行iOS端自动化测试，因此Windows平台上只能进行Android端测试。  
2.此介绍只讲解Appium的安装过程，关于npm、adb等依赖不做介绍，想装请见《安装准备》文档。

---

[TOC]

---

## 一、Appium-desktop的安装：

    https://github.com/appium/appium-desktop/releases/
    打开上面链接，下载最新的appium-desktop安装包，然后按要求一步步安装即可。

## 二、Android端Appium环境运行测试：

##### 1.找一个Android测试机并设置好：
    找个Android测试机，打开“开发者选项”和“USB调试”，配置adb运行环境，确保adb服务可运行。

##### 2.找一个被测app:
    找个apk包或将app直接安装在测试机上都行。

##### 3.获取启动参数。
    appium启动测试应用时，需要指定启动参数，如下：
    
    未安装app需要： 
        platformName/platformVersion/deviceName/app，4个参数
    已安装app时需要： 
        platformName/platformVersion/deviceName/appPackage/appActivity，5个参数

    参数说明：
    platformName：平台名称，Android还是iOS，必填；
    platformVersion：平台系统版本，如Android 5.0，必填。直接手机设置里查询就行。
    deviceName：设备名称，随便取，但必填。
    app：apk包的存放路径。
    appPackage：被测app的package名，获取方法见3.1或3.2。
    appActivity：被测app的启动activity名，获取方法见3.2。

###### 3.1 根据apk获取app对应的package名(有apk时可用，没有见3.2)：
```bash
## 输出apk对应的package名
apk_name=xxx.apk &&
if [ ! -f ${apk_name} ]; then
    echo `pwd`"/${apk_name}文件不存在，请检查路径是否正确。"
else
    pkg_name=`aapt dump badging "./${apk_name}" | grep package \
    | grep -o "name='[^']*" | awk -F"'" '{print $2}'` && echo $pkg_name
fi
```
`示例：钉钉appPackage=com.alibaba.android.rimet`

###### 3.2 利用adb logcat查询app的启动activity名：
```bash
adb logcat | grep "Displayed"
```
输入上面命令，再启动app，出现的第1个相同package的activity，即为启动activity名。  
`示例：钉钉appActivity=.biz.LaunchHomeActivity`

##### 4.启动appium服务：
    双击appium-desktop程序运行，点击“start server”，启动appium服务。

##### 5.打开Inspector，输入启动参数，启动被测app，开始测试：
```json
{
  "platformName": "Android",
  "platformVersion": "7.0",
  "deviceName": "Samsung S6",
  "appPackage": "com.alibaba.android.rimet",
  "appActivity": ".biz.LaunchHomeActivity"
}
```
在Automatic Server页的Desired Capabilities列表输入以下参数，然后点“Start Seesion”即可。

其他常用参数：  
unicodeKeyboard：启动unicode键盘，true or false，默认false。开启后支持中文。  
resetKeyboard：使用unicodeKeyboard功能运行Unicode测试后，将键盘重置为原来的状态。单独使用时忽略。true or false，默认false。开启后支持中文。  
noReset：是否不重置应用程序状态，true or false，默认true。  

[Appium Desired Capabilities介绍](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md)

```json
{
  "platformName": "Android",
  "platformVersion": "7.0",
  "deviceName": "Samsung S6",
  "appPackage": "com.che168.autotradercloud",
  "appActivity": ".launch.LaunchActivity",
  "unicodeKeyboard": "true",
  "resetKeyboard": "true",
  "noReset": "true"
}
```
