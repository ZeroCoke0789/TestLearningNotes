package zerocoke.study.suite;

/**
 * 4、Junit5套件执行
 * 注解	作用
 * @RunWith(JUnitPlatform.class) 执行套件(@RunWith 是从Junit4迁移过来的，@RunWith 连同它的参数 JUnitPlatform.class。)
 * @SelectPackage({"com.packageA","com.packageB"}) 创建测试套件
 * @SelectClasses( {a.class,b.class,c.class} )	创建测试套件
 * @IncludePackage(“包名”) 过滤需要执行的测试包
 * @ExcludePackages 过滤不需要执行的测试包
 * @IncludeClassNamePatterns 过滤需要执行的测试类
 * @ExcludeClassNamePatterns 过滤不需要执行的测试类
 * @IncludeTags("production") 过滤需要执行的测试方法
 * @ExcludeTags(“PROD”) 过滤不需要执行的测试方法
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「TesterAllen」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43291944/article/details/102483526
 */

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Junit5Demo - 4.1 @RunWith+@SelectPackages
 * 有两个包testcasedemo, junit5demo,利用@RunWith+@SelectPackages将包中测试类依次运行
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({       // 创建测试套件。注意：包名需要全路径的，如下。
        "zerocoke.study.junit5demo",
        "zerocoke.study.testdemo"
})
public class Junit5RunWithTest {
}
