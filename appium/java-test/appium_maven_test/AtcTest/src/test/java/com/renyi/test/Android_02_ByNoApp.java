package com.renyi.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Android_02_ByNoApp {
	AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		// 设置DesiredCapabilities并启动driver
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Samsung S6"); // Android设备"deviceName"参数无效，无需配置。
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("appPackage", "com.che168.autotradercloud");
		capabilities.setCapability("appActivity", ".launch.LaunchActivity");
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");
		// capabilities.setCapability("noReset", "true");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// 设置隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 处理系统弹窗
		for (int i = 0; i < 3; i++) {
			if (driver.getPageSource().contains("允许")) {
				driver.switchTo().alert().accept();
			}
		}

		// 等待启动页进登录页
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		// 结束，截图
		Thread.sleep(2000);
		snapshot(driver, "test01.png");
		// 等待3秒退出
		driver.quit();
	}

	@Test
	public void test() {
		Writer out;
		try {
			out = new FileWriter(new File("getPageSource.txt"));
			out.write(driver.getPageSource());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 登录页-账号输入框 com.che168.autotradercloud:id/itv_account
		// 直接找
		// WebElement el1 =
		// driver.findElementById("com.che168.autotradercloud:id/itv_account");

		// 流畅等待
		// FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		// .withTimeout(10, TimeUnit.SECONDS) // 最大等待时间是10秒
		// .pollingEvery(250, TimeUnit.MILLISECONDS) // 每隔250毫秒去找一次元素e1是否在页面显示
		// .ignoring(NoSuchElementException.class) // 并且忽略NoSuchElement异常
		// .ignoring(TimeoutException.class);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.che168.autotradercloud:id/itv_account")));

		// 显示等待
		WebDriverWait wait = new WebDriverWait(driver, 10); // 找元素，如果元素存在则返回改对象，不存在则报错,超时时间10秒
		AndroidElement el = (AndroidElement) wait
				.until(ExpectedConditions.presenceOfElementLocated(By.id("com.che168.autotradercloud:id/itv_account")));
		el.click();
		el.sendKeys("15611110032");

		// 登录页-密码输入框 com.che168.autotradercloud:id/itv_password
		var el2 = (AndroidElement) driver.findElementById("com.che168.autotradercloud:id/itv_password");
		el2.sendKeys("tt123456");

		// 登录页-登录按钮 com.che168.autotradercloud:id/tv_login
		var el3 = (MobileElement) driver.findElementById("com.che168.autotradercloud:id/tv_login");
		el3.click();
	}

	/**
	 * This Method create for take screenshot
	 * this method will take screen shot ,require two parameters ,one is driver name, another is file name
	 *
	 * @author Young
	 * @param drivername
	 * @param filename
	 */
	public void snapshot(AppiumDriver drivername, String filename) {
		String currentPath = System.getProperty("user.dir");	// get current work folder
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			System.out.println("save snapshot path is: " + currentPath + File.separator + filename);
			FileUtils.copyFile(scrFile, new File(currentPath + File.separator + filename));
		} catch (IOException e) {
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished, it's in " + currentPath + " folder");
		}
	}

	private void excuteAdbShell(String s) {
		try {
			Runtime.getRuntime().exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
			e.printStackTrace();
		}
	}

}
