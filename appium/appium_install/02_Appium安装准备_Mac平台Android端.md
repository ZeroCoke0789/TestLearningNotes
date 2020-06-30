# 02_Appium安装准备_Mac平台_Android端

安装JDK、nodejs、Android开发环境

---

[TOC]

---

## Android 端安装准备

### 一、安装JDK，并配置Java环境变量

百度即可，略

环境变量：  
export JAVA_HOME=JDK安装目录  
export CLASSPATH=".:%JAVA_HOME%\lib\dt.jar:%JAVA_HOME%\lib\tools.jar" 

---

### 二、更新Homebrew（brew命令）

因Mac自带Homebrew，因此只要更新即可，执行`brew update`即可。

#### brew的更新及命令介绍：  
1. `brew update`：更新brew  
2. `brew install xxx`：安装xxx模块  
3. `brew uninstall xxx`：卸载xxx模块  
4. `brew upgrade xxx`：更新xxx模块版本    

---

### 三、安装node，并配置npm

1. 官网下载node并安装：  
    从[nodejs官网](https://nodejs.org/en/)下载node，然后安装，即可获得node和npm。
2. 验证是否安装正常：  
    运行`node -v`和`npm -v`两命令，能输出版本号则证明能安装正常。  
3. 调整npm默认下载目录（`npm install`安装模块时checkPermissions报错对策）:  
    参考[Resolving EACCES permissions errors when installing packages globally](https://docs.npmjs.com/resolving-eacces-permissions-errors-when-installing-packages-globally)文章里“Manually change npm’s default directory”的部分，按其操作，修改npm默认目录即可。  
    （或者将`./node_modules`目录修改为777权限，也可避免此问题。`chmod -R 777 ./node_modules`）
3. 升级npm版本到最新版本：  
    执行`npm i npm@latest -g`或`npm install npm@latest -g`或`npm install npm -g`

#### npm命令介绍：  

1. `npm view <package> versions --json`：查看模块全部发布版本
2. `npm install (-g) <package>`：全局/本地安装模块。  
区别：  
* 全局安装(加-g) --》 模块会安装在npm默认目录下。  
* 本地安装 --》 模块会安装当前目录下的node_modules目录下(./node_modules/xx)，如果当前没有node_modules目录，则会先创建生成。  
3. `npm install (-g) <package>@<version>`：指定模块版本全局/本地安装模块，如`npm install -g appium@1.9.1`。
4. `npm list (-g)`: 查看所有全局/本地安装的模块。
5. `npm uninstall (-g)<package>`：卸载全局/本地已安装的模块  
6. `npm update (-g) <package>`：更新全局/本地模块    
7. `npm cache clear --force`：可以清空NPM本地缓存（慎用）。可用于对付使用相同版本号发布新版本代码的人。  
* `npm cache verify`：验证缓存(同最新的)是否是一致有效的。
8. `npm help <command>`：查看某条命令的详细帮助，例如`npm help install`。
9. npm模块下载建议：
    * 配上vpn翻墙再下载，因为很可能下载因网慢而下载半天。 
    * 指定npm镜像链接再下载：   
    指定npm下载镜像：`--registry=https://registry.npm.taobao.org`  
    指定chromedriver下载镜像：`-–chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver`  
    * 安装cnpm，然后用cnpm下载：  
    淘宝 NPM 镜像/cnpm网站：http://npm.taobao.org  
    cnpm安装模块：`cnpm install [name]`

### 四、Android 开发环境安装和配置

xxx

---

## 其他：

idb and idb-companion:
 https://swift.ctolib.com/facebook-idb.html
