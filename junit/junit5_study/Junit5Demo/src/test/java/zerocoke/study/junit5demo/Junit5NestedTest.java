package zerocoke.study.junit5demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Junit5NestedTest {

    @Test
    @DisplayName("外层测试的Case")
    void outerTest() {
        System.out.println("外层测试输出");
    }

    @Nested
    @DisplayName("内层测试1(类)")
    class Inner {
        @Test
        @DisplayName("内层测试1的Case")
        void innerTest() {
            System.out.println("内层测试1输出");
        }

        @Nested
        @DisplayName("内层测试1嵌套(类)")
        class InInner {
            @Test
            @DisplayName("内层测试1嵌套的CASE")
            void inInnerTest() {
                System.out.println("内层测试1嵌套内层输出");
            }
        }
    }

    @Nested
    @DisplayName("内层测试2(类)")
    class Inner2 {
        @Test
        @DisplayName("内层测试2的CASE")
        void innerTest2() {
            System.out.println("内层测试2输出");
        }
    }

}
