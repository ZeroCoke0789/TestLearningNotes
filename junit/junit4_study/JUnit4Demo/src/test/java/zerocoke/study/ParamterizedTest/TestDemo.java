package zerocoke.study.ParamterizedTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Junit4Demo 2.9 - 参数化@Paramterized
 *
 * 有时候我们需要传入测试数据，且数据可能是多组，这个时候就需要使用参数化来传入多组数据进行测试.
 */
@RunWith(Parameterized.class)    // 1）先在类名上加入注解@RunWith(Parameterized.class)表明要以参数化运行
public class TestDemo {

    @Parameterized.Parameters    // 2）用注解@Parameterized.Parameters来设定数据源
    public static Object[] data() {
        return new Object[][] {
            {1,2},
            {3,4},
            {5,6},
            {99,100}
        };
    };

    @Parameterized.Parameter(0)    // 3）最后用注解@Parameterized.Parameter来指定数据源数据对应的参数
    public int A;

    @Parameterized.Parameter(1)    // 3）最后用注解@Parameterized.Parameter来指定数据源数据对应的参数
    public int B;

    @Test
    public void paramTest() {
        System.out.println("A="+ A + ", B=" + B);
    }

}
