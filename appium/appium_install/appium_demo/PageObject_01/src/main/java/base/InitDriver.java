package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class InitDriver {

    /**
     * 每次新装App启动driver
     *
     * @return
     * @throws MalformedURLException
     */
    public static AndroidDriver<AndroidElement> initDriverByInstall() throws MalformedURLException {
        // 获取app地址：app.getAbsolutePath()
        File classpathRoot = new File(System.getProperty("user.dir"));    // Path to project folder
        File appDir = new File(classpathRoot, "/app/");             // Path to <project folder> -> App folder
        File app = new File(appDir, "AutoTraderCloud_csy.apk");    // Path to App folder -> App file, app.getAbsolutePath()
        // 配置参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsumg S6");
        capabilities.setCapability(MobileCapabilityType.UDID, "04157df4b8b1a722");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // 走app
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        // 附加
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);              // 加长session超时
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);           // 不重签名，防因加固措施app出错
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);                // 每次测试不重置应用
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);    // 让Appium自动赋予app权限（若noReset=true则不工作）
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);  // 中文
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);    // 中文
        // 启动
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }

    /**
     * 使用已有App启动driver
     *
     * @return
     * @throws MalformedURLException
     */
    public static AndroidDriver<AndroidElement> initDriver() throws MalformedURLException {
        // 配置参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung S6");
        capabilities.setCapability(MobileCapabilityType.UDID, "04157df4b8b1a722");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // 走AppPackage和AppActivity
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.che168.autotradercloud");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.che168.autotradercloud.launch.LaunchActivity");
        // 附加
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);              // 加长session超时
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);           // 不重签名，防因加固措施app出错
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);                // 每次测试不重置应用
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);    // 让Appium自动赋予app权限（若noReset=true则不工作）
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);  // 中文
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);    // 中文
        // 启动
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        AppiumDriver<AndroidElement> driver = initDriverByInstall();
//        AppiumDriver<AndroidElement> driver = initDriver();
        Thread.sleep(10000);
        driver.quit();
    }

}
