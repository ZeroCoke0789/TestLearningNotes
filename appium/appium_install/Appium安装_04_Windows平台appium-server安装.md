# Appium安装-Windows平台Appium Server安装

介绍如何使用npm安装appium服务，以及如何运行被测应用。  
（因Windows平台不支持iOS端自动化，因此以下只介绍Android端的Appium安装。）

[TOC]

---

## 一、Appium Server的安装：

##### 1.安装node和npm：
见“一、准备工作”。  
##### 2.npm安装appium： 
    `npm install -g appium --registry=https://registry.npm.taobao.org`
##### 3.npm安装appium client：
    `npm install wd --registry=https://registry.npm.taobao.org` 
##### 4.npm安装appium-doctor：
    `npm install -g appium-doctor --registry=https://registry.npm.taobao.org`
##### 5.检验appium环境：
输入`appium-doctor`，验证appium环境是不是已配好、是否有问题。  
##### 6.检验appium运行正常：
输入`appium -v`，运行appium验证是否运行正常。  
##### 7.安装时问题处理记录：  
* 运行”npm install -g appium“时下载appium-chromedriver超时(下载不下来)：  
【问题显示：】  
npm ERR! appium-chromedriver@3.1.4 install: `node install-npm.js`  
info Chromedriver Install Downloading https://chromedriver.storage.googleapis.com/2.33/chromedriver_mac64.zip...  
RequestError: Error: connect ETIMEDOUT 172.217.160.112:443  
...  
npm ERR! code ELIFECYCLE  
npm ERR! errno 1  
npm ERR! appium-chromedriver@3.1.4 install: `node install-npm.js`  
npm ERR! Exit status 1  
npm ERR!  
npm ERR! Failed at the appium-chromedriver@3.1.4 install script.  
npm ERR! This is probably not a problem with npm. There is likely additional logging output above.  
【对策：】  
使用appium源码安装，或添加--chromedriver_cdnurl参数再运行安装：  
`--chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver`

* 下载 UiAutomator2 Server test APK v0.3.0 超时：  
【问题显示：】  
info UiAutomator2 downloading UiAutomator2 Server test APK v0.3.0 :   https://github.com/appium/appium-uiautomator2-server/releases/download/v0.3.0/appium-uiautomator2-server-debug-androidTest.apk  
【对策：】  
手动下载：记录下载链接和本地存放目录，直接翻墙去下载链接下载对应apk包，再放入本地存放目录即可。  

---

## 二、Appium-Android端驱动安装：

* [The UiAutomator2 Driver for Android](http://appium.io/docs/en/drivers/android-uiautomator2/) 
* [The UiAutomator Driver for Android](http://appium.io/docs/en/drivers/android-uiautomator/) 
* [The Selendroid Driver for Android](http://appium.io/docs/en/drivers/android-selendroid/)

##### 1.安装appium-android-driver:   
    npm install appium-android-driver --registry=https://registry.npm.taobao.org --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver 
##### 2.安装appium-chromedriver(建议指定chromedriver镜像安装):  
    npm install appium-chromedriver --registry=https://registry.npm.taobao.org --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver
##### 3.安装指定chromedriver版本的appium-chromedriver：
    npm install appium-chromedriver --chromedriver_version="2.16"   --chromedriver_cdnurl=http://npm.taobao.org/mirrors/chromedriver

---

## 三、Android端Appium环境运行测试：

##### 1.查询apk对应的package名：
```bash
## 输出apk对应的package名
apk_name=AutoTraderCloud_beta.apk &&
if [ ! -f ${apk_name} ]; then
    echo `pwd`"/${apk_name}文件不存在，请检查路径是否正确。"
else
    pkg_name=`aapt dump badging "./${apk_name}" | grep package \
    | grep -o "name='[^']*" | awk -F"'" '{print $2}'` && echo $pkg_name
fi
```
`com.che168.autotradercloud`

##### 2.查询apk的启动activity名：
```bash
adb logcat | grep "Displayed"
```
输入上面命令，再启动app，出现的第1个相同package的activity，即为启动activity名。  
`.launch.LaunchActivity / com.che168.autotradercloud.launch.LaunchActivity`

##### 3.启动appium服务：
    双击appium-desktop运行程序，点击“start server v1.xx.x”，启动appium服务。

##### 2.打开Inspector，输入启动参数，让appium启动被测app：
    





