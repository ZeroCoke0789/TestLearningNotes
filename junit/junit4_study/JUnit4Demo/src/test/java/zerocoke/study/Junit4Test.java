package zerocoke.study;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Junit4Test
 *
 * Junit4基础介绍：
 *   https://blog.csdn.net/weixin_43291944/article/details/101980554
 *
 * Junit4 & Allured报告：
 *   https://blog.csdn.net/weixin_43291944/article/details/102560063
 * 指定 `mvn clean test` -> `allure serve allure-results` 生成测试报告
 *
 * Junit4系列介绍：
 *   https://blog.csdn.net/weixin_43291944/article/category/9098942
 *
 * Allure报告生成踩坑与持续集成方法：
 *   https://testerhome.com/topics/16998
 */
public class Junit4Test {

    @BeforeClass
    public static void beforeAllTestCase() {
        System.out.println("==我是@BeforeClass，我是运行第一步==");
    }

    @AfterClass
    public static void afterAllTestCase() {
        System.out.println("==我是@AfterClass，我是运行最后一步==");
    }

    @Before
    public void beforeTestCase() {
        System.out.println("--我是@before，用例执行前先到我这--");
    }

    @After
    public void afterTestCase() {
        System.out.println("--我是@after，用例执行后到我这--");
    }

    @Test
    public void testDemoC() {
        System.out.println("testDemoC");
        assertTrue(true);
    }

    @Test
    @DisplayName("测试用例： Junit4Test - TestDemoC")
    @Description("演示打印描述")
    @Link("https://www.baidu.com")
    @Link(name = "bugAddress", type = "mylink")
    @Issue("002")
    @Severity(SeverityLevel.BLOCKER)
    public void testDemoA() {
        System.out.println("testDemoA");
        assertTrue(false);
    }

    @Test
//    @Step("login step")    // @Step()会报错，禁止使用
    public void testLogin() {
        System.out.println("Run testLogin()");
    }

//    @Test
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public void testAttachment() {
//        System.out.println("Run testAttachment()");
//    }

//    @Test
//    public void testAttachment02() {
//        System.out.println("Run testAttachment02()");
//        Allure.addAttachment("My attachment", "My attachment content");
//
//        Path content = Paths.get("path-to-my-attachment-contnet");
//        try {
//            InputStream is = Files.newInputStream(content);
//            Allure.addAttachment("My attachment", is);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testDemoB() {
        System.out.println("testDemoB");
        assertTrue(true);
    }

}
