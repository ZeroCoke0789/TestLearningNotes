package zerocoke.study;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit4DemoChildrenTest
 *
 * 继承关系下的测试流程：
 *
 * 流程顺序：
 *  父类@BeforeClass
 *  子类@BeforeClass
 *  父类@Before
 *  子类@Before
 *  子类@Test
 *  父类@Test
 *  子类@After
 *  父类@After
 *  子类@AfterClass
 *  父类@AfterClass
 *
 * 运行结果：
 *  子类会将与父类中一样的方法进行覆盖，只执行子类中的方法
 */
public class Junit4DemoChildrenTest extends Junit4MethodTest {

    @BeforeClass
    public static void beforeAllTestCase() {
        System.out.println("==我是Children@BeforeClass，我是运行第一步==");
    }

    @AfterClass
    public static void afterAllTestCase() {
        System.out.println("==我是Children@AfterClass，我是运行最后一步==");
    }

    @Before
    public void beforeTestCase() {
        System.out.println("--我是Children@before，用例执行前先到我这--");
    }

    @After
    public void afterTestCase() {
        System.out.println("--我是Children@after，用例执行后到我这--");
    }

    @Test
    public void testDemoC() {
        System.out.println("Children testDemoC");
        assertTrue(true);
    }

    @Test
    public void testDemoA() {
        System.out.println("Children testDemoA");
        assertTrue(false);
    }

    @Test
    public void testDemoB() {
        System.out.println("Children testDemoB");
        assertTrue(true);
    }

}
