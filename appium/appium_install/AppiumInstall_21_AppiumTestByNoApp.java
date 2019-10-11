package AndroidDemo;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Android_02_ByNoApp {
	AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		// Android设备"deviceName"参数无效，无需配置。
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", ".Calculator");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.findElementByName("1").click();
		driver.findElementByName("5").click();
		driver.findElementByName("9").click();

		driver.findElementByName("删除").click();
		driver.findElementByName("删除").click();
		driver.findElementByName("删除").click();

		driver.findElementByName("2").click();
		driver.findElementByName("+").click();
		driver.findElementByName("3").click();
		driver.findElementByName("=").click();

		driver.findElementByName("−").click();
		driver.findElementByName("6").click();
		driver.findElementByName("=").click();
	}

}
