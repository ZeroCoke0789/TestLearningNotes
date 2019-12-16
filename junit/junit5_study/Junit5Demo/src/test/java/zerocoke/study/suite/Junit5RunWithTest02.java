package zerocoke.study.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * 4.2 @RunWith+@SelectPackages+@IncludePackages
 * @RunWith+@SelectPackages+@IncludePackages配合使用过滤出需要执行的测试包testcasedemo.demo2
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({
        "zerocoke.study.junit5demo",
        "zerocoke.study.testdemo"
})
@IncludePackages({          // 过滤需要执行的测试包（在@SelectPackages里再按@IncludePackages过滤要执行的CASE）
        "zerocoke.study.testdemo.demo2"
})
public class Junit5RunWithTest02 {
}
