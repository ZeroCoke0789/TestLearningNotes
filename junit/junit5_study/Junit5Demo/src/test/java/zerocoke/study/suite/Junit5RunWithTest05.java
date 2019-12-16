package zerocoke.study.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * 4.5 @RunWith+@SelectPackages+@IncludeTags
 * 在testcasedemo.demo2.TestDemo2的方法testDemo2上加上注解@Tag:
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({
        "zerocoke.study.junit5demo",
        "zerocoke.study.testdemo"
})
@IncludeTags({"TagDemo"})
public class Junit5RunWithTest05 {
}
