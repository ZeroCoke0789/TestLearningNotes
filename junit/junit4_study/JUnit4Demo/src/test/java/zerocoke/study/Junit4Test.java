package zerocoke.study;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void testDemoA() {
        System.out.println("testDemoA");
        assertTrue(false);
    }

    @Test
    public void testDemoB() {
        System.out.println("testDemoB");
        assertTrue(true);
    }

}

/**
 * App自动化测试用例管理：
 *
 * 基类的@BeforeClass：
 *  配置读取、配置Capability、初始化driver、安装App，PageObject初始化
 *
 * 集成的子类执行流程：
 *  @Before：启动并进入特定界面
 *  @Test：测试用例执行
 *  @After：回退到入口
 *  @BeforeClass：进图特定的tab子功能页面
 *  @AfterClass：关闭app
 *
 * 基类的@AfterClass：
 *  driver.quit
 */
