
一、准备工作：
-----
基本工具：Homebrew／node／npm／SDKMAN

brew的更新及命令介绍：
1.brew update：更新brew
2.brew install xxx：安装xxx
3.brew uninstall xxx：卸载xxx
4.brew upgrade xxx：更新xxx版本

安装node和npm：
1.从官网下载LTS版本，然后安装即可获得node和npm。需用“node -v”和“npm -v”验证。
2.调整npm默认下载目录，以避免执行“npm install xxx”时的checkPermissions权限问题：
    打开 https://docs.npmjs.com/getting-started/fixing-npm-permissions 网址，按照方法2操作，修改npm默认目录（Option Two: Change npm's Default Directory）。
3.升级npm版本到最新版本：执行“npm install npm@latest -g”或“npm install npm -g”安装即可。

npm命令介绍：
1.npm install -g xxx：全局安装模块，会装在npm默认目录下。
2.npm install xxx：本地安装模块，会将安装包放在 ./node_modules 下（运行 npm 命令时所在的目录），如果没有 node_modules 目录，会在当前执行 npm 命令的目录下生成 node_modules 目录。
3.npm uninstall xxx：卸载模块
4.npm update xxx：更新模块
小建议：
(1)建议安装模块时要指定镜像，这样下载的快，如加上 “--registry=https://registry.npm.taobao.org”。
(2)不建议使用cnpm，因为cnpm有时候不好用，但想用的话，可参考 https://npm.taobao.org 网址。


============================================================


二、Appium源码安装：
---
（参考 https://testerhome.com/topics/5874 文章）
1.安装cnpm：npm install -g cnpm --registry=https://registry.npm.taobao.org
2.官网下载最新appium版本源码：
https://github.com/appium/appium-desktop/releases/latest
3.将下载的zip源码解压，放到想放的地方。
4.cd进入appium源码目录，执行“cnpm install”安装node依赖。
5.输入“cnpm link”，将appium link到系统。
6.npm安装appium client：npm install wd
7.npm安装appium-doctor：npm install -g appium-doctor
8.输入“appium-doctor”，查看appium环境是不是配好了。
9.输入“appium -v”，测试一下appium是否安好了。

下载不下来时两必备参数：
Appium Install：
    --registry=https://registry.npm.taobao.org
Chromedriver Install：
    --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver

============================================================

三、安装Appium驱动：
---
####Android驱动安装：
1.安装appium-android-driver:
npm install appium-android-driver --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver
2.安装appium-chromedriver:
npm install appium-chromedriver --chromedriver_version="2.16" --chromedriver_cdnurl=http://npm.taobao.org/mirrors/chromedriver
(安装appium时指定chromedriver安装：
npm install appium --chromedriver_cdnurl=http://npm.taobao.org/mirrors/chromedriver)

####iOS驱动安装：
#####Xcode7&iOS9.3以下驱动安装（引擎UIAutomation）：
Simulator Setup:
1.安装authorize-ios: 
    npm install -g authorize-ios --registry=https://registry.npm.taobao.org
    sudo authorize-ios
2.安装appium-ios-driver: 
    npm install appium-ios-driver --registry=https://registry.npm.taobao.org
3.配置iwd: 
Inside the repo, run the xcode-iwd.sh script included in the bin dir, passing it several arguments: 
(1) the path to the Xcode app you are using. 
(2) The path to the appium-instruments directory. 
For example:
    sh ./bin/xcode-iwd.sh /Applications/Xcode.app /Users/me/appium-instruments/

Real Device Setup:
1.build app。
2.安装ideviceinstaller: 
    brew install libimobiledevice
3.利用libimobiledevice安装app: 
    ideviceinstaller -u <UDID of your device> -i <path to your built app>

Hybrid H5 App:
1.安装ios-webkit-debug-proxy：
    brew install ios-webkit-debug-proxy
    <!-- brew uninstall ios-webkit-debug-proxy -->
-----
#####Xcode8 & iOS10以上驱动安装（引擎用XCuiTest）：
1.安装Carthage: 
    brew install carthage
2.安装iOS命令行神器libimobiledevice: 
    brew install --HEAD libimobiledevice -g
    brew install ideviceinstaller -g
3.安装ios-deploy: 
    brew install ios-deploy
4.For hybrid or web tests install: 
    brew install ios-webkit-debug-proxy
5.找到Appium里的WebDriverAgent项目: 
5.1 在Appium目录里查找：
    cd /Users/renyi/TestTools/appium
    find . -iname WebDriverAgent
    （得到“./node_modules/appium-xcuitest-driver/WebDriverAgent”）
5.2 在Appium.app里查找：
    find /Applications/Appium.app/Contents -iname WebDriverAgent
    (得到“/Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent”)
6.安装WebDriverAgent项目依赖：
6.1 进入WebDriverAgent目录：
    cd xx/WebDriverAgent/
6.1 运行下载依赖脚本：
    ./Scripts/bootstrap.sh
若运行报很多Error，如：
    “Error: Unable to resolve path to module `js/http`, `js/tree` etc on running `./Scripts/bootstrap.sh`”
可在命令末尾加“-d”参数运行：
    ./Scripts/bootstrap.sh -d
    （排查文章学习）
7.使用Xcode工具对WebDriverAgent项目进行重签名：
7.1 进入WebDriverAgent目录：
    cd xx/WebDriverAgent/
7.2 双击WebDriverAgent.xcodeproj，用Xcode打开。
7.3 修改WebDriverAgentRunner-Target的签名信息（使用Xcode）：
（1）General标签页-Signing：
    修改Team和Signing Cerificate信息；
（2）General标签页-Identity：
    修改Bundel Identifier；
或者 Build Settings标签页-Packaging：
    修改Product Bundel Identifier；
（3）Build Phases标签页-Copy Frameworks：
    添加RoutingHTTPServer.framework框架（在Frameworks目录下）。
7.4 修改另一个Target，WebDriverAgentLib-Target的签名信息。
8.Test运行WebDriverAgent，测试重签名是否成功：
8.1 Xcode上点击运行按钮，Build项目。
8.2 点击Project-》Test项，运行测试case，验证运行是否正常。
    （WebDriverAgentRunner程序入口：UITestingUITests.m）
9.为混合型应用安装ios-webkit-debug-proxy：
    brew install ios-webkit-debug-proxy
(然后运行时配置 "startIWDP":true，即可让iOS获取到WebView。等同于输入命令：
    ios_webkit_debug_proxy -c udid_str:27753 -d
)

============================================================

iOS真机运行：
---
#####Native App:
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
3.3 查看xcodeOrgId和xcodeSigningId(不必要，若报错则需要添加)：
    打开Xcode-》General标签页-》Signing-》Signing Cerificate-》鼠标hover查看xcodeOrgId全称
    (我的"xcodeOrgId": "K3YBJJ6H2L"和"xcodeSigningId": "iPhone Developer")
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

#####Hybrid App
1.将电脑的Safari配置出“开发者选项”，并勾选“允许远程自动化”：
网上教程：https://jingyan.baidu.com/article/9faa72318dfca5473d28cb61.html
2.同上Native App安装步骤。
3.若遇到H5内嵌页面，可使用电脑Safari确定元素坐标：
    Safari菜单--》“开发”--》“任羿 的 iPhone 6S”--》选对应的网页地址


============================================================

其他：
1.执行“ideviceinstaller -l”异常时的处理方法：
执行一遍以下命令，重装一遍即可：
    brew uninstall ios-webkit-debug-proxy -g
    brew uninstall ideviceinstaller -g
    brew uninstall libimobiledevice -g
    brew install --HEAD libimobiledevice -g
    brew install ideviceinstaller -g
    brew install ios-webkit-debug-proxy
    sudo chmod -R 777 /var/db/lockdown
参考：https://testerhome.com/topics/7557
和 http://blog.csdn.net/qq_30534535/article/details/52670219



