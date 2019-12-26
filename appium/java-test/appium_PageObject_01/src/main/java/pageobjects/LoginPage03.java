package pageobjects;

import base.InitDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.time.Duration;


public class LoginPage03 {

    public static final Logger LOG = LoggerFactory.getLogger(LoginPage03.class);

    @AndroidFindBy(id = "itv_account")
    private MobileElement itvAccount;      // 账号输入框

    @AndroidFindBy(id = "itv_password")
    private MobileElement itvPassword;     // 密码输入框

    @AndroidFindBy(id = "tv_login")
    private MobileElement tvLogin;         // 登录按钮

    public void logIn(String account, String password) {
        itvAccount.click();
        itvAccount.clear();
        itvAccount.sendKeys(account);
        itvPassword.click();
        itvPassword.click();
        itvPassword.sendKeys(password);
        tvLogin.click();
    }

    public static void main(String[] args) {
        AppiumDriver driver = null;
        try {
            driver = InitDriver.initDriver();
            Thread.sleep(3000);
            LoginPage03 loginPage03 = new LoginPage03();
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), loginPage03);
            loginPage03.logIn("15611110056", "tt123456");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                driver.close();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

}
