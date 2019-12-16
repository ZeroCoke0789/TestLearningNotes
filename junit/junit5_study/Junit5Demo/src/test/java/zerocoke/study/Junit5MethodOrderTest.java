package zerocoke.study;

import org.junit.jupiter.api.*;

/**
 * Junit5 02 - Test Metheod Order
 *
 * 4）在测试类执行前后添加@BeforeAll和@AfterAll：
 */
public class Junit5MethodOrderTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("我是@BeforeAll，测试类执行前要先执行我");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("我是@BeforeEach，测试用例执行前要先执行我");
    }

    @Test
    void test1() {
        System.out.println("junit5 test1() 运行");
    }

    @Test
    void test2() {
        System.out.println("junit5 test2() 运行");
    }

    @AfterEach
    void afterEach() {
        System.out.println("我是@AfterEach，测试用例执行后会执行我");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("我是@AfterAll，测试类执行完了会执行我");
    }
}
