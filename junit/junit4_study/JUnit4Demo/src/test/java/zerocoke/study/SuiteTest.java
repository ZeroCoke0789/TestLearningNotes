package zerocoke.study;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Junit4DemoSuiteTest
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
