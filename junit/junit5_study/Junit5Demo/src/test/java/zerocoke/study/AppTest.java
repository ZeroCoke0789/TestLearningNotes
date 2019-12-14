package zerocoke.study;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 *
 * 用例管理的实际应用举例——App自动化测试用例管理
 * 基类的@BeforeClass：
 *      配置读取、配置Capability、初始化driver、安装App，PageObject初始化
 * 集成的子类执行流程
 *      @BeforeClass：进图特定的tab子功能页面
 *      @Before：启动并进入特定界面
 *      @Test：测试用例执行
 *      @After：回退到入口
 *      @AfterClass：关闭app
 * 基类的@AfterClass
 *      driver.quit
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
