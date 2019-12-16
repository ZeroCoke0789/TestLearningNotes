package zerocoke.study.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * 4.4 @RunWith+@SelectPackages+@IncludeClassNamePatterns
 * 将junit5demo包下的TestJunit5demo和testcasedemo.demo2所有测试类过滤出来并执行
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({
        "zerocoke.study.junit5demo",
        "zerocoke.study.testdemo"
})
@IncludeClassNamePatterns({
        "zerocoke.study.junit5demo.Junit5MethodOrderTest",
        "zerocoke.study.testdemo.*"
})
public class Junit5RunWithTest04 {
}
