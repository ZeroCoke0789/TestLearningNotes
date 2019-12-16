package zerocoke.study.testdemo.demo2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Junit5 01
 *
 * 3）添加用例@Test，再在用例执行前后添加@BeforeEach、@AfterEach:
 */
public class Junit5DemoTest {

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
