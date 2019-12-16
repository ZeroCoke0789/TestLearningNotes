package zerocoke.study.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * 4.3 @RunWith+@SelectPackages+@ExcludePackages
 * @RunWith+@SelectPackages+@ExcludePackages配合使用过滤出不需要执行的测试包testcasedemo.demo2
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({
        "zerocoke.study.junit5demo",
        "zerocoke.study.testdemo"
})
@ExcludePackages({          // 过滤不需要执行的测试包（在@SelectPackages里再按@ExcludePackages排除要执行的CASE）
        "zerocoke.study.testdemo.demo2"
})
public class Junit5RunWithTest03 {
}
