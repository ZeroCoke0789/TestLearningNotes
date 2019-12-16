package zerocoke.study.junit5demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Junit5 01
 *
 * 3）添加用例@Test，再在用例执行前后添加@BeforeEach、@AfterEach:
 */
public class Junit5DemoTest {    // 注意：类名要包含Test，否则Junit默认会跳过不带Test的测试Case。

    @BeforeEach
    void beforeEachTest() {
        System.out.println("我是@BeforeEach，执行用例前先执行我");
    }

    @Test
    void test1() {
        System.out.println("junit5 test1() 运行");
    }

    @AfterEach
    void afterEach() {
        System.out.println("我是@AfterEach，执行用例后再执行我");
    }
}
