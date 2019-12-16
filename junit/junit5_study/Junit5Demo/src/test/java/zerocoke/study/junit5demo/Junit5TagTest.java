package zerocoke.study.junit5demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * 4.5 @RunWith+@SelectPackages+@IncludeTags
 * 在testcasedemo.demo2.TestDemo2的方法testDemo2上加上注解@Tag:
 */
public class Junit5TagTest {

    @BeforeEach
    void beforeEachTest() {
        System.out.println("我是@BeforeEach，执行用例前先执行我");
    }

    @Test
    @Tag("TagDemo")
    void test1() {
        System.out.println("junit5 test1() 运行");
    }

    @AfterEach
    void afterEach() {
        System.out.println("我是@AfterEach，执行用例后再执行我");
    }
}
