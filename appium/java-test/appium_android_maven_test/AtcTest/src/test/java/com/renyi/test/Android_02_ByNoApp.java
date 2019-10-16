package com.renyi.test;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Android_02_ByNoApp {
	AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		// 设置DesiredCapabilities并启动driver
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Samsung S6");    // Android设备"deviceName"参数无效，无需配置。
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("appPackage", "com.che168.autotradercloud");
		capabilities.setCapability("appActivity", ".launch.LaunchActivity");
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");
		// capabilities.setCapability("noReset", "true");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// 处理系统弹窗
		for (int i = 0; i < 3; i++) {
			if (driver.getPageSource().contains("允许")) {
				driver.switchTo().alert().accept();
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		// 登录页-账号输入框 com.che168.autotradercloud:id/itv_account
		var el1 = (MobileElement) driver.findElementById("com.che168.autotradercloud:id/itv_account");
		el1.click();
		el1.sendKeys("测试专用豪华版");

		// 登录页-密码输入框 com.che168.autotradercloud:id/itv_password
		var el2 = (MobileElement) driver.findElementById("com.che168.autotradercloud:id/itv_password");
		el2.sendKeys("che168test!");

		// 登录页-登录按钮 com.che168.autotradercloud:id/tv_login
		var el5 = (MobileElement) driver.findElementById("com.che168.autotradercloud:id/tv_login");
		el5.click();
	}

}
