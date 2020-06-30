# 08_Appium安装及配置_双平台Android端_appium-server源码安装

介绍在Windows电脑或Mac电脑上，若想通过源码安装appium-server并用其进行自动化测试，在对Android端的安装及运行测试的过程。  
注意：  
1.因非Mac系统不能进行iOS端自动化测试，因此Windows平台上只能进行Android端测试。  
2.此介绍只讲解Appium的安装过程，关于npm、adb等依赖不做介绍，想装请见《安装准备》文档。  
3.以下介绍参考自 https://testerhome.com/topics/5874 文章，谢谢分享。

---

[TOC]

---

## 一、Appium Server源码安装：

##### 1.从appium官网下载最新appium源码：
    https://github.com/appium/appium-desktop/releases/latest
    从上面地址下载最新appium源码

##### 2.解压appium：
    将下载的zip源码解压，放到想放的地方。

##### 3.cd进入appium源码目录，执行“npm install”安装node依赖：
    输入`npm install --registry=https://registry.npm.taobao.org`

##### 4.将appium link到系统：
    输入`npm link`

##### 5.npm安装appium client：
    输入`npm install wd --registry=https://registry.npm.taobao.org`

##### 6.npm安装appium-doctor：
    输入`npm install -g appium-doctor --registry=https://registry.npm.taobao.org`

##### 7.检查appium是否安装好了：
    输入`appium -v`

##### 8.检查appium环境是不是都配好了：
    输入`appium-doctor`

##### 9.下载问题答疑：
下载不下来时两必备参数：  
Appium Install：  
    `--registry=https://registry.npm.taobao.org`  
Chromedriver Install：  
    `--chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver`

---

## 二、下载安装Appium Client

[AppiumServer&AppiumClient&AppiumGUI 分别是什么？有什么区别？](https://testerhome.com/topics/11101)

appium server是一个web接口服务，它只管接受http请求，而负责将各个语言的测试脚本翻译成appium的http请求与server端通讯的程序，叫appium client。想要运行Appium测试，还需要下载该程序。

其各client的Github子项目地址如下：

| Language/Framework | Github Repo and Installation Instructions |
| -- | -- |
| Ruby | https://github.com/appium/ruby_lib |
| Python | https://github.com/appium/python-client | 
| Java | https://github.com/appium/java-client |
| JavaScript (Node.js) | https://github.com/admc/wd |
| Objective C | https://github.com/appium/selenium-objective-c |
| PHP | https://github.com/appium/php-client |
| C# (.NET) | https://github.com/appium/appium-dotnet-driver |
| RobotFramework | https://github.com/jollychang/robotframework-appiumlibrary |

#### Java:

###### Maven
Add the following to pom.xml:

```xml
<dependency>
  <groupId>io.appium</groupId>
  <artifactId>java-client</artifactId>
  <version>${version.you.require}</version>
  <scope>test</scope>
</dependency>
```
If it is necessary to change the version of Selenium then you can configure pom.xml like following:

```xml
<dependency>
  <groupId>io.appium</groupId>
  <artifactId>java-client</artifactId>
  <version>${version.you.require}</version>
  <scope>test</test>
  <exclusions>
    <exclusion>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
    </exclusion>
  </exclusions>
</dependency>

<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>${selenium.version.you.require}</version>
</dependency>
```

###### Maven Repository: https://mvnrepository.com/artifact/io.appium/java-client

配置或下载jar包皆可

---

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
    打开cmd，然后输入appium，启动appium服务即可。

##### 5.运行测试脚本，启动被测App，开始测试：
```json
{
  "platformName": "Android",
  "platformVersion": "7.0",
  "deviceName": "Samsung S6",
  "appPackage": "com.alibaba.android.rimet",
  "appActivity": ".biz.LaunchHomeActivity"
}
```
待补充

[Getting Started](https://appium.io/docs/en/about-appium/getting-started/)

