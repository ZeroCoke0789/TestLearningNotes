package zerocoke.study.junit5demo;

import org.junit.jupiter.api.*;

/**
 * Junit5 03 - @Method Test
 */
public class Junit5MethodTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("我是@BeforeAll，测试类执行前要先执行我");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("我是@BeforeEach，测试用例执行前要先执行我");
    }

    @Test
    @Disabled    // 5）在测试用例test1上加入注解@Disabled，使test1失效
    @DisplayName("测试用例1")    // 6）分别将test1和test2用@DisplayName加上用例展示名称
    void test1() {
        System.out.println("junit5 test1() 运行");
    }

    @Test
    @DisplayName("测试用例2")    // 6）分别将test1和test2用@DisplayName加上用例展示名称
    void test2() {
        System.out.println("junit5 test2() 运行");
    }

    @DisplayName("测试用例3")
    @RepeatedTest(3)            // 7）对测试用例2加上注解@RepeatedTest,使其额外重复执行3次。用这个就不要用@Test了，用重复调用警告。
    void test3() {
        System.out.println("junit5 test3() 运行");
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
