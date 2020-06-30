package pageobjects;

import base.InitDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class LoginPage {
    private AndroidDriver driver = null;

    private MobileElement inputAccount;    // 账号输入框
    private MobileElement inputPassword;    // 密码输入框
    private MobileElement btnLogin;    // 登录按钮

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.inputAccount = (MobileElement) driver.findElement(By.id("itv_account"));
        this.inputPassword = (MobileElement) driver.findElement(By.id("itv_password"));
        this.btnLogin = (MobileElement) driver.findElement(By.id("tv_login"));
    }

    public void logIn(String account, String password) {
        inputAccount.click();
        inputAccount.clear();
        inputAccount.sendKeys(account);
        inputPassword.click();
        inputPassword.click();
        inputPassword.sendKeys(password);
        btnLogin.click();
    }

    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = InitDriver.initDriver();
            Thread.sleep(10000);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.logIn("15611110056", "tt123456");
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
