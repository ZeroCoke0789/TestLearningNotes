package zerocoke.study.SuiteTest02;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

/**
 * TestDemo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDemo {

    @Test
    @Category(SlowGroup.class)
    public void testDemoC() {
        System.out.println("我是testDemoC，属于SlowGroup.");
        assertTrue(true);
    }

    @Test
    @Category(FastGroup.class)
    public void testDemoA() {
        System.out.println("我是testDemoA，属于FastGroup.");
        assertTrue(true);
    }

    @Test
    @Category({SlowGroup.class, FastGroup.class})
    public void testDemoB() {
        System.out.println("我是testDemoB，同时属于FastGroup、SlowGroup.");
        assertTrue(true);
    }
}
