package pageobjects;

import base.InitDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage02 {
    public static final Logger LOG = LoggerFactory.getLogger(LoginPage02.class);
    private MobileElement itv_account;
    private MobileElement itv_password;
    private MobileElement tv_login;


    public void logIn(String account, String password) {
        itv_account.click();
        itv_account.clear();
        itv_account.sendKeys(account);
        itv_password.click();
        itv_password.click();
        itv_password.sendKeys(password);
        tv_login.click();
    }

    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = InitDriver.initDriver();
            Thread.sleep(10000);
//            LoginPage02 loginPage02 = PageFactory.initElements(driver, LoginPage02.class);
            LoginPage02 loginPage02 = new LoginPage02();
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), loginPage02);
            loginPage02.logIn("15611110056", "tt123456");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.close();
        }
    }

}
