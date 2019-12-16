package zerocoke.study;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Junit4Demo 2.4 - Junit4MethodSortersTest 用例间的执行顺序
 *
 * Junit4的执行顺序：
 *   Default 取决于反射方法获得的列表，顺序固定（不保险）
 *   @FixMethodOrder(MethodSorters.JVM) 顺序可能变化
 *   @FixMethodOrder(MethodSorters.NAME_ASCENDING) 按照名字ASCII顺序（稳定常用，建议使用）
 *
 * TestNG、Junit5的执行顺序:
 *   可以通过注解设置顺序Order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Junit4MethodSortersTest {

    @Test
    public void testDemoC() {
        assertTrue(true);
    }

    @Test
    public void testDemoA() {
        assertTrue(false);
    }

    @Test
    public void testDemoB() {
        assertTrue(true);
    }

}
