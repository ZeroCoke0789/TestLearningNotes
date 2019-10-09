# Appium安装-Windows平台Appium Server安装

介绍若使用从appium官网下载的source-zip包如何安装appium服务，以及如何运行被测应用。  
（因Windows平台不支持iOS端自动化，因此以下只介绍Android端的Appium安装。）

[TOC]

---

## 二、Appium源码安装：
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
