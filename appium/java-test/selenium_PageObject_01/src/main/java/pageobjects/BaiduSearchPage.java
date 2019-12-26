package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaiduSearchPage {
    public static final Logger LOG = LoggerFactory.getLogger(BaiduSearchPage.class);
    private WebElement wd;

    public void searchFor(String keyword) {
        wd.sendKeys(keyword);
        wd.submit();
    }

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.baidu.com");
        BaiduSearchPage baiduPage = PageFactory.initElements(driver, BaiduSearchPage.class);
        LOG.info("before search url is:{}", driver.getCurrentUrl());
        baiduPage.searchFor("blueshen");
        LOG.info("after search url is:{}", driver.getCurrentUrl());
    }
}