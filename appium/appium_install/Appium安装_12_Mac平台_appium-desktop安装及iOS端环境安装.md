# Appium安装_12_Mac平台_appium-desktop安装及iOS端环境安装

介绍在Mac电脑上，若想使用appium-desktop进行自动化测试，对iOS端安装并运行测试的过程。  
注意：  
1.此介绍只讲解Appium的安装过程，关于brew、npm等依赖不做介绍，想装请见《安装准备》文档。

---

[TOC]

---

## 一、Appium-desktop的安装：

    https://github.com/appium/appium-desktop/releases/
    打开上面链接，下载最新的appium-desktop安装包，然后按要求一步步安装即可。

## 二、iOS端Appium环境运行测试：

（以下略，还未修改完）
============================================================

## 四、Appium-iOS端驱动安装： 

### 4.1 iOS9.3及以下系统版本驱动安装 --》 使用Xcode7(UIAutomation引擎)： 

#### 4.1.1 Simulator Setup:  

* [The UIAutomation Driver for iOS](http://appium.io/docs/en/drivers/ios-uiautomation/)

##### 4.1.2.1 安装authorize-ios:   
    `npm install -g authorize-ios@1.1.0 --registry=https://registry.npm.taobao.org`
    `sudo authorize-ios`

##### 4.1.2.2 安装IWD：
**1) 从github上下载appium-ios-driver库：**

    git clone https://github.com/appium/appium-ios-driver.git

**2) 找到Xcode-iwd.sh并配置安装：**

    Inside the repo, run the Xcode-iwd.sh script included in the bin dir, passing it several arguments:   
        (1) The path to the Xcode app you are using.  
        (2) The path to the appium-instruments directory.  
    For example:  
        sh ./bin/Xcode-iwd.sh /Users/renyi/TestTools/appium_tools/Xcode7 /Users/me/appium-instruments/
参考：[Xcode 9中模拟器的位置](https://blog.csdn.net/shaobo8910/article/details/78483155)

#### 4.1.2 Real Device Setup:   
##### 4.1.2.1 build app。  
##### 4.1.2.2 安装ideviceinstaller:   
    brew install libimobiledevice --HEAD
##### 4.1.2.3 利用libimobiledevice安装app:   
    ideviceinstaller -u <UDID of your device> -i <path to your built app>  

#### 4.1.3 Web测试：

* [SafariLauncher Setup Instructions](http://appium.io/docs/en/drivers/ios-uiautomation-safari-launcher/)

---


### 4.2 iOS10以上系统版本驱动安装 --》 使用最新Xcode(引擎XCuiTest)：

#### 4.2.1 Basic Setup：

* [The XCUITest Driver for iOS](http://appium.io/docs/en/drivers/ios-xcuitest/)
* [appium/appium-xcuitest-driver](https://github.com/appium/appium-xcuitest-driver)

##### 4.2.1.1 安装iOS命令行神器libimobiledevice: 
    brew install libimobiledevice --HEAD  # install from HEAD to get important updates
    brew install ideviceinstaller         # only works for ios 9. for ios 10, see below

##### 4.2.1.2.安装Carthage: 
    brew install carthage

##### 4.2.1.3 安装ios-deploy：
ideviceinstaller doesn't work with iOS 10 yet. So we need to install ios-deploy: 

    brew install ios-deploy

##### 4.2.1.4 安装ios-webkit-debug-proxy：
For hybrid or web tests, you will also need to follow the [ios-webkit-debug-proxy](http://appium.io/docs/en/writing-running-appium/web/ios-webkit-debug-proxy/index.html) setup instructions:

    brew install ios-webkit-debug-proxy  
然后appium启动时desired capability里配置下面参数，即可让iOS获取到WebView：

    "startIWDP":true,
该命令等同于等同于输入命令：

    ios_webkit_debug_proxy -c 0e4b2f612b65e98c1d07d22ee08678130d345429:27753 -d

* NOTE: the proxy requires the "web inspector" to be turned on to allow a connection to be established. Turn it on by going to settings > safari > advanced.

---


#### 4.2.2 Real Device Setup (主要在配置WebDriverAgent-Runner)： 

* [Appium XCUITest Driver Real Device Setup
](http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/)

##### 4.2.2.1 为Appium里的WebDriverAgent的下载依赖:

###### 4.2.2.1.1 下载Appium Desktop里的：

    find /Applications/Appium.app/Contents -iname WebDriverAgent
得到：
    
    /Applications/Appium.app/Contents/Resources/app/node_modules/appium-xcuitest-driver/WebDriverAgent
cd进入：

    cd xx/WebDriverAgent/  
运行负责下载依赖脚本：

    ./Scripts/bootstrap.sh  

**若运行报很多Error错误，如：**

    “Error: Unable to resolve path to module `js/http`, `js/tree` etc on running `./Scripts/bootstrap.sh`”  
可在命令末尾加“-d”参数运行：

    ./Scripts/bootstrap.sh -d  
结束。

###### 4.2.2.1.2 下载Appium Server里的：
    where appium
得到：

    /Users/renyi/DevTools/npm-global/bin/appium
cd进入appium server所在的npm仓库：

    cd /Users/renyi/DevTools/npm-global
find查找WebDriverAgent：

    find . -iname WebDriverAgent
得到：

    /Users/renyi/DevTools/npm-global/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
cd进入：

    cd xx/WebDriverAgent/  
运行负责下载依赖脚本：

    ./Scripts/bootstrap.sh  
结束。

###### 整合后一步执行命令：
    bash `find /Applications/Appium.app/Contents -iname WebDriverAgent`/Scripts/bootstrap.sh    # 下载Appium Desktop里的
    bash `find $(dirname $(dirname $(where appium))) -iname WebDriverAgent`/Scripts/bootstrap.sh    # 下载Appium Server里

##### 4.2.2.2 修改WebDriverAgent项目的签名信息：

**1) 打开WebDriverAgent目录：**

    open `find /Applications/Appium.app/Contents -iname WebDriverAgent`
    open `find $(dirname $(dirname $(where appium))) -iname WebDriverAgent`

**2) 打开WebDriverAgent项目文件：**  
找到WebDriverAgent.Xcodeproj文件，右键用Xcode打开

**3) 修改WebDriverAgentRunner-Target的签名信息：**  
3.1) General标签页-Signing：  
&emsp;&emsp;修改Team和Signing Cerificate信息；  
3.2) General标签页-Identity：  
&emsp;&emsp;修改Bundel Identifier；  
或者 Build Settings标签页-Packaging：  
&emsp;&emsp;修改Product Bundel Identifier；  
3.3) Build Phases标签页-Copy Frameworks：  
&emsp;&emsp;添加RoutingHTTPServer.framework框架（在Frameworks目录下）。  

##### 4.2.2.3 修改Target:WebDriverAgentLib-Target的签名信息：
同《4.2.2.2 修改WebDriverAgent的签名信息(使用Xcode工具)》。


##### 4.2.2.4 Test运行WebDriverAgent，测试重签名是否成功：  
1) Xcode上Build运行项目。   
2) 点击Project-》Test项，运行测试case，验证运行是否正常。  
    （WebDriverAgentRunner程序入口：UITestingUITests.m）  

---

#### 4.2.3 Optional Setup：

##### 4.2.3.1 For real devices we can use xcpretty to make Xcode output more reasonable. This can be installed by: 

    gem install xcpretty
（需管理员权限，加sudo安装）

##### 4.2.3.2 Install FBSimulatorControl for better handling of various iOS Simulator operations, such as: biometrics, geolocation setting and window focussing.
    # Get the Facebook Tap.
    brew tap facebook/fb
    # Install fbsimctl from master
    brew install fbsimctl --HEAD

##### 4.2.3.3 Install [AppleSimulatorUtils](https://github.com/wix/AppleSimulatorUtils) to use the [permissions capability](https://github.com/appium/appium-xcuitest-driver#desired-capabilities).

---


============================================================

## 五、运行测试：

### 5.1 Simulator Running（忽略）。

### 5.2 Real Device Running: 

#### 5.2.1.Native App:
1.激活手机“开发者选项”：  
    插上手机，随便build一个项目（如WebDriverAgent），即可激活。  
2.Test运行WebDriverAgent应用，让手机上安装上该应用。  
3.配置Desired Capabilities：  
3.1 查询真机udid：  
    idevice_id -l  
    (自己6s的udid：eebf7f211d670fc1feb34b20c30a1b07581b18a2)  
3.2 查看手机上所有安装了的应用的bundleId：  
    ideviceinstaller -l  
    (微信Bundle ID：com.tencent.xin)  
3.3 查看XcodeOrgId和XcodeSigningId(不必要，若报错则需要添加)：  
    打开Xcode-》General标签页-》Signing-》Signing  Cerificate-》鼠标hover查看XcodeOrgId全称  
    (我的"XcodeOrgId": "K3YBJJ6H2L"和"XcodeSigningId": "iPhone Developer")  
启动微信的示例json串如下：  
{  
  "platformName": "ios",  
  "deviceName": "iPhone 6S",  
  "automationName": "XCuiTest",  
  "platformVersion": "10.3.3",  
  "udid": "eebf7f211d670fc1feb34b20c30a1b07581b18a2",  
  "bundleId": "com.che168.AutoTraderCloud"  
}  
4 点击Start Session运行  
5.可通过Appium-Inspector工具抓元素坐标  

#### 5.2.2 Hybrid App
1.将电脑的Safari配置出“开发者选项”，并勾选“允许远程自动化”：  
网上教程：https://jingyan.baidu.com/article/9faa72318dfca5473d28cb61.html  
2.同上Native App安装步骤。  
3.若遇到H5内嵌页面，可使用电脑Safari确定元素坐标：  
    Safari菜单--》“开发”--》“任羿 的 iPhone 6S”--》选对应的网页地址  



