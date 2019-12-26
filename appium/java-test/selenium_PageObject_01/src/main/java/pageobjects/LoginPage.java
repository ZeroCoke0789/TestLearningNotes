package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    // 用户名录入框
    private WebElement usernameBox;
    // 密码录入框
    private WebElement passwordBox;
    // 提交按钮
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!"Login".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
        this.usernameBox = driver.findElement(By.id("username"));
        this.passwordBox = driver.findElement(By.id("passwd"));
        this.submitButton = driver.findElement(By.id("login"));
    }

    public HomePage loginAs(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submitButton.submit();
        return new HomePage(driver);
    }
}