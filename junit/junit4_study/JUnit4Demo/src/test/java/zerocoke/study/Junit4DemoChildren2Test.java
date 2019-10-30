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
 * 继承关系下的测试流程： 将子类中的方法名进行修改，使其与父类方法名不同，再运行子类.
 *
 * 运行结果：
 *  除父类@Test方法外，会先执行父类中方法，再执行子类中的方法。
 *  @BeforeClass --> @ChildrenBeforeClass --> @ChildrenTest
 *  @AfterClass  <-- @ChildrenAfterClass  <-- @ChildrenTest
 */
public class Junit4DemoChildren2Test extends Junit4MethodTest {

    @BeforeClass
    public static void beforeAllTestCaseChildren() {
        System.out.println("==我是Children@BeforeClass，我是运行第一步==");
    }

    @AfterClass
    public static void afterAllTestCaseChildren() {
        System.out.println("==我是Children@AfterClass，我是运行最后一步==");
    }

    @Before
    public void beforeTestCaseChildren() {
        System.out.println("--我是Children@before，用例执行前先到我这--");
    }

    @After
    public void afterTestCaseChildren() {
        System.out.println("--我是Children@after，用例执行后到我这--");
    }

    @Test
    public void testDemoCChildren() {
        System.out.println("Children testDemoC");
        assertTrue(true);
    }

    @Test
    public void testDemoAChildren() {
        System.out.println("Children testDemoA");
        assertTrue(false);
    }

    @Test
    public void testDemoBChildren() {
        System.out.println("Children testDemoB");
        assertTrue(true);
    }

}
