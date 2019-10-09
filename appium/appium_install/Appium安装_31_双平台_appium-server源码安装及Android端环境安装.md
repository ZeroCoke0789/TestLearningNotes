# Appium安装_31_双平台_appium-server源码安装及Android端环境安装

介绍在Windows电脑或Mac电脑上，若想通过源码安装appium-server并用其进行自动化测试，在对Android端的安装及运行测试的过程。  
注意：  
1.因非Mac系统不能进行iOS端自动化测试，因此Windows平台上只能进行Android端测试。  
2.此介绍只讲解Appium的安装过程，关于npm、adb等依赖不做介绍，想装请见《安装准备》文档。

---

[TOC]

---

## 一、Appium源码安装：

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

---

待完善
