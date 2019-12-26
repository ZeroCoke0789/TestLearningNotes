package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @FindBy(id="...")
 *  @FindBy(className="...")
 *  @FindBy(name="...")
 *  @FindBy(xpath="...")
 *  @FindBy(linkText="...")
 *  @FindBy(partialLinkText="...")
 *  @FindBy(tagName="...")
 *  @FindBy(css="...")
 */
public class BaiduSearchPage03 {

    public static final Logger LOG = LoggerFactory.getLogger(BaiduSearchPage03.class);
    @FindBy(name = "wd")
    @CacheLookup     // 缓存页面定位
    private WebElement serachBox;

    public void searchFor(String keyword) {
        serachBox.sendKeys(keyword);
        serachBox.submit();
    }

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.baidu.com");
        BaiduSearchPage03 baiduPage = PageFactory.initElements(driver, BaiduSearchPage03.class);
        LOG.info("before search url is:{}", driver.getCurrentUrl());
        baiduPage.searchFor("blueshen");
        LOG.info("after search url is:{}", driver.getCurrentUrl());
    }
}
