package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaiduSearchPage02 {

    public static final Logger LOG = LoggerFactory.getLogger(BaiduSearchPage02.class);
    @FindBy(how = How.NAME, using = "wd")
    @CacheLookup    // 缓存页面定位
    private WebElement serachBox;

    public void searchFor(String keyword) {
        serachBox.sendKeys(keyword);
        serachBox.submit();
    }

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.baidu.com");
        BaiduSearchPage02 baiduPage = PageFactory.initElements(driver, BaiduSearchPage02.class);
        LOG.info("before search url is:{}", driver.getCurrentUrl());
        baiduPage.searchFor("blueshen");
        LOG.info("after search url is:{}", driver.getCurrentUrl());
    }
}
