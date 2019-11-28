package zerocoke.study;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Junit4Demo 2.7 - SuiteTest 测试套件
 *
 * 关键字：
 *   RunWith
 *   SuiteClasses
 *   class
 *
 * 实操演示：
 *   利用子类Junit4DemoChildren2Test，继承Junit4MethodTest.
 *   再建一个测试类SuitesTest，写上注解@RunWith(Suite.class)，表明这是一个测试套件，是多个测试类的一个集合，一个容器.
 *   然后利用注解@Suite.SuiteClasses来设置测试类集合，设置测试类执行的顺序.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Junit4DemoTest.class
        ,Junit4DemoChildren2Test.class
        ,Junit4MethodTest.class
        ,Junit4DemoChildrenTest.class
})
public class SuiteTest {


}
