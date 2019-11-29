package zerocoke.study.CategoriesTest;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Junit4Demo 2.8 - 分组测试-@Category
 *
 * 有时候我们需要对一些特定的用例进行分组测试，这个时候就可以用@Category来实现.
 *
 * @Category分组需要给定一个标签，以类或者接口都可以，这里创建连个接口SlowGroup和FastGroup.
 *
 * 在用例上分别分组为SlowGroup、FastGroup和SlowGroup+FastGroup.
 */

// 在套件执行类上添加注解：
@RunWith(Categories.class)    // 固定写法，指明以Category方式分组
@Categories.IncludeCategory(SlowGroup.class)     // 指明要执行的测试分组包含哪些
// @Categories.ExcludeCategory(FastGroup.class)     // 指明要执行的测试分组不包含哪些
@Suite.SuiteClasses({                            // 指明要执行的测试类
        TestDemo.class
})
public class SuiteTest02 {

}



